package com.instabug.terminations;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class l extends m {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List f52630a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List f52631b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(@NotNull List list, @NotNull List list2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "incidents");
        Intrinsics.checkNotNullParameter(list2, "migratedSessions");
        this.f52630a = list;
        this.f52631b = list2;
    }

    @NotNull
    public final List a() {
        return this.f52630a;
    }

    @NotNull
    public final List b() {
        return this.f52631b;
    }
}
