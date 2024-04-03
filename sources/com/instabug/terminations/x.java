package com.instabug.terminations;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class x implements b0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f52671a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List f52672b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f52673c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f52674d;

    public x(long j11, @NotNull List list, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(list, "foregroundTimeline");
        this.f52671a = j11;
        this.f52672b = list;
        this.f52673c = z11;
        this.f52674d = z12;
    }

    @NotNull
    public List a() {
        return this.f52672b;
    }

    public final boolean b() {
        return this.f52674d;
    }

    public final long c() {
        return this.f52671a;
    }

    public final boolean d() {
        return this.f52673c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f52671a == xVar.f52671a && Intrinsics.areEqual((Object) a(), (Object) xVar.a()) && this.f52673c == xVar.f52673c && this.f52674d == xVar.f52674d;
    }

    public int hashCode() {
        int a11 = ((a.a(this.f52671a) * 31) + a().hashCode()) * 31;
        boolean z11 = this.f52673c;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (a11 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.f52674d;
        if (!z13) {
            z12 = z13;
        }
        return i11 + (z12 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "PreAndroidRTerminationSnapshot(timestamp=" + this.f52671a + ", foregroundTimeline=" + a() + ", isInAnr=" + this.f52673c + ", hasCrashed=" + this.f52674d + ')';
    }
}
