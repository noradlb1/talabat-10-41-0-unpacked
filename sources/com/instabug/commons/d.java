package com.instabug.commons;

import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final int f46296a;

    /* renamed from: b  reason: collision with root package name */
    private final long f46297b;

    /* renamed from: c  reason: collision with root package name */
    private final int f46298c;

    public d(int i11, long j11, int i12) {
        this.f46296a = i11;
        this.f46297b = j11;
        this.f46298c = i12;
    }

    public final int a() {
        return this.f46298c;
    }

    public final int b() {
        return this.f46296a;
    }

    public final long c() {
        return this.f46297b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f46296a == dVar.f46296a && this.f46297b == dVar.f46297b && this.f46298c == dVar.f46298c;
    }

    public int hashCode() {
        return (((this.f46296a * 31) + a.a(this.f46297b)) * 31) + this.f46298c;
    }

    @NotNull
    public String toString() {
        return "OSExitInfo(internalReason=" + this.f46296a + ", timestamp=" + this.f46297b + ", importance=" + this.f46298c + ')';
    }
}
