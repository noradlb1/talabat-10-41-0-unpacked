package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmDispatcher implements ExecutionListener {
    private static final int DEFAULT_START_ID = 0;
    private static final String KEY_START_ID = "KEY_START_ID";
    private static final String PROCESS_COMMAND_TAG = "ProcessCommand";

    /* renamed from: f  reason: collision with root package name */
    public static final String f38042f = Logger.tagWithPrefix("SystemAlarmDispatcher");

    /* renamed from: b  reason: collision with root package name */
    public final Context f38043b;

    /* renamed from: c  reason: collision with root package name */
    public final CommandHandler f38044c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Intent> f38045d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f38046e;
    @Nullable
    private CommandsCompletedListener mCompletedListener;
    private final Handler mMainHandler;
    private final Processor mProcessor;
    private final TaskExecutor mTaskExecutor;
    private final WorkManagerImpl mWorkManager;
    private final WorkTimer mWorkTimer;

    public static class AddRunnable implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;
        private final Intent mIntent;
        private final int mStartId;

        public AddRunnable(@NonNull SystemAlarmDispatcher systemAlarmDispatcher, @NonNull Intent intent, int i11) {
            this.mDispatcher = systemAlarmDispatcher;
            this.mIntent = intent;
            this.mStartId = i11;
        }

        public void run() {
            this.mDispatcher.add(this.mIntent, this.mStartId);
        }
    }

    public interface CommandsCompletedListener {
        void onAllCommandsCompleted();
    }

    public static class DequeueAndCheckForCompletion implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;

        public DequeueAndCheckForCompletion(@NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
            this.mDispatcher = systemAlarmDispatcher;
        }

        public void run() {
            this.mDispatcher.a();
        }
    }

    public SystemAlarmDispatcher(@NonNull Context context) {
        this(context, (Processor) null, (WorkManagerImpl) null);
    }

    private void assertMainThread() {
        if (this.mMainHandler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    @MainThread
    private boolean hasIntentWithAction(@NonNull String str) {
        assertMainThread();
        synchronized (this.f38045d) {
            for (Intent action : this.f38045d) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    @MainThread
    private void processCommand() {
        assertMainThread();
        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.f38043b, PROCESS_COMMAND_TAG);
        try {
            newWakeLock.acquire();
            this.mWorkManager.getWorkTaskExecutor().executeOnBackgroundThread(new Runnable() {
                public void run() {
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    SystemAlarmDispatcher systemAlarmDispatcher;
                    synchronized (SystemAlarmDispatcher.this.f38045d) {
                        SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher2.f38046e = systemAlarmDispatcher2.f38045d.get(0);
                    }
                    Intent intent = SystemAlarmDispatcher.this.f38046e;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.f38046e.getIntExtra(SystemAlarmDispatcher.KEY_START_ID, 0);
                        Logger logger = Logger.get();
                        String str = SystemAlarmDispatcher.f38042f;
                        logger.debug(str, String.format("Processing command %s, %s", new Object[]{SystemAlarmDispatcher.this.f38046e, Integer.valueOf(intExtra)}), new Throwable[0]);
                        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(SystemAlarmDispatcher.this.f38043b, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                        try {
                            Logger.get().debug(str, String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                            newWakeLock.acquire();
                            SystemAlarmDispatcher systemAlarmDispatcher3 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher3.f38044c.g(systemAlarmDispatcher3.f38046e, intExtra, systemAlarmDispatcher3);
                            Logger.get().debug(str, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                            newWakeLock.release();
                            systemAlarmDispatcher = SystemAlarmDispatcher.this;
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                        } catch (Throwable th2) {
                            Logger.get().debug(SystemAlarmDispatcher.f38042f, String.format("Releasing operation wake lock (%s) %s", new Object[]{action, newWakeLock}), new Throwable[0]);
                            newWakeLock.release();
                            SystemAlarmDispatcher systemAlarmDispatcher4 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher4.g(new DequeueAndCheckForCompletion(systemAlarmDispatcher4));
                            throw th2;
                        }
                        systemAlarmDispatcher.g(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            newWakeLock.release();
        }
    }

    @MainThread
    public void a() {
        Logger logger = Logger.get();
        String str = f38042f;
        logger.debug(str, "Checking if commands are complete.", new Throwable[0]);
        assertMainThread();
        synchronized (this.f38045d) {
            if (this.f38046e != null) {
                Logger.get().debug(str, String.format("Removing command %s", new Object[]{this.f38046e}), new Throwable[0]);
                if (this.f38045d.remove(0).equals(this.f38046e)) {
                    this.f38046e = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            SerialExecutor backgroundExecutor = this.mTaskExecutor.getBackgroundExecutor();
            if (!this.f38044c.f() && this.f38045d.isEmpty() && !backgroundExecutor.hasPendingTasks()) {
                Logger.get().debug(str, "No more commands & intents.", new Throwable[0]);
                CommandsCompletedListener commandsCompletedListener = this.mCompletedListener;
                if (commandsCompletedListener != null) {
                    commandsCompletedListener.onAllCommandsCompleted();
                }
            } else if (!this.f38045d.isEmpty()) {
                processCommand();
            }
        }
    }

    @MainThread
    public boolean add(@NonNull Intent intent, int i11) {
        Logger logger = Logger.get();
        String str = f38042f;
        boolean z11 = false;
        logger.debug(str, String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i11)}), new Throwable[0]);
        assertMainThread();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.get().warning(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && hasIntentWithAction("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra(KEY_START_ID, i11);
            synchronized (this.f38045d) {
                if (!this.f38045d.isEmpty()) {
                    z11 = true;
                }
                this.f38045d.add(intent);
                if (!z11) {
                    processCommand();
                }
            }
            return true;
        }
    }

    public Processor b() {
        return this.mProcessor;
    }

    public TaskExecutor c() {
        return this.mTaskExecutor;
    }

    public WorkManagerImpl d() {
        return this.mWorkManager;
    }

    public WorkTimer e() {
        return this.mWorkTimer;
    }

    public void f() {
        Logger.get().debug(f38042f, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.mProcessor.removeExecutionListener(this);
        this.mWorkTimer.onDestroy();
        this.mCompletedListener = null;
    }

    public void g(@NonNull Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    public void h(@NonNull CommandsCompletedListener commandsCompletedListener) {
        if (this.mCompletedListener != null) {
            Logger.get().error(f38042f, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.mCompletedListener = commandsCompletedListener;
        }
    }

    public void onExecuted(@NonNull String str, boolean z11) {
        g(new AddRunnable(this, CommandHandler.c(this.f38043b, str, z11), 0));
    }

    @VisibleForTesting
    public SystemAlarmDispatcher(@NonNull Context context, @Nullable Processor processor, @Nullable WorkManagerImpl workManagerImpl) {
        Context applicationContext = context.getApplicationContext();
        this.f38043b = applicationContext;
        this.f38044c = new CommandHandler(applicationContext);
        this.mWorkTimer = new WorkTimer();
        workManagerImpl = workManagerImpl == null ? WorkManagerImpl.getInstance(context) : workManagerImpl;
        this.mWorkManager = workManagerImpl;
        processor = processor == null ? workManagerImpl.getProcessor() : processor;
        this.mProcessor = processor;
        this.mTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        processor.addExecutionListener(this);
        this.f38045d = new ArrayList();
        this.f38046e = null;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }
}
