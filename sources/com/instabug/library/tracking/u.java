package com.instabug.library.tracking;

import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.model.session.SessionState;
import com.instabug.library.util.threading.PoolProvider;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import md.c;
import md.d;
import org.jetbrains.annotations.NotNull;

public final class u {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f51947a = LazyKt__LazyJVMKt.lazy(t.f51946a);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f51948b = LazyKt__LazyJVMKt.lazy(s.f51945a);

    public u() {
        SessionStateEventBus.getInstance().subscribe(new d(this));
    }

    private final q a() {
        return (q) this.f51948b.getValue();
    }

    private final r b() {
        return (r) this.f51947a.getValue();
    }

    public final void c() {
        PoolProvider.postIOTask(new c(this));
    }

    /* access modifiers changed from: private */
    public static final void a(u uVar, SessionState sessionState) {
        r b11;
        Intrinsics.checkNotNullParameter(uVar, "this$0");
        if (sessionState == SessionState.FINISH && (b11 = uVar.b()) != null) {
            b11.a();
        }
    }

    /* access modifiers changed from: private */
    public static final void a(u uVar) {
        r b11;
        Intrinsics.checkNotNullParameter(uVar, "this$0");
        if (InstabugCore.getFeatureState(Feature.SCREEN_OFF_MONITOR) == Feature.State.ENABLED && (b11 = uVar.b()) != null) {
            b11.a(uVar.a());
        }
    }
}
