package com.instabug.library.model.v3Session;

import com.huawei.hms.flutter.map.constants.Param;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a0 {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final z f51588d = new z((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f51589a;

    /* renamed from: b  reason: collision with root package name */
    private final long f51590b;

    /* renamed from: c  reason: collision with root package name */
    private final long f51591c;

    public a0(long j11, long j12, long j13) {
        this.f51589a = j11;
        this.f51590b = j12;
        this.f51591c = j13;
    }

    public static /* synthetic */ a0 a(a0 a0Var, long j11, long j12, long j13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = a0Var.f51589a;
        }
        long j14 = j11;
        if ((i11 & 2) != 0) {
            j12 = a0Var.f51590b;
        }
        long j15 = j12;
        if ((i11 & 4) != 0) {
            j13 = a0Var.f51591c;
        }
        return a0Var.a(j14, j15, j13);
    }

    public final long a() {
        return this.f51590b;
    }

    @NotNull
    public final a0 a(long j11, long j12, long j13) {
        return new a0(j11, j12, j13);
    }

    public final long b() {
        return this.f51591c;
    }

    public final long c() {
        return this.f51589a;
    }

    public final long d() {
        if (e()) {
            return this.f51590b;
        }
        return this.f51591c;
    }

    public final boolean e() {
        return this.f51591c == -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f51589a == a0Var.f51589a && this.f51590b == a0Var.f51590b && this.f51591c == a0Var.f51591c;
    }

    public int hashCode() {
        return (((a.a(this.f51589a) * 31) + a.a(this.f51590b)) * 31) + a.a(this.f51591c);
    }

    @NotNull
    public String toString() {
        return "StartTime(startNanoTime=" + this.f51589a + ", backgroundMicroStartTime=" + this.f51590b + ", foregroundMicroStartTime=" + this.f51591c + ')';
    }

    @NotNull
    public Map a(@NotNull Map map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        if (b() != -1) {
            map.put("fs", Long.valueOf(b()));
        }
        if (a() != -1) {
            map.put("bs", Long.valueOf(a()));
        }
        return map;
    }
}
