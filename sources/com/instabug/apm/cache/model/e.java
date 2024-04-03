package com.instabug.apm.cache.model;

import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final long f45208a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f45209b;

    /* renamed from: c  reason: collision with root package name */
    private final long f45210c;

    /* renamed from: d  reason: collision with root package name */
    private final long f45211d;

    /* renamed from: e  reason: collision with root package name */
    private final long f45212e;

    public e(long j11, @NotNull String str, long j12, long j13, long j14) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f45208a = j11;
        this.f45209b = str;
        this.f45210c = j12;
        this.f45211d = j13;
        this.f45212e = j14;
    }

    public final long a() {
        return this.f45211d;
    }

    @NotNull
    public final String b() {
        return this.f45209b;
    }

    public final long c() {
        return this.f45210c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f45208a == eVar.f45208a && Intrinsics.areEqual((Object) this.f45209b, (Object) eVar.f45209b) && this.f45210c == eVar.f45210c && this.f45211d == eVar.f45211d && this.f45212e == eVar.f45212e;
    }

    public int hashCode() {
        return (((((((a.a(this.f45208a) * 31) + this.f45209b.hashCode()) * 31) + a.a(this.f45210c)) * 31) + a.a(this.f45211d)) * 31) + a.a(this.f45212e);
    }

    @NotNull
    public String toString() {
        return "FragmentSpansEventCacheModel(id=" + this.f45208a + ", name=" + this.f45209b + ", startTime=" + this.f45210c + ", duration=" + this.f45211d + ", fragmentId=" + this.f45212e + ')';
    }
}
