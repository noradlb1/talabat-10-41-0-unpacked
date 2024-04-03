package j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.l  reason: case insensitive filesystem */
public final class C0187l {

    /* renamed from: c  reason: collision with root package name */
    private static final C0187l f28880c = new C0187l();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f28881a;

    /* renamed from: b  reason: collision with root package name */
    private final long f28882b;

    private C0187l() {
        this.f28881a = false;
        this.f28882b = 0;
    }

    private C0187l(long j11) {
        this.f28881a = true;
        this.f28882b = j11;
    }

    public static C0187l a() {
        return f28880c;
    }

    public static C0187l d(long j11) {
        return new C0187l(j11);
    }

    public final long b() {
        if (this.f28881a) {
            return this.f28882b;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.f28881a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0187l)) {
            return false;
        }
        C0187l lVar = (C0187l) obj;
        boolean z11 = this.f28881a;
        if (!z11 || !lVar.f28881a) {
            if (z11 == lVar.f28881a) {
                return true;
            }
        } else if (this.f28882b == lVar.f28882b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (!this.f28881a) {
            return 0;
        }
        long j11 = this.f28882b;
        return (int) (j11 ^ (j11 >>> 32));
    }

    public final String toString() {
        if (!this.f28881a) {
            return "OptionalLong.empty";
        }
        return String.format("OptionalLong[%s]", new Object[]{Long.valueOf(this.f28882b)});
    }
}
