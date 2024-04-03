package com.instabug.apm;

import androidx.annotation.WorkerThread;
import com.instabug.apm.cache.model.f;
import com.instabug.apm.handler.applaunch.a;
import com.instabug.apm.handler.session.c;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class i implements FeatureSessionDataController {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final i f45452a = new i();

    private i() {
    }

    private final a a() {
        return com.instabug.apm.di.a.n();
    }

    private final void a(f fVar) {
        com.instabug.apm.cache.handler.session.f g11 = g();
        fVar.a(g11 == null ? null : g11.a(fVar.getId()));
        fVar.a(a().b(fVar.getId()));
        fVar.e(d().a(fVar.getId()));
        fVar.b(b().a(fVar.getId()));
        fVar.f(h().a(fVar.getId()));
        com.instabug.apm.handler.fragment.a c11 = c();
        String id2 = fVar.getId();
        Intrinsics.checkNotNullExpressionValue(id2, "id");
        fVar.d(c11.a(id2));
    }

    private final com.instabug.apm.handler.executiontraces.a b() {
        return com.instabug.apm.di.a.A();
    }

    private final com.instabug.apm.handler.fragment.a c() {
        return com.instabug.apm.di.a.L();
    }

    private final com.instabug.apm.handler.networklog.a d() {
        return com.instabug.apm.di.a.P();
    }

    private final c e() {
        c W = com.instabug.apm.di.a.W();
        Intrinsics.checkNotNullExpressionValue(W, "getSessionHandler()");
        return W;
    }

    private final com.instabug.apm.networking.mapping.sessions.a f() {
        com.instabug.apm.networking.mapping.sessions.a X = com.instabug.apm.di.a.X();
        Intrinsics.checkNotNullExpressionValue(X, "getSessionMapper()");
        return X;
    }

    private final com.instabug.apm.cache.handler.session.f g() {
        return com.instabug.apm.di.a.Y();
    }

    private final com.instabug.apm.cache.handler.uitrace.c h() {
        return com.instabug.apm.di.a.i0();
    }

    @NotNull
    @WorkerThread
    public Map collectSessionsData(@NotNull List list) {
        List<f> a11;
        Intrinsics.checkNotNullParameter(list, "sessionsIds");
        c e11 = e();
        Map map = null;
        if (list.isEmpty()) {
            e11 = null;
        }
        if (!(e11 == null || (a11 = e11.a(list)) == null)) {
            for (f fVar : a11) {
                i iVar = f45452a;
                Intrinsics.checkNotNullExpressionValue(fVar, SDKCoreEvent.Session.TYPE_SESSION);
                iVar.a(fVar);
            }
            map = f().b(a11);
        }
        return map == null ? MapsKt__MapsKt.emptyMap() : map;
    }

    @WorkerThread
    public void dropSessionData(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "sessionsIds");
        e().b(list);
    }
}
