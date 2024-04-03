package com.instabug.apm.fragment.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f45337a;

    /* renamed from: b  reason: collision with root package name */
    private final long f45338b;

    /* renamed from: c  reason: collision with root package name */
    private final long f45339c;

    /* renamed from: d  reason: collision with root package name */
    private final long f45340d;

    public b(@NotNull String str, long j11, long j12, long j13) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f45337a = str;
        this.f45338b = j11;
        this.f45339c = j12;
        this.f45340d = j13;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, long j11, long j12, long j13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11, (i11 & 4) != 0 ? 0 : j12, (i11 & 8) != 0 ? 0 : j13);
    }

    public final long a() {
        return this.f45339c;
    }

    @NotNull
    public final String b() {
        return this.f45337a;
    }

    public final long c() {
        return this.f45338b;
    }

    public final long d() {
        return this.f45340d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual((Object) this.f45337a, (Object) bVar.f45337a) && this.f45338b == bVar.f45338b && this.f45339c == bVar.f45339c && this.f45340d == bVar.f45340d;
    }

    public int hashCode() {
        return (((((this.f45337a.hashCode() * 31) + a.a(this.f45338b)) * 31) + a.a(this.f45339c)) * 31) + a.a(this.f45340d);
    }

    @NotNull
    public String toString() {
        return "FragmentSpansEvent(name=" + this.f45337a + ", startTime=" + this.f45338b + ", duration=" + this.f45339c + ", startTimeNano=" + this.f45340d + ')';
    }
}
