package androidx.test.runner;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.UserHandle;
import android.util.Log;
import androidx.multidex.MultiDex;
import androidx.test.internal.platform.app.ActivityLifecycleTimeout;
import androidx.test.internal.runner.InstrumentationConnection;
import androidx.test.internal.runner.hidden.ExposedInstrumentationApi;
import androidx.test.internal.runner.intent.IntentMonitorImpl;
import androidx.test.internal.runner.intercepting.DefaultInterceptingActivityFactory;
import androidx.test.internal.runner.lifecycle.ActivityLifecycleMonitorImpl;
import androidx.test.internal.runner.lifecycle.ApplicationLifecycleMonitorImpl;
import androidx.test.internal.util.Checks;
import androidx.test.internal.util.ProcSummary;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.intent.IntentMonitorRegistry;
import androidx.test.runner.intent.IntentStubberRegistry;
import androidx.test.runner.intercepting.InterceptingActivityFactory;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.ApplicationStage;
import androidx.test.runner.lifecycle.Stage;
import java.lang.Thread;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.lang3.StringUtils;

public class MonitoringInstrumentation extends ExposedInstrumentationApi {
    private static final long MILLIS_TO_POLL_FOR_ACTIVITY_STOP;
    private static final long MILLIS_TO_WAIT_FOR_ACTIVITY_TO_STOP;
    private static final String TAG = "MonitoringInstr";
    private AtomicBoolean anActivityHasBeenLaunched = new AtomicBoolean(false);
    private ApplicationLifecycleMonitorImpl applicationMonitor = new ApplicationLifecycleMonitorImpl();
    private ExecutorService executorService;
    private volatile boolean finished = false;
    private Handler handlerForMainLooper;
    private MessageQueue.IdleHandler idleHandler = new MessageQueue.IdleHandler() {
        public boolean queueIdle() {
            MonitoringInstrumentation.this.lastIdleTime.set(System.currentTimeMillis());
            return true;
        }
    };
    private IntentMonitorImpl intentMonitor = new IntentMonitorImpl();
    private volatile InterceptingActivityFactory interceptingActivityFactory;
    private ThreadLocal<Boolean> isDexmakerClassLoaderInitialized = new ThreadLocal<>();
    /* access modifiers changed from: private */
    public AtomicBoolean isJsBridgeLoaded = new AtomicBoolean(false);
    private volatile Boolean isOriginalInstr = null;
    private String jsBridgeClassName;
    /* access modifiers changed from: private */
    public AtomicLong lastIdleTime = new AtomicLong(0);
    /* access modifiers changed from: private */
    public ActivityLifecycleMonitorImpl lifecycleMonitor = new ActivityLifecycleMonitorImpl();
    /* access modifiers changed from: private */
    public Thread.UncaughtExceptionHandler standardHandler;
    private AtomicInteger startedActivityCounter = new AtomicInteger(0);

    public class ActivityFinisher implements Runnable {
        public ActivityFinisher() {
        }

        public void run() {
            ArrayList<Activity> arrayList = new ArrayList<>();
            Iterator it = EnumSet.range(Stage.CREATED, Stage.STOPPED).iterator();
            while (it.hasNext()) {
                arrayList.addAll(MonitoringInstrumentation.this.lifecycleMonitor.getActivitiesInStage((Stage) it.next()));
            }
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                StringBuilder sb2 = new StringBuilder(60);
                sb2.append("Activities that are still in CREATED to STOPPED: ");
                sb2.append(size);
                Log.i(MonitoringInstrumentation.TAG, sb2.toString());
            }
            for (Activity activity : arrayList) {
                if (!activity.isFinishing()) {
                    try {
                        String valueOf = String.valueOf(activity);
                        StringBuilder sb3 = new StringBuilder(valueOf.length() + 20);
                        sb3.append("Finishing activity: ");
                        sb3.append(valueOf);
                        Log.i(MonitoringInstrumentation.TAG, sb3.toString());
                        activity.finish();
                    } catch (RuntimeException e11) {
                        Log.e(MonitoringInstrumentation.TAG, "Failed to finish activity.", e11);
                    }
                }
            }
        }
    }

    public static class StubResultCallable implements Callable<Instrumentation.ActivityResult> {
        private final Intent intent;

        public StubResultCallable(Intent intent2) {
            this.intent = intent2;
        }

        public Instrumentation.ActivityResult call() {
            return IntentStubberRegistry.getInstance().getActivityResultForIntent(this.intent);
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(2);
        MILLIS_TO_WAIT_FOR_ACTIVITY_TO_STOP = millis;
        MILLIS_TO_POLL_FOR_ACTIVITY_STOP = millis / 40;
    }

    private static Class<?> getMultiDexClass() throws ClassNotFoundException {
        Class<MultiDex> cls = MultiDex.class;
        try {
            int i11 = MultiDex.f36294a;
            return cls;
        } catch (ClassNotFoundException unused) {
            int i12 = MultiDex.f36294a;
            return cls;
        }
    }

    private List<String> getTargetProcessValues() {
        if (Build.VERSION.SDK_INT < 26) {
            return Collections.emptyList();
        }
        try {
            String a11 = getContext().getPackageManager().getInstrumentationInfo(getComponentName(), 0).targetProcesses;
            if (a11 == null) {
                a11 = "";
            }
            String trim = a11.trim();
            if (trim.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String trim2 : trim.split(",", -1)) {
                String trim3 = trim2.trim();
                if (trim3.length() > 0) {
                    arrayList.add(trim3);
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e11) {
            String valueOf = String.valueOf(getComponentName());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
            sb2.append("Cannot locate ourselves: ");
            sb2.append(valueOf);
            Log.wtf(TAG, sb2.toString(), e11);
            String valueOf2 = String.valueOf(getComponentName());
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 25);
            sb3.append("Cannot locate ourselves: ");
            sb3.append(valueOf2);
            throw new IllegalStateException(sb3.toString(), e11);
        }
    }

    private boolean isHostingProcess(String str, ProcSummary procSummary) {
        int length = str.length();
        int length2 = procSummary.cmdline.length();
        if (length == length2) {
            return str.equals(procSummary.cmdline);
        }
        if (length < length2 || !str.startsWith(procSummary.cmdline) || !str.endsWith(procSummary.f37705name)) {
            return false;
        }
        String valueOf = String.valueOf(procSummary);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + Opcodes.IF_ACMPEQ + str.length());
        sb2.append("Use smaller processNames in AndroidManifest.xml. Long names are truncated. This process's cmdline is a prefix of the processName and suffix of comm - assuming: ");
        sb2.append(valueOf);
        sb2.append(" is: ");
        sb2.append(str);
        Log.w(TAG, sb2.toString());
        return true;
    }

    private boolean isOriginalInstrumentationProcess() {
        Boolean bool = this.isOriginalInstr;
        if (bool == null) {
            bool = Boolean.valueOf(isOriginalUncached());
            this.isOriginalInstr = bool;
        }
        return bool.booleanValue();
    }

    private boolean isOriginalUncached() {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        List<String> targetProcessValues = getTargetProcessValues();
        if (targetProcessValues.isEmpty()) {
            return true;
        }
        boolean equals = "*".equals(targetProcessValues.get(0));
        if (targetProcessValues.size() == 1 && !equals) {
            return true;
        }
        try {
            ProcSummary summarize = ProcSummary.summarize("self");
            if (!equals) {
                return isHostingProcess(targetProcessValues.get(0), summarize);
            }
            String str = getTargetContext().getApplicationInfo().processName;
            if (str == null) {
                str = getTargetContext().getPackageName();
            }
            return isHostingProcess(str, summarize);
        } catch (ProcSummary.SummaryException e11) {
            Log.w(TAG, "Could not list apps for this user, running in sandbox? Assuming primary", e11);
            return false;
        }
    }

    private void logUncaughtExceptions() {
        this.standardHandler = Thread.currentThread().getUncaughtExceptionHandler();
        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th2) {
                String str;
                MonitoringInstrumentation.this.onException(thread, th2);
                if (MonitoringInstrumentation.this.standardHandler != null) {
                    Log.w(MonitoringInstrumentation.TAG, String.format("Invoking uncaught exception handler %s (a %s)", new Object[]{MonitoringInstrumentation.this.standardHandler, MonitoringInstrumentation.this.standardHandler.getClass()}));
                    MonitoringInstrumentation.this.standardHandler.uncaughtException(thread, th2);
                } else {
                    String valueOf = String.valueOf(thread.getName());
                    if (valueOf.length() != 0) {
                        str = "Invoking uncaught exception handler for thread: ".concat(valueOf);
                    } else {
                        str = new String("Invoking uncaught exception handler for thread: ");
                    }
                    Log.w(MonitoringInstrumentation.TAG, str);
                    thread.getThreadGroup().uncaughtException(thread, th2);
                }
                if (!"robolectric".equals(Build.FINGERPRINT) && Looper.getMainLooper().getThread().equals(thread)) {
                    Log.e(MonitoringInstrumentation.TAG, "The main thread has died and the handlers didn't care, exiting");
                    System.exit(-10);
                }
            }
        });
    }

    private void setupDexmakerClassloader() {
        Boolean bool = Boolean.TRUE;
        if (!bool.equals(this.isDexmakerClassLoaderInitialized.get())) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            ClassLoader classLoader = getTargetContext().getClassLoader();
            if (contextClassLoader != classLoader) {
                Log.i(TAG, String.format("Setting context classloader to '%s', Original: '%s'", new Object[]{classLoader, contextClassLoader}));
                Thread.currentThread().setContextClassLoader(classLoader);
            }
            this.isDexmakerClassLoaderInitialized.set(bool);
        }
    }

    private Instrumentation.ActivityResult stubResultFor(Intent intent) {
        if (!IntentStubberRegistry.isLoaded()) {
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return IntentStubberRegistry.getInstance().getActivityResultForIntent(intent);
        }
        FutureTask futureTask = new FutureTask(new StubResultCallable(intent));
        runOnMainSync(futureTask);
        try {
            return (Instrumentation.ActivityResult) futureTask.get();
        } catch (ExecutionException e11) {
            throw new RuntimeException(String.format("Could not retrieve stub result for intent %s", new Object[]{intent}), e11);
        } catch (InterruptedException e12) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e12);
        }
    }

    private void tryLoadingJsBridge(final String str) {
        if (str != null) {
            runOnMainSync(new Runnable() {
                public void run() {
                    try {
                        Class.forName(str).getDeclaredMethod("installBridge", new Class[0]).invoke((Object) null, new Object[0]);
                        MonitoringInstrumentation.this.isJsBridgeLoaded.set(true);
                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                        Log.i(MonitoringInstrumentation.TAG, "No JSBridge.");
                    } catch (IllegalAccessException | InvocationTargetException e11) {
                        throw new RuntimeException("JSbridge is available at runtime, but calling it failed.", e11);
                    }
                }
            });
            return;
        }
        throw new NullPointerException("JsBridge class name cannot be null!");
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        this.lifecycleMonitor.signalLifecycleChange(Stage.PRE_ON_CREATE, activity);
        super.callActivityOnCreate(activity, bundle);
        this.lifecycleMonitor.signalLifecycleChange(Stage.CREATED, activity);
    }

    public void callActivityOnDestroy(Activity activity) {
        super.callActivityOnDestroy(activity);
        this.lifecycleMonitor.signalLifecycleChange(Stage.DESTROYED, activity);
    }

    public void callActivityOnPause(Activity activity) {
        super.callActivityOnPause(activity);
        this.lifecycleMonitor.signalLifecycleChange(Stage.PAUSED, activity);
    }

    public void callActivityOnRestart(Activity activity) {
        super.callActivityOnRestart(activity);
        this.lifecycleMonitor.signalLifecycleChange(Stage.RESTARTED, activity);
    }

    public void callActivityOnResume(Activity activity) {
        super.callActivityOnResume(activity);
        this.lifecycleMonitor.signalLifecycleChange(Stage.RESUMED, activity);
    }

    public void callActivityOnStart(Activity activity) {
        this.startedActivityCounter.incrementAndGet();
        try {
            super.callActivityOnStart(activity);
            this.lifecycleMonitor.signalLifecycleChange(Stage.STARTED, activity);
        } catch (RuntimeException e11) {
            this.startedActivityCounter.decrementAndGet();
            throw e11;
        }
    }

    public void callActivityOnStop(Activity activity) {
        try {
            super.callActivityOnStop(activity);
            this.lifecycleMonitor.signalLifecycleChange(Stage.STOPPED, activity);
        } finally {
            this.startedActivityCounter.decrementAndGet();
        }
    }

    public void callApplicationOnCreate(Application application) {
        this.applicationMonitor.signalLifecycleChange(application, ApplicationStage.PRE_ON_CREATE);
        super.callApplicationOnCreate(application);
        this.applicationMonitor.signalLifecycleChange(application, ApplicationStage.CREATED);
    }

    public void execStartActivities(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent[] intentArr, Bundle bundle) {
        for (Intent execStartActivity : intentArr) {
            execStartActivity(context, iBinder, iBinder2, activity, execStartActivity, -1, bundle);
        }
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i11) {
        this.intentMonitor.signalIntent(intent);
        Instrumentation.ActivityResult stubResultFor = stubResultFor(intent);
        if (stubResultFor == null) {
            return super.execStartActivity(context, iBinder, iBinder2, activity, intent, i11);
        }
        Log.i(TAG, String.format("Stubbing intent %s", new Object[]{intent}));
        return stubResultFor;
    }

    public void f(String str) {
        Log.e("THREAD_STATE", g());
    }

    public void finish(int i11, Bundle bundle) {
        if (this.finished) {
            Log.w(TAG, "finish called 2x!");
            return;
        }
        this.finished = true;
        if (j()) {
            this.handlerForMainLooper.post(new ActivityFinisher());
            long currentTimeMillis = System.currentTimeMillis();
            l();
            Log.i(TAG, String.format("waitForActivitiesToComplete() took: %sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        }
        ActivityLifecycleMonitorRegistry.registerInstance((ActivityLifecycleMonitor) null);
        i();
        super.finish(i11, bundle);
    }

    public String g() {
        Set<Map.Entry<Thread, StackTraceElement[]>> entrySet = Thread.getAllStackTraces().entrySet();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : entrySet) {
            StringBuilder sb3 = new StringBuilder("  ");
            sb3.append(next.getKey());
            sb3.append(StringUtils.LF);
            for (StackTraceElement stackTraceElement : (StackTraceElement[]) next.getValue()) {
                sb3.append("    ");
                sb3.append(stackTraceElement.toString());
                sb3.append(StringUtils.LF);
            }
            sb3.append(StringUtils.LF);
            sb2.append(sb3.toString());
        }
        return sb2.toString();
    }

    public void h() {
    }

    public void i() {
        Thread.currentThread().setUncaughtExceptionHandler(this.standardHandler);
    }

    public void interceptActivityUsing(InterceptingActivityFactory interceptingActivityFactory2) {
        Checks.checkNotNull(interceptingActivityFactory2);
        this.interceptingActivityFactory = interceptingActivityFactory2;
    }

    public boolean j() {
        return Boolean.parseBoolean(InstrumentationRegistry.getArguments().getString("waitForActivitiesToComplete", "true"));
    }

    public void k() {
        System.getProperties().put("dexmaker.dexcache", getTargetContext().getDir("dxmaker_cache", 0).getAbsolutePath());
    }

    public void l() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            long currentTimeMillis = System.currentTimeMillis() + MILLIS_TO_WAIT_FOR_ACTIVITY_TO_STOP;
            int i11 = this.startedActivityCounter.get();
            while (i11 > 0 && System.currentTimeMillis() < currentTimeMillis) {
                try {
                    StringBuilder sb2 = new StringBuilder(37);
                    sb2.append("Unstopped activity count: ");
                    sb2.append(i11);
                    Log.i(TAG, sb2.toString());
                    Thread.sleep(MILLIS_TO_POLL_FOR_ACTIVITY_STOP);
                    i11 = this.startedActivityCounter.get();
                } catch (InterruptedException e11) {
                    Log.i(TAG, "Abandoning activity wait due to interruption.", e11);
                }
            }
            if (i11 > 0) {
                f("ThreadState-unstopped.txt");
                Log.w(TAG, String.format("Still %s activities active after waiting %s ms.", new Object[]{Integer.valueOf(i11), Long.valueOf(MILLIS_TO_WAIT_FOR_ACTIVITY_TO_STOP)}));
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot be called from main thread!");
    }

    public Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) throws InstantiationException, IllegalAccessException {
        String name2 = cls.getPackage().getName();
        String packageName = context.getPackageName();
        ComponentName component = intent.getComponent();
        if (!packageName.equals(component.getPackageName()) && name2.equals(component.getPackageName())) {
            intent.setComponent(new ComponentName(packageName, component.getClassName()));
        }
        return super.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
    }

    public void onCreate(Bundle bundle) {
        Log.i(TAG, "Instrumentation started!");
        logUncaughtExceptions();
        h();
        InstrumentationRegistry.registerInstance(this, bundle);
        androidx.test.InstrumentationRegistry.registerInstance(this, bundle);
        ActivityLifecycleMonitorRegistry.registerInstance(this.lifecycleMonitor);
        ApplicationLifecycleMonitorRegistry.registerInstance(this.applicationMonitor);
        IntentMonitorRegistry.registerInstance(this.intentMonitor);
        this.handlerForMainLooper = new Handler(Looper.getMainLooper());
        this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory(this) {
            public Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName(MonitoringInstrumentation.class.getSimpleName());
                return newThread;
            }
        });
        Looper.myQueue().addIdleHandler(this.idleHandler);
        super.onCreate(bundle);
        k();
        setupDexmakerClassloader();
        useDefaultInterceptingActivityFactory();
    }

    public void onDestroy() {
        Log.i(TAG, "Instrumentation Finished!");
        Looper.myQueue().removeIdleHandler(this.idleHandler);
        InstrumentationConnection.getInstance().terminate();
        super.onDestroy();
    }

    public boolean onException(Object obj, Throwable th2) {
        Log.e(TAG, String.format("Exception encountered by: %s. Dumping thread state to outputs and pining for the fjords.", new Object[]{obj}), th2);
        f("ThreadState-onException.txt");
        Log.e(TAG, "Dying now...");
        return super.onException(obj, th2);
    }

    public void onStart() {
        super.onStart();
        String str = this.jsBridgeClassName;
        if (str != null) {
            tryLoadingJsBridge(str);
        }
        waitForIdleSync();
        setupDexmakerClassloader();
        InstrumentationConnection.getInstance().init(this, new ActivityFinisher());
    }

    public void runOnMainSync(Runnable runnable) {
        FutureTask futureTask = new FutureTask(runnable, (Object) null);
        super.runOnMainSync(futureTask);
        try {
            futureTask.get();
        } catch (InterruptedException e11) {
            throw new RuntimeException(e11);
        } catch (ExecutionException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(cause);
            }
        }
    }

    public Activity startActivitySync(final Intent intent) {
        Checks.checkNotMainThread();
        long j11 = this.lastIdleTime.get();
        if (this.anActivityHasBeenLaunched.compareAndSet(false, true)) {
            intent.addFlags(67108864);
        }
        Future submit = this.executorService.submit(new Callable<Activity>() {
            public Activity call() {
                return MonitoringInstrumentation.super.startActivitySync(intent);
            }
        });
        try {
            return (Activity) submit.get(ActivityLifecycleTimeout.getMillis(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            f("ThreadState-startActivityTimeout.txt");
            submit.cancel(true);
            throw new RuntimeException(String.format("Could not launch intent %s within %s milliseconds. Perhaps the main thread has not gone idle within a reasonable amount of time? There could be an animation or something constantly repainting the screen. Or the activity is doing network calls on creation? See the threaddump logs. For your reference the last time the event queue was idle before your activity launch request was %s and now the last time the queue went idle was: %s. If these numbers are the same your activity might be hogging the event queue.", new Object[]{intent, Long.valueOf(ActivityLifecycleTimeout.getMillis()), Long.valueOf(j11), Long.valueOf(this.lastIdleTime.get())}));
        } catch (ExecutionException e11) {
            throw new RuntimeException("Could not launch activity", e11.getCause());
        } catch (InterruptedException e12) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("interrupted", e12);
        }
    }

    public void useDefaultInterceptingActivityFactory() {
        this.interceptingActivityFactory = new DefaultInterceptingActivityFactory();
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i11, Bundle bundle) {
        this.intentMonitor.signalIntent(intent);
        Instrumentation.ActivityResult stubResultFor = stubResultFor(intent);
        if (stubResultFor == null) {
            return super.execStartActivity(context, iBinder, iBinder2, activity, intent, i11, bundle);
        }
        Log.i(TAG, String.format("Stubbing intent %s", new Object[]{intent}));
        return stubResultFor;
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, String str, Intent intent, int i11, Bundle bundle) {
        this.intentMonitor.signalIntent(intent);
        Instrumentation.ActivityResult stubResultFor = stubResultFor(intent);
        if (stubResultFor == null) {
            return super.execStartActivity(context, iBinder, iBinder2, str, intent, i11, bundle);
        }
        Log.i(TAG, String.format("Stubbing intent %s", new Object[]{intent}));
        return stubResultFor;
    }

    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        if (this.interceptingActivityFactory.shouldIntercept(classLoader, str, intent)) {
            return this.interceptingActivityFactory.create(classLoader, str, intent);
        }
        return super.newActivity(classLoader, str, intent);
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i11, Bundle bundle, UserHandle userHandle) {
        return super.execStartActivity(context, iBinder, iBinder2, activity, intent, i11, bundle, userHandle);
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Fragment fragment, Intent intent, int i11, Bundle bundle) {
        this.intentMonitor.signalIntent(intent);
        Instrumentation.ActivityResult stubResultFor = stubResultFor(intent);
        if (stubResultFor == null) {
            return super.execStartActivity(context, iBinder, iBinder2, fragment, intent, i11, bundle);
        }
        Log.i(TAG, String.format("Stubbing intent %s", new Object[]{intent}));
        return stubResultFor;
    }
}
