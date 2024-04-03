package com.instabug.library.sessionV3.sync;

import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.sessionV3.configurations.c;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ld.i;
import org.jetbrains.annotations.NotNull;

public final class t implements o {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final t f51850a = new t();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f51851b = LazyKt__LazyJVMKt.lazy(s.f51849a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Lazy f51852c = LazyKt__LazyJVMKt.lazy(r.f51848a);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Lazy f51853d = LazyKt__LazyJVMKt.lazy(p.f51846a);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Lazy f51854e = LazyKt__LazyJVMKt.lazy(q.f51847a);

    private t() {
    }

    private final c a() {
        return (c) f51853d.getValue();
    }

    private final c b() {
        return (c) f51854e.getValue();
    }

    private final Executor c() {
        return (Executor) f51852c.getValue();
    }

    private final InstabugNetworkJob d() {
        return (InstabugNetworkJob) f51851b.getValue();
    }

    /* access modifiers changed from: private */
    public static final void b(SessionBatchingFilter sessionBatchingFilter) {
        Intrinsics.checkNotNullParameter(sessionBatchingFilter, "$batchingFilter");
        t tVar = f51850a;
        if (tVar.b().i()) {
            tVar.a().a(sessionBatchingFilter);
            tVar.d().start();
        }
    }

    public void a(@NotNull SessionBatchingFilter sessionBatchingFilter) {
        Intrinsics.checkNotNullParameter(sessionBatchingFilter, "batchingFilter");
        c().execute(new i(sessionBatchingFilter));
    }
}
