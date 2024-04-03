package com.instabug.library.core;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.InstabugState;
import com.instabug.library.core.eventbus.InstabugStateEventBus;
import com.instabug.library.diagnostics.customtraces.IBGPendingTraceHandler;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.a;

public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f34183a = new b();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static Disposable f34184b;

    private b() {
    }

    @JvmStatic
    public static final void a() {
        if (f34184b == null) {
            f34184b = InstabugStateEventBus.getInstance().subscribe(new a());
        }
    }

    /* access modifiers changed from: private */
    public static final void b(InstabugState instabugState) {
        b bVar = f34183a;
        Intrinsics.checkNotNullExpressionValue(instabugState, "it");
        bVar.a(instabugState);
    }

    @JvmStatic
    public static final void b() {
        Disposable disposable = f34184b;
        if (disposable != null) {
            disposable.dispose();
        }
        f34184b = null;
    }

    @VisibleForTesting
    public final void a(@NotNull InstabugState instabugState) {
        Intrinsics.checkNotNullParameter(instabugState, "state");
        if (a.f34182a[instabugState.ordinal()] == 1) {
            IBGPendingTraceHandler.INSTANCE.flushTraces();
        }
    }
}
