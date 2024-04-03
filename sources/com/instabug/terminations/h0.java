package com.instabug.terminations;

import com.instabug.commons.logging.a;
import com.instabug.commons.models.Incident;
import com.instabug.commons.session.g;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.common.Session;
import com.instabug.terminations.di.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

final class h0 extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ i0 f52624g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(i0 i0Var) {
        super(0);
        this.f52624g = i0Var;
    }

    public final void a() {
        this.f52624g.f();
        Session runningSession = InstabugCore.getRunningSession();
        if (runningSession != null) {
            g m11 = d.f52610a.m();
            String id2 = runningSession.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "session.id");
            m11.a(id2, Incident.Type.Termination);
        }
        if (this.f52624g.e() instanceof k) {
            a.b("Terminations migration failed on wake, subscribing to lifecycle");
            this.f52624g.h();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        a();
        return Unit.INSTANCE;
    }
}
