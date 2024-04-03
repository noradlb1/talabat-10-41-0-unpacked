package com.instabug.library.diagnostics;

import com.instabug.library.diagnostics.customtraces.a;
import com.instabug.library.diagnostics.nonfatals.e;
import com.instabug.library.diagnostics.sdkEvents.f;
import com.instabug.library.model.session.SessionState;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final d f34241a = new d();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final a f34242b = com.instabug.library.diagnostics.customtraces.di.a.d();

    private d() {
    }

    private final g a() {
        return com.instabug.library.diagnostics.di.a.b();
    }

    private final e b() {
        return com.instabug.library.diagnostics.nonfatals.di.a.g();
    }

    private final f c() {
        return com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.j();
    }

    @JvmStatic
    public static final void a(@NotNull SessionState sessionState) {
        Intrinsics.checkNotNullParameter(sessionState, "state");
        if (sessionState == SessionState.START) {
            d dVar = f34241a;
            dVar.c().a();
            dVar.a().a();
            f34242b.removeUnEndedTraces();
            e b11 = dVar.b();
            if (b11 != null) {
                b11.c();
            }
            e b12 = dVar.b();
            if (b12 != null) {
                b12.b();
            }
        }
    }
}
