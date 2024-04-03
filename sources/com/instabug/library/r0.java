package com.instabug.library;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.internal.orchestrator.ActionsOrchestrator;
import com.instabug.library.internal.orchestrator.l;
import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;
import com.instabug.library.internal.video.i;
import com.instabug.library.model.common.Session;
import com.instabug.library.model.common.a;
import com.instabug.library.model.session.SessionMapper;
import com.instabug.library.model.session.SessionState;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.user.f;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import md.e;

public class r0 {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static r0 f50588c;

    /* renamed from: a  reason: collision with root package name */
    private SettingsManager f50589a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private a f50590b;

    private r0(SettingsManager settingsManager) {
        this.f50589a = settingsManager;
        q();
    }

    public static synchronized void a(SettingsManager settingsManager) {
        synchronized (r0.class) {
            if (f50588c == null) {
                f50588c = new r0(settingsManager);
            }
        }
    }

    public static synchronized r0 e() {
        r0 r0Var;
        synchronized (r0.class) {
            r0Var = f50588c;
            if (r0Var == null) {
                r0Var = new r0(SettingsManager.getInstance());
                f50588c = r0Var;
            }
        }
        return r0Var;
    }

    private int f() {
        return e.a().getCount();
    }

    private long g() {
        long geLastForegroundTime = SettingsManager.getInstance().geLastForegroundTime();
        if (geLastForegroundTime != -1) {
            return (System.currentTimeMillis() - geLastForegroundTime) / 1000;
        }
        return geLastForegroundTime;
    }

    /* access modifiers changed from: private */
    public void h() {
    }

    /* access modifiers changed from: private */
    public void i() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            e0.c().g(applicationContext);
        } else {
            InstabugSDKLogger.e("IBG-Core", "unable to saveFeaturesToSharedPreferences due to null appContext");
        }
        if (f() == 0 && Instabug.getApplicationContext() != null && i.a(Instabug.getApplicationContext())) {
            b();
        }
    }

    private void j() {
        if (this.f50589a.getSessionStartedAt() != 0) {
            a aVar = this.f50590b;
            if (aVar != null) {
                a(aVar);
                m();
                n();
                a(SessionState.FINISH);
            }
        } else {
            InstabugSDKLogger.d("IBG-Core", "Instabug is enabled after session started, Session ignored");
        }
        o();
    }

    private boolean l() {
        if (!e0.c().g()) {
            return false;
        }
        long sessionStitchingTimeoutInSeconds = (long) SettingsManager.getInstance().getSessionStitchingTimeoutInSeconds(1800);
        long g11 = g();
        if (g11 == -1 || g11 > sessionStitchingTimeoutInSeconds) {
            InstabugSDKLogger.v("IBG-Core", "started new billable session");
            return true;
        }
        InstabugSDKLogger.v("IBG-Core", "session stitched");
        return false;
    }

    private void m() {
        if (SettingsManager.getInstance().isFirstDismiss()) {
            SettingsManager.getInstance().setIsFirstDismiss(false);
        }
    }

    private void n() {
        long currentTimeMillis = System.currentTimeMillis();
        InstabugCore.setLastSeenTimestamp(currentTimeMillis);
        ActionsOrchestrator.obtainOrchestrator(PoolProvider.getSingleThreadExecutor("last-seen-record")).addWorkerThreadAction(new l(f.k(), currentTimeMillis)).orchestrate();
    }

    private void o() {
        c((a) null);
    }

    private void q() {
        CurrentActivityLifeCycleEventBus.getInstance().subscribe(new p0(this));
    }

    private void r() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.f50589a.setSessionStartedAt(currentTimeMillis);
        if (SettingsManager.getInstance().isFirstRun()) {
            this.f50589a.setIsFirstRun(false);
        }
        if (SettingsManager.getInstance().getFirstRunAt().getTime() == 0) {
            this.f50589a.setFirstRunAt(System.currentTimeMillis());
        }
        this.f50589a.incrementSessionsCount();
        ActionsOrchestrator.obtainOrchestrator().addWorkerThreadAction(new l(f.k(), currentTimeMillis * 1000)).orchestrate();
    }

    public synchronized void k() {
        c(a());
        a(SessionState.START);
        if (SettingsManager.getInstance().autoScreenRecordingEnabled()) {
            InternalAutoScreenRecorderHelper.getInstance().start();
        }
    }

    public synchronized void p() {
        InstabugSDKLogger.d("IBG-Core", "Instabug is disabled during app session, ending current session");
        SettingsManager.getInstance().setInBackground(false);
        j();
    }

    private void c(@Nullable a aVar) {
        this.f50590b = aVar;
    }

    public synchronized void b() {
        if (e0.c().b((Object) Feature.INSTABUG) == Feature.State.ENABLED) {
            SettingsManager.getInstance().setInBackground(true);
            if (e0.c().g()) {
                SettingsManager.getInstance().setLastForegroundTime(System.currentTimeMillis());
            }
            j();
        }
    }

    public long d() {
        if (this.f50589a.getSessionStartedAt() == 0) {
            return 0;
        }
        return (System.currentTimeMillis() / 1000) - this.f50589a.getSessionStartedAt();
    }

    private void a(@NonNull a aVar) {
        if (SettingsManager.getInstance().isSessionEnabled()) {
            b(aVar).flatMapCompletable(new n0(this)).subscribeOn(Schedulers.io()).subscribe((CompletableObserver) new m0(this));
        }
    }

    @Nullable
    public synchronized Session c() {
        return this.f50590b;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private Single b(@NonNull a aVar) {
        return Single.create(new o0(this, aVar));
    }

    private void a(SessionState sessionState) {
        if (sessionState.equals(SessionState.FINISH)) {
            SettingsManager.getInstance().setIsAppOnForeground(false);
            SDKCoreEventPublisher.post(new SDKCoreEvent(SDKCoreEvent.Session.TYPE_SESSION, SDKCoreEvent.Session.VALUE_FINISHED));
        } else {
            SettingsManager.getInstance().setIsAppOnForeground(true);
            SDKCoreEventPublisher.post(new SDKCoreEvent(SDKCoreEvent.Session.TYPE_SESSION, "started"));
        }
        SessionStateEventBus.getInstance().post(sessionState);
    }

    /* access modifiers changed from: private */
    public void a(boolean z11) {
        SettingsManager.getInstance().setIsFirstSession(z11);
    }

    @NonNull
    private a a() {
        a aVar = this.f50590b;
        if (aVar != null) {
            return aVar;
        }
        r();
        Context applicationContext = Instabug.getApplicationContext();
        return SessionMapper.toSession(UUID.randomUUID().toString(), DeviceStateProvider.getOS(), f.k(), applicationContext != null ? DeviceStateProvider.getAppVersion(applicationContext) : null, TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis()), System.nanoTime(), l());
    }
}
