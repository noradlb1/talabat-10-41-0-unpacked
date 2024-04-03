package com.instabug.terminations;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.commons.diagnostics.event.DiagnosticEvent;
import com.instabug.commons.diagnostics.reporter.DiagnosticsReporter;
import com.instabug.commons.g;
import com.instabug.commons.lifecycle.c;
import com.instabug.commons.logging.a;
import com.instabug.commons.models.Incident;
import com.instabug.commons.snapshot.CaptorsRegistry;
import com.instabug.commons.snapshot.StateSnapshotCaptor;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.sessionV3.sync.SessionBatchingFilter;
import com.instabug.library.sessionV3.sync.SessionBatchingFilterKt;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.terminations.di.d;
import de.b;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class i0 implements g {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Disposable f52626a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f52627b;

    private final void g() {
        if (this.f52627b) {
            d.f52610a.o().start();
        }
    }

    /* access modifiers changed from: private */
    public final void h() {
        this.f52626a = d.f52610a.e().subscribe(new b(this));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void d() {
        d dVar = d.f52610a;
        if (dVar.s().isEnabled() != this.f52627b) {
            if (dVar.s().isEnabled()) {
                this.f52627b = true;
                a.b("Terminations is enabled");
                f();
                dVar.d().addWatcher(2);
                e();
                return;
            }
            this.f52627b = false;
            a.b("Terminations is disabled, clearing..");
            a(true);
            Context a11 = dVar.a();
            if (a11 != null) {
                dVar.b().b(a11);
            }
            dVar.d().removeWatcher(2);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final m e() {
        d dVar = d.f52610a;
        m invoke = dVar.t().invoke();
        a.b(Intrinsics.stringPlus("Trm migration result ", invoke));
        m mVar = null;
        if (!(invoke instanceof l)) {
            invoke = null;
        }
        if (invoke != null) {
            dVar.d().consentOnCleansing(2);
            b(invoke);
            c(invoke);
            a(invoke);
            g();
            mVar = invoke;
        }
        return mVar == null ? k.f52629a : mVar;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void f() {
        if (this.f52627b) {
            CaptorsRegistry c11 = d.f52610a.c();
            c11.start(2, StateSnapshotCaptor.Factory.invoke$default((Function0) null, (Function0) null, (Function1) null, (c) null, 15, (Object) null));
            c11.start(2, e.a(e.f52618a, (Function0) null, (Function0) null, (Function1) null, 7, (Object) null));
        }
    }

    public void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        d dVar = d.f52610a;
        dVar.d().addWatcher(2);
        dVar.r().a();
    }

    public void c() {
        a((Function0) new g0(this));
    }

    @WorkerThread
    private final void c(m mVar) {
        if (mVar instanceof l) {
            l lVar = (l) mVar;
            for (com.instabug.terminations.model.b bVar : lVar.a()) {
                d.f52610a.m().a(bVar.d(), bVar.getMetadata().getUuid(), bVar.getType());
            }
            for (String a11 : lVar.b()) {
                d.f52610a.m().a(a11, (String) null, Incident.Type.Termination);
            }
        }
    }

    public void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        d dVar = d.f52610a;
        boolean isEnabled = dVar.s().isEnabled();
        this.f52627b = isEnabled;
        if (!isEnabled) {
            dVar.d().removeWatcher(2);
        }
    }

    public void b() {
        a((Function0) new f0(this));
    }

    /* access modifiers changed from: private */
    public static final void b(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    public void a() {
        if (this.f52627b) {
            a((Function0) new h0(this));
        }
    }

    @WorkerThread
    private final void b(boolean z11) {
        CaptorsRegistry c11 = d.f52610a.c();
        c11.stop(2, 1);
        if (z11) {
            c11.stop(2, 2);
        }
    }

    public void a(@NotNull SDKCoreEvent sDKCoreEvent) {
        Intrinsics.checkNotNullParameter(sDKCoreEvent, "sdkCoreEvent");
        String type = sDKCoreEvent.getType();
        if (type != null) {
            int hashCode = type.hashCode();
            if (hashCode != -296668708) {
                if (hashCode != -290659267) {
                    if (hashCode == 1843485230 && type.equals(SDKCoreEvent.Network.TYPE_NETWORK) && Intrinsics.areEqual((Object) sDKCoreEvent.getValue(), (Object) SDKCoreEvent.Network.VALUE_ACTIVATED)) {
                        a.b("Terminations received network activated");
                        g();
                    }
                } else if (type.equals("features")) {
                    a.b("Terminations received features");
                    a((Function0) new d0(this));
                }
            } else if (type.equals(SDKCoreEvent.Feature.TYPE_FEATURES_FETCHED)) {
                a.b("Terminations received features fetched");
                a((Function0) new c0(sDKCoreEvent, this));
            }
        }
    }

    @WorkerThread
    private final void b(m mVar) {
        if (mVar instanceof l) {
            List<com.instabug.terminations.model.b> a11 = ((l) mVar).a();
            ArrayList<DiagnosticEvent> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(a11, 10));
            for (com.instabug.terminations.model.b bVar : a11) {
                arrayList.add(new CalibrationDiagnosticEvent((CalibrationDiagnosticEvent.IncidentType) new com.instabug.terminations.diagnostics.b(), CalibrationDiagnosticEvent.Action.Captured));
            }
            DiagnosticsReporter g11 = d.f52610a.g();
            for (DiagnosticEvent report : arrayList) {
                g11.report(report);
            }
        }
    }

    private final void a(Function0 function0) {
        d.f52610a.j().execute(new de.a(function0));
    }

    /* access modifiers changed from: private */
    public final void a(ActivityLifeCycleEvent activityLifeCycleEvent) {
        a.b(Intrinsics.stringPlus("Terminations received lifecycle event ", activityLifeCycleEvent));
        if (activityLifeCycleEvent == ActivityLifeCycleEvent.STARTED) {
            a((Function0) new e0(this));
            Disposable disposable = this.f52626a;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f52626a = null;
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void a(boolean z11) {
        b(z11);
        Disposable disposable = this.f52626a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f52626a = null;
    }

    @WorkerThread
    private final void a(m mVar) {
        if (mVar instanceof l) {
            Integer valueOf = Integer.valueOf(((l) mVar).a().size());
            SessionBatchingFilter sessionBatchingFilter = null;
            if (!(valueOf.intValue() > 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                valueOf.intValue();
                sessionBatchingFilter = SessionBatchingFilterKt.getNoneFilter();
            }
            if (sessionBatchingFilter == null) {
                sessionBatchingFilter = SessionBatchingFilterKt.getAllFilter();
            }
            InstabugCore.notifyV3SessionDataReadiness(sessionBatchingFilter);
        }
    }
}
