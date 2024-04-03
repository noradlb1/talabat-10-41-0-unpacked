package com.instabug.library.model.v3Session;

import com.instabug.library.sessionV3.di.c;
import com.instabug.library.sessionV3.providers.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class z {
    private z() {
    }

    public /* synthetic */ z(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ a0 a(z zVar, u uVar, a aVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            aVar = c.f51790a.a();
        }
        return zVar.a(uVar, aVar);
    }

    private final a0 b(long j11, long j12) {
        return new a0(j11, -1, j12);
    }

    @NotNull
    public final a0 a(@NotNull u uVar, @NotNull a aVar) {
        Intrinsics.checkNotNullParameter(uVar, "sessionEvent");
        Intrinsics.checkNotNullParameter(aVar, "backgroundStateProvider");
        long b11 = uVar.b();
        long a11 = uVar.a();
        if (aVar.a()) {
            return a0.f51588d.a(a11, b11);
        }
        return a0.f51588d.b(a11, b11);
    }

    private final a0 a(long j11, long j12) {
        return new a0(j11, j12, -1);
    }
}
