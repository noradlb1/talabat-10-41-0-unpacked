package j$.util;

import java.util.NoSuchElementException;

/* renamed from: j$.util.k  reason: case insensitive filesystem */
public final class C0186k {

    /* renamed from: c  reason: collision with root package name */
    private static final C0186k f28877c = new C0186k();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f28878a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28879b;

    private C0186k() {
        this.f28878a = false;
        this.f28879b = 0;
    }

    private C0186k(int i11) {
        this.f28878a = true;
        this.f28879b = i11;
    }

    public static C0186k a() {
        return f28877c;
    }

    public static C0186k d(int i11) {
        return new C0186k(i11);
    }

    public final int b() {
        if (this.f28878a) {
            return this.f28879b;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean c() {
        return this.f28878a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0186k)) {
            return false;
        }
        C0186k kVar = (C0186k) obj;
        boolean z11 = this.f28878a;
        if (!z11 || !kVar.f28878a) {
            if (z11 == kVar.f28878a) {
                return true;
            }
        } else if (this.f28879b == kVar.f28879b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.f28878a) {
            return this.f28879b;
        }
        return 0;
    }

    public final String toString() {
        if (!this.f28878a) {
            return "OptionalInt.empty";
        }
        return String.format("OptionalInt[%s]", new Object[]{Integer.valueOf(this.f28879b)});
    }
}
