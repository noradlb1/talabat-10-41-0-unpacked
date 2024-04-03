package com.instabug.library.model.v3Session;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final d f51594c = new d((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a0 f51595a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f51596b;

    public e(@NotNull a0 a0Var, @NotNull String str) {
        Intrinsics.checkNotNullParameter(a0Var, "startTime");
        Intrinsics.checkNotNullParameter(str, "id");
        this.f51595a = a0Var;
        this.f51596b = str;
    }

    public static /* synthetic */ e a(e eVar, a0 a0Var, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            a0Var = eVar.f51595a;
        }
        if ((i11 & 2) != 0) {
            str = eVar.f51596b;
        }
        return eVar.a(a0Var, str);
    }

    @NotNull
    public final e a(@NotNull a0 a0Var, @NotNull String str) {
        Intrinsics.checkNotNullParameter(a0Var, "startTime");
        Intrinsics.checkNotNullParameter(str, "id");
        return new e(a0Var, str);
    }

    @NotNull
    public final String a() {
        return this.f51596b;
    }

    @NotNull
    public final a0 b() {
        return this.f51595a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual((Object) this.f51595a, (Object) eVar.f51595a) && Intrinsics.areEqual((Object) this.f51596b, (Object) eVar.f51596b);
    }

    public int hashCode() {
        return (this.f51595a.hashCode() * 31) + this.f51596b.hashCode();
    }

    @NotNull
    public String toString() {
        return "IBGInMemorySession(startTime=" + this.f51595a + ", id=" + this.f51596b + ')';
    }
}
