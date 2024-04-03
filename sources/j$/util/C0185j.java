package j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.j  reason: case insensitive filesystem */
public final class C0185j {

    /* renamed from: c  reason: collision with root package name */
    private static final C0185j f28874c = new C0185j();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f28875a;

    /* renamed from: b  reason: collision with root package name */
    private final double f28876b;

    private C0185j() {
        this.f28875a = false;
        this.f28876b = Double.NaN;
    }

    private C0185j(double d11) {
        this.f28875a = true;
        this.f28876b = d11;
    }

    public static C0185j a() {
        return f28874c;
    }

    public static C0185j d(double d11) {
        return new C0185j(d11);
    }

    public final double b() {
        if (this.f28875a) {
            return this.f28876b;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.f28875a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0185j)) {
            return false;
        }
        C0185j jVar = (C0185j) obj;
        boolean z11 = this.f28875a;
        if (!z11 || !jVar.f28875a) {
            if (z11 == jVar.f28875a) {
                return true;
            }
        } else if (Double.compare(this.f28876b, jVar.f28876b) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (!this.f28875a) {
            return 0;
        }
        long doubleToLongBits = Double.doubleToLongBits(this.f28876b);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public final String toString() {
        if (!this.f28875a) {
            return "OptionalDouble.empty";
        }
        return String.format("OptionalDouble[%s]", new Object[]{Double.valueOf(this.f28876b)});
    }
}
