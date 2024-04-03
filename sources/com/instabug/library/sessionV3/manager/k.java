package com.instabug.library.sessionV3.manager;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.model.common.Session;
import com.instabug.library.model.v3Session.m;
import com.instabug.library.model.v3Session.n;
import com.instabug.library.model.v3Session.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class k implements j {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final k f51812a = new k();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static volatile o f51813b;

    private k() {
    }

    private final void b(o oVar) {
        if (oVar instanceof n) {
            c();
        } else if (Intrinsics.areEqual((Object) oVar, (Object) m.f51617a)) {
            b();
        }
    }

    private final void c() {
        SDKCoreEventPublisher.post(new SDKCoreEvent("v3_session", "v3_started"));
    }

    @Nullable
    public Session a() {
        Session a11;
        synchronized (this) {
            o oVar = f51813b;
            a11 = oVar instanceof n ? ((n) oVar).a() : null;
        }
        return a11;
    }

    private final void b() {
        SDKCoreEventPublisher.post(new SDKCoreEvent("v3_session", "v3_finished"));
    }

    public void a(@NotNull o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "state");
        synchronized (this) {
            f51813b = oVar;
            f51812a.b(oVar);
            Unit unit = Unit.INSTANCE;
        }
    }
}
