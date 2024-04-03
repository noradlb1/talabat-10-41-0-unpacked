package com.instabug.library.invocation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.invocation.invoker.FloatingButtonInvoker;
import com.instabug.library.invocation.invoker.r;
import com.instabug.library.invocation.invoker.v;
import com.instabug.library.invocation.invoker.x;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class InvocationManager {
    private static InvocationManager INSTANCE;
    private Disposable currentActivityLifeCycleDisposable;
    private AtomicReferenceArray<InstabugInvocationEvent> currentInstabugInvocationEvents;
    private InvocationSettings currentInvocationSettings = new InvocationSettings();
    @Nullable
    private AtomicReferenceArray<com.instabug.library.invocation.invoker.a> currentInvokers;
    private List<com.instabug.library.invocation.invoker.a> currentInvokersList = new ArrayList();
    @Nullable
    private AtomicReference<d> invocationRequestListenerImp;
    private AtomicBoolean isInvocationAvailable = new AtomicBoolean(true);
    @Nullable
    private AtomicReference<com.instabug.library.invocation.invoker.a> lastUsedInvoker = new AtomicReference<>();

    public class a implements Consumer {
        public a() {
        }

        /* renamed from: a */
        public void accept(ActivityLifeCycleEvent activityLifeCycleEvent) {
            int i11 = c.f51284b[activityLifeCycleEvent.ordinal()];
            if (i11 == 1) {
                InvocationManager.this.listen();
            } else if (i11 == 2) {
                InvocationManager.this.sleep();
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.instabug.library.invocation.invoker.a f51282b;

        public b(InvocationManager invocationManager, com.instabug.library.invocation.invoker.a aVar) {
            this.f51282b = aVar;
        }

        public void run() {
            this.f51282b.sleep();
            this.f51282b.listen();
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51283a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f51284b;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        static {
            /*
                com.instabug.library.tracking.ActivityLifeCycleEvent[] r0 = com.instabug.library.tracking.ActivityLifeCycleEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51284b = r0
                r1 = 1
                com.instabug.library.tracking.ActivityLifeCycleEvent r2 = com.instabug.library.tracking.ActivityLifeCycleEvent.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f51284b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.instabug.library.tracking.ActivityLifeCycleEvent r3 = com.instabug.library.tracking.ActivityLifeCycleEvent.PAUSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.instabug.library.invocation.InstabugInvocationEvent[] r2 = com.instabug.library.invocation.InstabugInvocationEvent.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f51283a = r2
                com.instabug.library.invocation.InstabugInvocationEvent r3 = com.instabug.library.invocation.InstabugInvocationEvent.SHAKE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f51283a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.instabug.library.invocation.InstabugInvocationEvent r2 = com.instabug.library.invocation.InstabugInvocationEvent.FLOATING_BUTTON     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f51283a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.instabug.library.invocation.InstabugInvocationEvent r1 = com.instabug.library.invocation.InstabugInvocationEvent.TWO_FINGER_SWIPE_LEFT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f51283a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.instabug.library.invocation.InstabugInvocationEvent r1 = com.instabug.library.invocation.InstabugInvocationEvent.SCREENSHOT     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.invocation.InvocationManager.c.<clinit>():void");
        }
    }

    private InvocationManager() {
        AtomicReferenceArray<InstabugInvocationEvent> atomicReferenceArray = new AtomicReferenceArray<>(1);
        this.currentInstabugInvocationEvents = atomicReferenceArray;
        atomicReferenceArray.set(0, InstabugInvocationEvent.SHAKE);
        this.currentInvokers = new AtomicReferenceArray<>(createInvokersList());
        subscribeToCarenActivityLifeCycle();
        this.invocationRequestListenerImp = new AtomicReference<>(new d());
    }

    private void addToCurrentInvokers(com.instabug.library.invocation.invoker.a aVar) {
        this.currentInvokersList.add(aVar);
        List<com.instabug.library.invocation.invoker.a> list = this.currentInvokersList;
        this.currentInvokers = new AtomicReferenceArray<>((com.instabug.library.invocation.invoker.a[]) list.toArray(new com.instabug.library.invocation.invoker.a[list.size()]));
    }

    @NonNull
    private com.instabug.library.invocation.invoker.a[] createInvokersList() {
        ArrayList arrayList = new ArrayList();
        this.currentInvokersList = arrayList;
        return (com.instabug.library.invocation.invoker.a[]) arrayList.toArray(new com.instabug.library.invocation.invoker.a[arrayList.size()]);
    }

    @Nullable
    private FloatingButtonInvoker getFloatingButtonInvoker() {
        if (this.currentInvokers != null) {
            for (int i11 = 0; i11 < this.currentInvokers.length(); i11++) {
                com.instabug.library.invocation.invoker.a aVar = this.currentInvokers.get(i11);
                if (aVar instanceof FloatingButtonInvoker) {
                    return (FloatingButtonInvoker) aVar;
                }
            }
        }
        return null;
    }

    public static synchronized InvocationManager getInstance() {
        InvocationManager invocationManager;
        synchronized (InvocationManager.class) {
            if (INSTANCE == null) {
                init();
            }
            invocationManager = INSTANCE;
        }
        return invocationManager;
    }

    public static synchronized void init() {
        synchronized (InvocationManager.class) {
            if (INSTANCE == null) {
                INSTANCE = new InvocationManager();
            } else if (!SettingsManager.getInstance().isInBackground()) {
                INSTANCE.listen();
            }
        }
    }

    private boolean isPromptOptionsAvailable() {
        return getAvailablePromptOptions().size() > 0;
    }

    private void subscribeToCarenActivityLifeCycle() {
        this.currentActivityLifeCycleDisposable = CurrentActivityLifeCycleEventBus.getInstance().subscribe(new a());
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public static void tearDown() {
        INSTANCE = null;
    }

    @Nullable
    public List<com.instabug.library.invocation.invoker.a> a() {
        com.instabug.library.invocation.invoker.a[] aVarArr = (com.instabug.library.invocation.invoker.a[]) com.instabug.library.invocation.util.a.a(this.currentInvokers, com.instabug.library.invocation.invoker.a.class);
        if (aVarArr == null) {
            return null;
        }
        return Arrays.asList(aVarArr);
    }

    @VisibleForTesting
    public AtomicReferenceArray<InstabugInvocationEvent> b(InstabugInvocationEvent[] instabugInvocationEventArr) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (InstabugInvocationEvent instabugInvocationEvent : instabugInvocationEventArr) {
            if (!hashSet.contains(instabugInvocationEvent)) {
                arrayList.add(instabugInvocationEvent);
                hashSet.add(instabugInvocationEvent);
            }
        }
        return new AtomicReferenceArray<>((InstabugInvocationEvent[]) arrayList.toArray(new InstabugInvocationEvent[arrayList.size()]));
    }

    public void forceInvoke(int i11) {
        AtomicReference<d> atomicReference = this.invocationRequestListenerImp;
        if (atomicReference != null && atomicReference.get() != null) {
            this.invocationRequestListenerImp.get().b(i11);
        }
    }

    public ArrayList<PluginPromptOption> getAvailablePromptOptions() {
        return com.instabug.library.core.plugin.c.f();
    }

    @Nullable
    public InstabugInvocationEvent[] getCurrentInstabugInvocationEvents() {
        InstabugInvocationEvent[] instabugInvocationEventArr = (InstabugInvocationEvent[]) com.instabug.library.invocation.util.a.a(this.currentInstabugInvocationEvents, InstabugInvocationEvent.class);
        if (instabugInvocationEventArr != null) {
            return (InstabugInvocationEvent[]) Arrays.copyOf(instabugInvocationEventArr, this.currentInstabugInvocationEvents.length());
        }
        return null;
    }

    public InvocationSettings getCurrentInvocationSettings() {
        return this.currentInvocationSettings;
    }

    @Nullable
    public com.instabug.library.invocation.invoker.a getLastUsedInvoker() {
        AtomicReference<com.instabug.library.invocation.invoker.a> atomicReference = this.lastUsedInvoker;
        if (atomicReference == null) {
            return null;
        }
        return atomicReference.get();
    }

    public void handle(MotionEvent motionEvent) {
        if (this.currentInvokers != null && InstabugStateProvider.getInstance().getState().equals(InstabugState.ENABLED) && !InstabugCore.isForegroundBusy()) {
            for (int i11 = 0; i11 < this.currentInvokers.length(); i11++) {
                com.instabug.library.invocation.invoker.a aVar = this.currentInvokers.get(i11);
                if (aVar instanceof x) {
                    aVar.handle(motionEvent);
                    return;
                }
            }
        }
    }

    public void invoke(int i11) {
        AtomicReference<d> atomicReference = this.invocationRequestListenerImp;
        if (atomicReference != null && atomicReference.get() != null) {
            this.invocationRequestListenerImp.get().g(i11);
        }
    }

    public void listen() {
        if (Instabug.isEnabled() && this.isInvocationAvailable.get() && isPromptOptionsAvailable() && this.currentInvokers != null && InstabugCore.getTargetActivity() != null && !SettingsManager.getInstance().isProcessingForeground()) {
            for (int i11 = 0; i11 < this.currentInvokers.length(); i11++) {
                com.instabug.library.invocation.invoker.a aVar = this.currentInvokers.get(i11);
                if (!aVar.isActive()) {
                    aVar.listen();
                }
            }
        }
    }

    public void notifyInvocationOptionChanged() {
        boolean z11 = !isPromptOptionsAvailable();
        FloatingButtonInvoker floatingButtonInvoker = getFloatingButtonInvoker();
        if (floatingButtonInvoker == null) {
            return;
        }
        if (z11) {
            floatingButtonInvoker.sleep();
        } else {
            floatingButtonInvoker.updateButtonLocation();
        }
    }

    public void notifyPrimaryColorChanged() {
        if (Instabug.isEnabled() && this.currentInvokers != null) {
            for (int i11 = 0; i11 < this.currentInvokers.length(); i11++) {
                com.instabug.library.invocation.invoker.a aVar = this.currentInvokers.get(i11);
                if (InstabugCore.getTargetActivity() != null && (aVar instanceof FloatingButtonInvoker)) {
                    PoolProvider.postMainThreadTask(new b(this, aVar));
                }
            }
        }
    }

    public void release() {
        Disposable disposable = this.currentActivityLifeCycleDisposable;
        if (disposable != null && !disposable.isDisposed()) {
            this.currentActivityLifeCycleDisposable.dispose();
        }
        this.invocationRequestListenerImp = null;
    }

    public void setInstabugInvocationEvent(InstabugInvocationEvent... instabugInvocationEventArr) {
        if (instabugInvocationEventArr == null) {
            InstabugSDKLogger.e("IBG-Core", "Passed invocation events has null value, no change will take effect to the previous set invocation events");
            return;
        }
        this.currentInstabugInvocationEvents = b(instabugInvocationEventArr);
        int i11 = 0;
        if (this.currentInvokers != null) {
            for (int i12 = 0; i12 < this.currentInvokers.length(); i12++) {
                this.currentInvokers.get(i12).sleep();
            }
            this.currentInvokers = new AtomicReferenceArray<>(createInvokersList());
        }
        while (true) {
            if (i11 >= this.currentInstabugInvocationEvents.length()) {
                break;
            }
            InstabugInvocationEvent instabugInvocationEvent = this.currentInstabugInvocationEvents.get(i11);
            InstabugSDKLogger.v("IBG-Core", "set instabug invocation event: " + instabugInvocationEvent);
            if (instabugInvocationEvent == InstabugInvocationEvent.NONE && instabugInvocationEventArr.length == 1) {
                this.currentInvokers = null;
                break;
            }
            if (this.currentInvokers == null) {
                this.currentInvokers = new AtomicReferenceArray<>(createInvokersList());
            }
            Context applicationContext = Instabug.getApplicationContext();
            if (this.invocationRequestListenerImp != null) {
                int i13 = c.f51283a[instabugInvocationEvent.ordinal()];
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            if (!(i13 != 4 || this.currentInvokers == null || this.invocationRequestListenerImp.get() == null)) {
                                addToCurrentInvokers(new r(this.invocationRequestListenerImp.get()));
                            }
                        } else if (applicationContext == null || this.invocationRequestListenerImp.get() == null) {
                            InstabugSDKLogger.e("IBG-Core", "did not add TwoFingerSwipeLeftInvoker due to null appContext");
                        } else {
                            x xVar = new x(applicationContext, this.invocationRequestListenerImp.get());
                            if (this.currentInvokers != null) {
                                addToCurrentInvokers(xVar);
                            }
                        }
                    } else if (!(this.currentInvokers == null || this.invocationRequestListenerImp.get() == null)) {
                        addToCurrentInvokers(new FloatingButtonInvoker(this.invocationRequestListenerImp.get()));
                    }
                } else if (applicationContext == null || this.invocationRequestListenerImp.get() == null) {
                    InstabugSDKLogger.e("IBG-Core", "did not add ShakeInvoker due to null appContext");
                } else {
                    v vVar = new v(applicationContext, this.invocationRequestListenerImp.get());
                    vVar.a(this.currentInvocationSettings.a());
                    if (this.currentInvokers != null) {
                        addToCurrentInvokers(vVar);
                    }
                }
            }
            i11++;
        }
        if (this.currentInvokers != null) {
            setLastUsedInvoker((com.instabug.library.invocation.invoker.a) null);
            listen();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void setLastUsedInvoker(@Nullable com.instabug.library.invocation.invoker.a aVar) {
        AtomicReference<com.instabug.library.invocation.invoker.a> atomicReference = this.lastUsedInvoker;
        if (atomicReference != null) {
            atomicReference.set(aVar);
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void show() {
        AtomicReference<d> atomicReference = this.invocationRequestListenerImp;
        if (!(atomicReference == null || atomicReference.get() == null)) {
            this.invocationRequestListenerImp.get().a();
        }
        this.lastUsedInvoker = new AtomicReference<>((Object) null);
    }

    public void sleep() {
        if (this.currentInvokers != null) {
            for (int i11 = 0; i11 < this.currentInvokers.length(); i11++) {
                com.instabug.library.invocation.invoker.a aVar = this.currentInvokers.get(i11);
                if (aVar.isActive()) {
                    aVar.sleep();
                }
            }
        }
    }

    public void switchOffInvocation() {
        this.isInvocationAvailable.set(false);
    }

    public void switchOnInvocation() {
        this.isInvocationAvailable.set(true);
    }
}
