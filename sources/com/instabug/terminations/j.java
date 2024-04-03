package com.instabug.terminations;

import com.instabug.terminations.configuration.c;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class j implements j0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final c f52628a;

    public j(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "configProvider");
        this.f52628a = cVar;
    }

    public boolean a(long j11, long j12) {
        long j13 = j11 - j12;
        return j13 > 0 && j13 <= this.f52628a.a();
    }
}
