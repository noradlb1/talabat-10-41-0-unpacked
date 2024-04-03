package com.instabug.library;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.exoplayer2.C;
import com.instabug.library.Feature;
import com.instabug.library.broadcast.a;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.InstabugStateEventBus;
import com.instabug.library.core.eventbus.OnSessionCrashedEventBus;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.coreSDKChecks.d;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.diagnostics.c;
import com.instabug.library.firstseen.b;
import com.instabug.library.internal.orchestrator.ActionsOrchestrator;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.model.v3Session.s;
import com.instabug.library.model.v3Session.u;
import com.instabug.library.networkv2.service.userattributes.h;
import com.instabug.library.session.n;
import com.instabug.library.sessionV3.manager.i;
import com.instabug.library.sessionprofiler.e;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.ui.onboarding.OnboardingActivity;
import com.instabug.library.ui.onboarding.WelcomeMessage;
import com.instabug.library.user.f;
import com.instabug.library.util.DiskUtils;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.OrientationUtils;
import com.instabug.library.util.TaskDebouncer;
import com.instabug.library.util.filters.Filters;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.visualusersteps.y;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

class c0 implements a.C0004a {

    /* renamed from: r  reason: collision with root package name */
    private static c0 f50532r;

    /* renamed from: a  reason: collision with root package name */
    private final a f50533a = new a(this);

    /* renamed from: b  reason: collision with root package name */
    private final h f50534b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final n f50535c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Application f50536d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public WeakReference f50537e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Disposable f50538f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Disposable f50539g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Disposable f50540h;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public Handler f50541i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Disposable f50542j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final TaskDebouncer f50543k = new TaskDebouncer(30000);

    /* renamed from: l  reason: collision with root package name */
    private final TaskDebouncer f50544l = new TaskDebouncer(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f50545m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final b f50546n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f50547o = false;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final c f50548p;

    /* renamed from: q  reason: collision with root package name */
    private final d f50549q;

    private c0(Application application) {
        Context applicationContext = application.getApplicationContext();
        this.f50537e = new WeakReference(applicationContext);
        this.f50546n = b.b();
        this.f50534b = h.a(applicationContext);
        this.f50535c = n.a(applicationContext);
        this.f50536d = application;
        this.f50545m = false;
        this.f50548p = new c();
        this.f50549q = new d();
        InstabugInternalTrackingDelegate.init(application);
    }

    /* access modifiers changed from: private */
    public void A() {
        ActionsOrchestrator.obtainOrchestrator().addWorkerThreadAction(new com.instabug.library.internal.orchestrator.b(com.instabug.library.internal.dataretention.files.d.b(), new com.instabug.library.internal.dataretention.core.c[0])).orchestrate();
    }

    /* access modifiers changed from: private */
    public void B() {
        com.instabug.library.networkv2.service.synclogs.c a11 = com.instabug.library.networkv2.service.synclogs.c.a();
        a11.b(f.k(), f.h());
        if (j() != null && SettingsManager.getInstance().getAppToken() != null) {
            a11.a(j(), SettingsManager.getInstance().getAppToken());
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        boolean z11;
        if (k() == InstabugState.DISABLED) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f50534b.b();
        this.f50544l.debounce((Runnable) new x(this, z11));
        ActionsOrchestrator.obtainOrchestrator().addWorkerThreadAction(new y(this)).orchestrate();
    }

    /* access modifiers changed from: private */
    public void D() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            e0.c().g(applicationContext);
        }
    }

    private void E() {
        boolean shouldAutoShowOnboarding = SettingsManager.getInstance().shouldAutoShowOnboarding();
        InstabugSDKLogger.v("IBG-Core", "Checking if should show welcome message, Should show " + shouldAutoShowOnboarding + ", Welcome message state " + SettingsManager.getInstance().getWelcomeMessageState());
        if (shouldAutoShowOnboarding) {
            Looper myLooper = Looper.myLooper();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                myLooper = Looper.getMainLooper();
            }
            if (myLooper != null) {
                new Handler(myLooper).postDelayed(new b0(this), 10000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void G() {
        WeakReference weakReference = this.f50537e;
        if (weakReference != null) {
            Context context = (Context) weakReference.get();
            if (context != null) {
                PoolProvider.postIOTask(new v(this, context));
            } else {
                InstabugSDKLogger.e("IBG-Core", "Couldn't fetch plan features because Context was null.");
            }
        }
    }

    private void H() {
        if (j() == null) {
            InstabugSDKLogger.e("IBG-Core", "Unable to start migration because of a null context");
        } else {
            com.instabug.library.migration.f.b(j());
        }
    }

    /* access modifiers changed from: private */
    public void J() {
        InstabugSDKLogger.d("IBG-Core", "Starting Instabug SDK invocation listeners");
        InvocationManager.getInstance().listen();
    }

    /* access modifiers changed from: private */
    public synchronized void K() {
        PoolProvider.postIOTaskWithCheck(new i(this));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NULL_DEREFERENCE"})
    public void M() {
        InstabugSDKLogger.d("IBG-Core", "Stopping Instabug SDK invocation listeners");
        InvocationManager.getInstance().sleep();
    }

    /* access modifiers changed from: private */
    public void N() {
        Disposable disposable = this.f50542j;
        if (disposable == null || disposable.isDisposed()) {
            this.f50542j = SDKCoreEventSubscriber.subscribe(new p(this));
        }
    }

    private void O() {
        this.f50538f = SessionStateEventBus.getInstance().subscribe(new s(this));
    }

    /* access modifiers changed from: private */
    public void P() {
        PoolProvider.postIOTask(new t(this));
    }

    /* access modifiers changed from: private */
    public void Q() {
        Disposable disposable = this.f50540h;
        if (disposable != null) {
            disposable.dispose();
            this.f50540h = null;
        }
    }

    /* access modifiers changed from: private */
    public void R() {
        Disposable disposable = this.f50538f;
        if (disposable != null) {
            disposable.dispose();
            this.f50538f = null;
        }
    }

    /* access modifiers changed from: private */
    public void T() {
        Disposable disposable = this.f50542j;
        if (disposable != null) {
            disposable.dispose();
            this.f50542j = null;
        }
    }

    /* access modifiers changed from: private */
    public void U() {
        Disposable disposable = this.f50539g;
        if (disposable != null) {
            disposable.dispose();
            this.f50539g = null;
        }
    }

    public static synchronized c0 a(Application application) {
        c0 c0Var;
        synchronized (c0.class) {
            if (f50532r == null) {
                f50532r = new c0(application);
            }
            c0Var = f50532r;
        }
        return c0Var;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void g() {
        if (Instabug.getApplicationContext() != null) {
            Iterator<File> it = DiskUtils.listFilesInDirectory(com.instabug.library.internal.storage.DiskUtils.getInstabugDirectory(Instabug.getApplicationContext())).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (FileUtils.isFileRelatedToBugOrCrashReport(next.getPath())) {
                    next.delete();
                }
            }
            InstabugCore.setFirstRunAfterEncryptorUpdate(false);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        PoolProvider.postIOTask(new u(this));
    }

    private InstabugState k() {
        return InstabugStateProvider.getInstance().getState();
    }

    private void l() {
        boolean z11;
        if (e0.c().b() == Feature.State.ENABLED) {
            z11 = true;
        } else {
            z11 = false;
        }
        com.instabug.library.internal.sharedpreferences.f.a(z11, j());
        b();
        com.instabug.library.encryption.b.a();
    }

    private void n() {
        InternalAutoScreenRecorderHelper.getInstance().start();
    }

    private void o() {
        InstabugSDKLogger.d("IBG-Core", "setting Uncaught Exception Handler com.instabug.library.crash.InstabugUncaughtExceptionHandler");
        Thread.setDefaultUncaughtExceptionHandler(new com.instabug.library.crash.a());
    }

    private void p() {
        InstabugSDKLogger.v("IBG-Core", "initialize Instabug Invocation Manager");
        InvocationManager.init();
    }

    /* access modifiers changed from: private */
    public boolean q() {
        InstabugInvocationEvent[] currentInstabugInvocationEvents = InvocationManager.getInstance().getCurrentInstabugInvocationEvents();
        if (currentInstabugInvocationEvents == null) {
            return false;
        }
        if (currentInstabugInvocationEvents.length == 1 && currentInstabugInvocationEvents[0] == InstabugInvocationEvent.NONE) {
            return false;
        }
        return true;
    }

    private boolean r() {
        if (k() != InstabugState.NOT_BUILT) {
            e0 c11 = e0.c();
            Feature feature = Feature.INSTABUG;
            if (!c11.c((Object) feature) || e0.c().b((Object) feature) != Feature.State.ENABLED) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void s() {
        if (k() == InstabugState.ENABLED) {
            y.d().g();
        } else if (k() == InstabugState.DISABLED) {
            y.d().a();
            y.d().l();
        }
    }

    private void u() {
        Context context = (Context) this.f50537e.get();
        if (context != null) {
            UserAttributesCacheManager.prepareCaches(context);
        } else {
            InstabugSDKLogger.e("IBG-Core", "can't execute prepareCaches() due to null context");
        }
    }

    private void v() {
        f.t();
    }

    private void w() {
        if (!InstabugInternalTrackingDelegate.getInstance().isRegistered()) {
            InstabugInternalTrackingDelegate.getInstance().registerLifecycleListeners(this.f50536d);
        }
    }

    private void y() {
        this.f50540h = OnSessionCrashedEventBus.getInstance().subscribe(new a0(this));
    }

    public void D0() {
        InstabugSDKLogger.d("IBG-Core", "Resuming Instabug SDK");
        W(InstabugState.ENABLED);
        PoolProvider.postMainThreadTask(new l(this));
    }

    public void F() {
        if (Instabug.isBuilding()) {
            InstabugSDKLogger.v("IBG-Core", "stopSdk called while sdk is building");
            SDKCoreEventSubscriber.subscribe(new h(this));
        } else if (r()) {
            K();
        }
    }

    public void L() {
        if (e0.c().b((Object) Feature.VP_CUSTOMIZATION) == Feature.State.ENABLED) {
            com.instabug.library.customizations.b.a();
        }
    }

    public void S() {
        if (j() != null) {
            LocalBroadcastManager.getInstance(j()).unregisterReceiver(this.f50533a);
        }
    }

    public void V(Feature.State state) {
        e0.c().a(Feature.SESSION_PROFILER, state);
        if (state != Feature.State.ENABLED || !Instabug.isEnabled()) {
            e.a().d();
        } else {
            e.a().c();
        }
    }

    public void W(@NonNull InstabugState instabugState) {
        InstabugSDKLogger.d("IBG-Core", "Setting Instabug State to " + instabugState);
        if (instabugState != k()) {
            InstabugStateProvider.getInstance().setState(instabugState);
            InstabugStateEventBus.getInstance().post(instabugState);
        }
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void a0(Locale locale) {
        Locale instabugLocale = SettingsManager.getInstance().getInstabugLocale(j());
        if (!instabugLocale.equals(locale)) {
            SettingsManager.getInstance().setInstabugLocale(locale);
            com.instabug.library.core.plugin.c.a(instabugLocale, locale);
        }
    }

    public void b(Context context) {
        e0.c().j(context);
    }

    public void c(WelcomeMessage.State state) {
        if (!Instabug.isEnabled()) {
            InstabugSDKLogger.e("Instabug", "Cannot show intro message while SDK is Disabled");
        } else if (state == WelcomeMessage.State.DISABLED) {
            InstabugSDKLogger.e("Instabug", "Cannot show onboarding message while WelcomeMessageState is DISABLED");
        } else if ((InvocationManager.getInstance().getCurrentInstabugInvocationEvents() != null && InvocationManager.getInstance().getCurrentInstabugInvocationEvents().length == 0) || !q()) {
            InstabugSDKLogger.e("Instabug", "Cannot show onboarding message while invocation event in NONE");
        } else if (!InstabugCore.isAppOnForeground()) {
            if (this.f50539g == null) {
                this.f50539g = SDKCoreEventSubscriber.subscribe(new e(this, state));
            }
        } else if (!InstabugCore.isForegroundBusy()) {
            b(state);
        } else if (this.f50539g == null) {
            this.f50539g = SDKCoreEventSubscriber.subscribe(new g(this, state));
        }
    }

    public void c0(Feature.State state) {
        boolean z11;
        e0.c().a(Feature.INSTABUG, state);
        if (j() != null) {
            e0.c().g(j());
            com.instabug.library.settings.d dVar = new com.instabug.library.settings.d(j());
            if (state == Feature.State.ENABLED) {
                z11 = true;
            } else {
                z11 = false;
            }
            dVar.a(z11);
        }
    }

    public void d() {
        PoolProvider.getUserActionsExecutor().execute(new o(this));
    }

    public HashMap i() {
        return (HashMap) Filters.applyOn(UserAttributeCacheManager.retrieveAll()).apply(com.instabug.library.util.filters.h.g()).thenGet();
    }

    @Nullable
    public Context j() {
        if (this.f50537e.get() == null) {
            InstabugSDKLogger.e("IBG-Core", "Application context instance equal null");
        }
        return (Context) this.f50537e.get();
    }

    public void m() {
        if (k() == InstabugState.DISABLED) {
            C();
        }
    }

    public void onSDKInvoked(boolean z11) {
        InstabugSDKLogger.d("IBG-Core", "SDK Invoked: " + z11);
        InstabugState k11 = k();
        if (k11 != InstabugState.TAKING_SCREENSHOT && k11 != InstabugState.RECORDING_VIDEO && k11 != InstabugState.TAKING_SCREENSHOT_FOR_CHAT && k11 != InstabugState.RECORDING_VIDEO_FOR_CHAT && k11 != InstabugState.IMPORTING_IMAGE_FROM_GALLERY_FOR_CHAT) {
            if (z11) {
                W(InstabugState.INVOKED);
                return;
            }
            Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
            if (currentActivity != null) {
                OrientationUtils.unlockOrientation(currentActivity);
            }
            if (e0.c().c((Object) Feature.INSTABUG)) {
                W(InstabugState.ENABLED);
            } else {
                W(InstabugState.DISABLED);
            }
        }
    }

    @WorkerThread
    public void t() {
        boolean z11;
        e0 c11 = e0.c();
        Feature feature = Feature.INSTABUG;
        boolean c12 = c11.c((Object) feature);
        if (e0.c().b((Object) feature) == Feature.State.ENABLED) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!c12 || !z11) {
            W(InstabugState.DISABLED);
        } else {
            z();
        }
        p();
    }

    public void w0() {
        if (k().equals(InstabugState.ENABLED)) {
            InstabugSDKLogger.d("IBG-Core", "Pausing Instabug SDK functionality temporary");
            W(InstabugState.DISABLED);
            PoolProvider.postMainThreadTask(new k(this));
        }
    }

    public void x() {
        if (j() == null) {
            InstabugSDKLogger.e("IBG-Core", "Unable to register a LocalBroadcast receiver because of a null context");
        } else {
            LocalBroadcastManager.getInstance(j()).registerReceiver(this.f50533a, new IntentFilter("SDK invoked"));
        }
    }

    @WorkerThread
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public synchronized void z() {
        if (!this.f50545m) {
            this.f50545m = true;
            com.instabug.library.core.b.a();
            l();
            AttachmentsUtility.clearInternalAttachments(j());
            N();
            com.instabug.library.networkv2.c.e(j());
            y();
            com.instabug.library.core.plugin.c.b(j());
            this.f50549q.a(Build.VERSION.SDK_INT, "11.7.0");
            b(j());
            b();
            s();
            O();
            o();
            InstabugSDKLogger.d("IBG-Core", "Starting Instabug SDK functionality");
            W(InstabugState.ENABLED);
            c0(Feature.State.ENABLED);
            E();
            r0.e().k();
            i.f51800a.a((u) new s());
            InstabugSDKLogger.v("IBG-Core", "Disposing expired data");
            com.instabug.library.internal.dataretention.b.c().b();
            InstabugSDKLogger.v("IBG-Core", "Running valid migration");
            H();
            InstabugSDKLogger.v("IBG-Core", "Registering broadcasts");
            x();
            InstabugSDKLogger.v("IBG-Core", "Preparing user state");
            v();
            InstabugSDKLogger.v("IBG-Core", "Initializing auto screen recording");
            n();
            e.a().c();
            w();
        }
    }

    /* access modifiers changed from: private */
    public void b(WelcomeMessage.State state) {
        PresentationManager.getInstance().show(new s0(state));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"RESOURCE_LEAK"})
    public void e() {
        WeakReference weakReference = this.f50537e;
        if (weakReference != null && ((Context) weakReference.get()) != null) {
            PoolProvider.getSingleThreadExecutor("drop_db_executor").execute(new j(this));
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        com.instabug.library.internal.storage.DiskUtils.deleteAllStateFiles();
        com.instabug.library.internal.storage.DiskUtils.deleteNonfatalStateFiles();
    }

    public void b(@NonNull View... viewArr) {
        SettingsManager.getInstance().removePrivateViews(viewArr);
    }

    public void a(Context context) {
        com.instabug.library.core.plugin.c.g();
        u();
    }

    public void b(String str) {
        PoolProvider.getUserActionsExecutor().execute(new n(this, str));
    }

    private void b() {
        if (InstabugCore.isFirstRunAfterEncryptorUpdate()) {
            PoolProvider.postIOTask(new q(this));
        }
    }

    /* access modifiers changed from: private */
    public void a(SDKCoreEvent sDKCoreEvent, WelcomeMessage.State state) {
        String type = sDKCoreEvent.getType();
        type.hashCode();
        if (!type.equals(SDKCoreEvent.ForegroundStatus.TYPE_FOREGROUNDS_STATUS)) {
            if (type.equals(SDKCoreEvent.Invocation.TYPE_INVOCATION)) {
                U();
            }
        } else if (sDKCoreEvent.getValue().equalsIgnoreCase(SDKCoreEvent.ForegroundStatus.VALUE_AVAILABLE) && !InstabugCore.isForegroundBusy()) {
            b(state);
            U();
        }
    }

    public void b(List list) {
        com.instabug.library.experiments.di.a.c().b(list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(WelcomeMessage.State state) {
        Activity targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
        if (targetActivity != null && !targetActivity.isFinishing()) {
            Intent a11 = OnboardingActivity.a(targetActivity, state);
            if (targetActivity.getPackageManager().resolveActivity(a11, 0) != null) {
                targetActivity.startActivity(a11);
                return;
            }
            ActivityNotFoundException activityNotFoundException = new ActivityNotFoundException("OnboardingActivity");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to show welcome message with state: " + state + "\ndue to error at: ");
            sb2.append(StringUtils.LF);
            sb2.append(activityNotFoundException.getMessage() != null ? activityNotFoundException.getMessage() : "");
            IBGDiagnostics.reportNonFatal(activityNotFoundException, sb2.toString());
        }
    }

    public void c() {
        com.instabug.library.experiments.di.a.c().a();
    }

    public void a(@NonNull View... viewArr) {
        SettingsManager.getInstance().addPrivateViews(viewArr);
    }

    @Nullable
    public String a(String str) {
        return (String) Filters.applyOn(str).apply(com.instabug.library.util.filters.h.e()).thenDoReturn(com.instabug.library.util.filters.h.a());
    }

    public void a(String str, String str2) {
        PoolProvider.getUserActionsExecutor().execute(new m(this, str, str2));
    }

    public void a(@Nullable Bitmap bitmap, @NonNull String str) {
        y.d().a(str, bitmap);
        com.instabug.library.tracking.b.c().a(str);
        SDKCoreEventPublisher.post(new SDKCoreEvent("cross_platform_state_screen_changed", str));
    }

    public void a(List list) {
        com.instabug.library.experiments.di.a.c().a(list);
    }
}
