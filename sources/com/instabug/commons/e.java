package com.instabug.commons;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final long f46325a;

    /* renamed from: b  reason: collision with root package name */
    private final long f46326b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final List f46327c;

    public e(long j11, long j12, @NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "infoList");
        this.f46325a = j11;
        this.f46326b = j12;
        this.f46327c = list;
    }

    public final long a() {
        return this.f46326b;
    }

    @NotNull
    public final List b() {
        return this.f46327c;
    }

    public final long c() {
        return this.f46325a;
    }
}
