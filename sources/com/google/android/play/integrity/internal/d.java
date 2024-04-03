package com.google.android.play.integrity.internal;

final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private final long f44576a;

    public d(int i11, long j11) {
        this.f44576a = j11;
    }

    public final int a() {
        return 3;
    }

    public final long b() {
        return this.f44576a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            eVar.a();
            if (this.f44576a == eVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j11 = this.f44576a;
        return ((int) (j11 ^ (j11 >>> 32))) ^ -724379968;
    }

    public final String toString() {
        long j11 = this.f44576a;
        return "EventRecord{eventType=3, eventTimestamp=" + j11 + "}";
    }
}
