package com.instabug.apm;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.instabug.apm.fragment.u;
import com.instabug.apm.handler.session.k;
import com.instabug.library.InstabugState;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.InstabugStateEventBus;
import com.instabug.library.core.eventbus.NDKSessionCrashedEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.core.eventbus.eventpublisher.Unsubscribable;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.model.common.Session;
import com.instabug.library.model.common.SessionVersion;
import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import com.instabug.library.sessionV3.providers.FeatureSessionDataControllerHost;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

public class APMPlugin extends Plugin implements com.instabug.apm.handler.session.a, FeatureSessionDataControllerHost {
    public static final Object lock = new Object();
    /* access modifiers changed from: private */
    public final com.instabug.apm.logger.internal.a apmLogger = com.instabug.apm.di.a.f();
    @VisibleForTesting
    @Nullable
    Unsubscribable apmSdkStateObserver;
    u fragmentSpansHelper = com.instabug.apm.di.a.M();
    private boolean isFirstLaunch = false;
    @Nullable
    private CompositeDisposable sdkCoreEventsSubscriberDisposable;
    /* access modifiers changed from: private */
    public final com.instabug.apm.handler.session.c sessionHandler = com.instabug.apm.di.a.W();

    public class a implements Consumer {
        public a() {
        }

        /* renamed from: a */
        public void accept(InstabugState instabugState) {
            if (instabugState == InstabugState.DISABLED) {
                APMPlugin.this.apmLogger.d("Instabug is disabled, purging APM data…");
                APMPlugin.this.stopRunningMetrics();
                APMPlugin.this.endSession();
                APMPlugin.this.purgeData();
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.instabug.apm.sync.a f45105b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f45106c;

        public b(APMPlugin aPMPlugin, com.instabug.apm.sync.a aVar, boolean z11) {
            this.f45105b = aVar;
            this.f45106c = z11;
        }

        public void run() {
            this.f45105b.a(this.f45106c);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.instabug.apm.handler.executiontraces.a f45107b;

        public c(APMPlugin aPMPlugin, com.instabug.apm.handler.executiontraces.a aVar) {
            this.f45107b = aVar;
        }

        public void run() {
            synchronized (APMPlugin.lock) {
                this.f45107b.b();
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ com.instabug.apm.handler.networklog.a f45108b;

        public d(APMPlugin aPMPlugin, com.instabug.apm.handler.networklog.a aVar) {
            this.f45108b = aVar;
        }

        public void run() {
            if (com.instabug.apm.di.a.c().r()) {
                synchronized (APMPlugin.lock) {
                    this.f45108b.b();
                }
            }
        }
    }

    public class e implements Consumer {
        public e() {
        }

        @SuppressLint({"NULL_DEREFERENCE"})
        /* renamed from: a */
        public void accept(SDKCoreEvent sDKCoreEvent) {
            String type = sDKCoreEvent.getType();
            type.hashCode();
            char c11 = 65535;
            switch (type.hashCode()) {
                case -744664100:
                    if (type.equals("cross_platform_state_screen_changed")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -296668708:
                    if (type.equals(SDKCoreEvent.Feature.TYPE_FEATURES_FETCHED)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 643590868:
                    if (type.equals("v3_session")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1163747545:
                    if (type.equals("cross_platform_crashed")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    String value = sDKCoreEvent.getValue();
                    if (value != null) {
                        com.instabug.apm.di.a.k0().a(value);
                        return;
                    }
                    return;
                case 1:
                    boolean a11 = com.instabug.apm.di.a.b().a(sDKCoreEvent.getValue());
                    com.instabug.apm.configuration.c c12 = com.instabug.apm.di.a.c();
                    c12.j(InstabugCore.isV3SessionEnabled());
                    if (a11 && c12.H()) {
                        Session runningSession = InstabugCore.getRunningSession();
                        if (runningSession != null) {
                            k.a(APMPlugin.this);
                            APMPlugin.this.startSession(runningSession);
                            APMPlugin.this.registerSessionCrashHandler();
                        }
                        APMPlugin.this.registerActivityLifeCycleCallbacks();
                        APMPlugin.this.registerSessionCrashHandler();
                        APMPlugin.this.registerFragmentLifecycleEventListener();
                        return;
                    }
                    return;
                case 2:
                    APMPlugin.this.handleV3SessionEvent(sDKCoreEvent);
                    return;
                case 3:
                    APMPlugin.this.updateCurrentSession();
                    return;
                default:
                    return;
            }
        }
    }

    public class f implements Consumer {
        public f() {
        }

        /* renamed from: a */
        public void accept(NDKSessionCrashedEvent nDKSessionCrashedEvent) {
            APMPlugin.this.sessionHandler.a(nDKSessionCrashedEvent.getSessionId(), TimeUnit.MILLISECONDS.toMicros(nDKSessionCrashedEvent.getSessionDuration()), 1);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            if (InstabugCore.getRunningSession() != null) {
                APMPlugin.this.sessionHandler.b(1);
            }
        }
    }

    private void clearInvalidCache() {
        com.instabug.apm.handler.executiontraces.a A = com.instabug.apm.di.a.A();
        com.instabug.apm.handler.networklog.a P = com.instabug.apm.di.a.P();
        com.instabug.apm.di.a.b("execution_traces_thread_executor").execute(new c(this, A));
        com.instabug.apm.di.a.b("network_log_thread_executor").execute(new d(this, P));
    }

    /* access modifiers changed from: private */
    public void endSession() {
        this.sessionHandler.b(0);
    }

    /* access modifiers changed from: private */
    public void handleV3SessionEvent(SDKCoreEvent sDKCoreEvent) {
        Session runningSession;
        String value = sDKCoreEvent.getValue();
        value.hashCode();
        if (value.equals("v3_finished")) {
            endSession();
        } else if (value.equals("v3_started") && (runningSession = InstabugCore.getRunningSession()) != null) {
            k.a(this);
            startSession(runningSession);
            registerSessionCrashHandler();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$registerAPMSdkStateEventBus$0(Boolean bool) {
        if (bool.booleanValue()) {
            registerFragmentLifecycleEventListener();
        } else {
            unRegisterFragmentLifecycleEventListener();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopRunningMetrics$1() {
        com.instabug.apm.handler.uitrace.e j02 = com.instabug.apm.di.a.j0();
        com.instabug.apm.handler.uitrace.customuitraces.a s11 = com.instabug.apm.di.a.s();
        j02.f();
        s11.c();
    }

    /* access modifiers changed from: private */
    public void purgeData() {
        com.instabug.apm.di.a.c().m(-1);
        com.instabug.apm.sync.a i11 = com.instabug.apm.di.a.i();
        com.instabug.apm.di.a.b("session_purging_thread_executor").execute(new b(this, i11, i11.b()));
    }

    /* access modifiers changed from: private */
    public void registerActivityLifeCycleCallbacks() {
        Context r11;
        com.instabug.apm.configuration.c c11 = com.instabug.apm.di.a.c();
        if (c11.H() && (r11 = com.instabug.apm.di.a.r()) != null && !com.instabug.apm.lifecycle.a.a()) {
            com.instabug.apm.lifecycle.a a11 = com.instabug.apm.di.a.a(r11, c11.Q() || c11.P(), false);
            if (a11 != null) {
                ((Application) r11.getApplicationContext()).registerActivityLifecycleCallbacks(a11);
            }
        }
    }

    private void registerConfigurationChange() {
        CompositeDisposable compositeDisposable = this.sdkCoreEventsSubscriberDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.sdkCoreEventsSubscriberDisposable = new CompositeDisposable();
        }
        this.sdkCoreEventsSubscriberDisposable.add(SDKCoreEventSubscriber.subscribe(new e()));
        this.sdkCoreEventsSubscriberDisposable.add(com.instabug.apm.di.a.U().subscribe(new f()));
    }

    /* access modifiers changed from: private */
    public void registerFragmentLifecycleEventListener() {
        this.fragmentSpansHelper.c();
    }

    /* access modifiers changed from: private */
    public void registerSessionCrashHandler() {
        if (com.instabug.apm.di.a.c().a0() && !(Thread.getDefaultUncaughtExceptionHandler() instanceof com.instabug.apm.handler.session.b)) {
            InstabugSDKLogger.d("IBG-APM", "setting Uncaught Exception Handler APMUncaughtExceptionHandler");
            Thread.setDefaultUncaughtExceptionHandler(new com.instabug.apm.handler.session.b());
        }
    }

    private boolean shouldDependOnV3Session(com.instabug.apm.configuration.c cVar, @Nullable Session session) {
        return session != null && session.getVersion().equals(SessionVersion.V2) && cVar.V();
    }

    /* access modifiers changed from: private */
    public void startSession(@NonNull Session session) {
        this.sessionHandler.a(session);
    }

    /* access modifiers changed from: private */
    public void stopRunningMetrics() {
        com.instabug.apm.di.a.P().c();
        PoolProvider.postMainThreadTask(new lb.d());
    }

    private void subscribeToSDKState() {
        CompositeDisposable compositeDisposable = this.sdkCoreEventsSubscriberDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.sdkCoreEventsSubscriberDisposable = new CompositeDisposable();
        }
        this.sdkCoreEventsSubscriberDisposable.add(InstabugStateEventBus.getInstance().getEventObservable().subscribe(new a()));
    }

    private void unRegisterApmSDKStateEventBus() {
        Unsubscribable unsubscribable = this.apmSdkStateObserver;
        if (unsubscribable != null) {
            unsubscribable.unsubscribe();
            this.apmSdkStateObserver = null;
        }
    }

    private void unRegisterFragmentLifecycleEventListener() {
        this.fragmentSpansHelper.a();
    }

    /* access modifiers changed from: private */
    public void updateCurrentSession() {
        com.instabug.apm.di.a.c0().execute(new g());
    }

    public long getLastActivityTime() {
        return 0;
    }

    @NonNull
    public FeatureSessionDataController getSessionDataController() {
        return com.instabug.apm.di.a.V();
    }

    public boolean isFeatureEnabled() {
        return com.instabug.apm.di.a.c().H();
    }

    @WorkerThread
    public void onNewSessionStarted(@NonNull Session session, @Nullable Session session2) {
        if (session2 != null) {
            com.instabug.apm.di.a.R().a(session, session2);
            com.instabug.apm.di.a.C().a(session, session2);
        }
        com.instabug.apm.di.a.H().b();
        com.instabug.apm.di.a.i().a();
    }

    @VisibleForTesting
    public void registerAPMSdkStateEventBus() {
        if (this.apmSdkStateObserver == null) {
            this.apmSdkStateObserver = com.instabug.apm.eventbus.a.f45302a.subscribe(new lb.c(this));
        }
    }

    public void sleep() {
        unRegisterApmSDKStateEventBus();
        endSession();
    }

    public void start(Context context) {
        this.isFirstLaunch = true;
        registerConfigurationChange();
        subscribeToSDKState();
    }

    public void stop() {
        CompositeDisposable compositeDisposable = this.sdkCoreEventsSubscriberDisposable;
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            this.sdkCoreEventsSubscriberDisposable.dispose();
        }
    }

    public void wake() {
        com.instabug.apm.configuration.c c11 = com.instabug.apm.di.a.c();
        if (c11.H() && this.isFirstLaunch) {
            clearInvalidCache();
            this.isFirstLaunch = false;
        }
        Session runningSession = InstabugCore.getRunningSession();
        if (shouldDependOnV3Session(c11, runningSession)) {
            this.apmLogger.a("v2 trying to start apm session while v3 enabled.. skipping");
        } else if (runningSession != null) {
            k.a(this);
            startSession(runningSession);
            registerSessionCrashHandler();
            registerFragmentLifecycleEventListener();
            registerAPMSdkStateEventBus();
        } else {
            this.apmLogger.e("APM session not created. Core session is null");
        }
    }
}
