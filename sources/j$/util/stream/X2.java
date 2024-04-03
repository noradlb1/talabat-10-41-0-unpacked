package j$.util.stream;

import j$.util.C0189n;
import j$.util.J;
import java.util.Comparator;
import java.util.Objects;

abstract class X2 implements J {

    /* renamed from: a  reason: collision with root package name */
    int f29061a;

    /* renamed from: b  reason: collision with root package name */
    final int f29062b;

    /* renamed from: c  reason: collision with root package name */
    int f29063c;

    /* renamed from: d  reason: collision with root package name */
    final int f29064d;

    /* renamed from: e  reason: collision with root package name */
    Object f29065e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Y2 f29066f;

    X2(Y2 y22, int i11, int i12, int i13, int i14) {
        this.f29066f = y22;
        this.f29061a = i11;
        this.f29062b = i12;
        this.f29063c = i13;
        this.f29064d = i14;
        Object[] objArr = y22.f29071f;
        this.f29065e = objArr == null ? y22.f29070e : objArr[i11];
    }

    public final int characteristics() {
        return 16464;
    }

    public final long estimateSize() {
        int i11 = this.f29061a;
        int i12 = this.f29064d;
        int i13 = this.f29062b;
        if (i11 == i13) {
            return ((long) i12) - ((long) this.f29063c);
        }
        long[] jArr = this.f29066f.f29134d;
        return ((jArr[i13] + ((long) i12)) - jArr[i11]) - ((long) this.f29063c);
    }

    /* access modifiers changed from: package-private */
    public abstract void f(int i11, Object obj, Object obj2);

    /* renamed from: forEachRemaining */
    public final void d(Object obj) {
        Y2 y22;
        Objects.requireNonNull(obj);
        int i11 = this.f29061a;
        int i12 = this.f29064d;
        int i13 = this.f29062b;
        if (i11 < i13 || (i11 == i13 && this.f29063c < i12)) {
            int i14 = this.f29063c;
            while (true) {
                y22 = this.f29066f;
                if (i11 >= i13) {
                    break;
                }
                Object obj2 = y22.f29071f[i11];
                y22.r(obj2, i14, y22.s(obj2), obj);
                i11++;
                i14 = 0;
            }
            y22.r(this.f29061a == i13 ? this.f29065e : y22.f29071f[i13], i14, i12, obj);
            this.f29061a = i13;
            this.f29063c = i12;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract J g(Object obj, int i11, int i12);

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    /* access modifiers changed from: package-private */
    public abstract J h(int i11, int i12, int i13, int i14);

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    /* renamed from: tryAdvance */
    public final boolean o(Object obj) {
        Objects.requireNonNull(obj);
        int i11 = this.f29061a;
        int i12 = this.f29062b;
        if (i11 >= i12 && (i11 != i12 || this.f29063c >= this.f29064d)) {
            return false;
        }
        Object obj2 = this.f29065e;
        int i13 = this.f29063c;
        this.f29063c = i13 + 1;
        f(i13, obj2, obj);
        int i14 = this.f29063c;
        Object obj3 = this.f29065e;
        Y2 y22 = this.f29066f;
        if (i14 == y22.s(obj3)) {
            this.f29063c = 0;
            int i15 = this.f29061a + 1;
            this.f29061a = i15;
            Object[] objArr = y22.f29071f;
            if (objArr != null && i15 <= i12) {
                this.f29065e = objArr[i15];
            }
        }
        return true;
    }

    public final J trySplit() {
        int i11 = this.f29061a;
        int i12 = this.f29062b;
        if (i11 < i12) {
            int i13 = this.f29063c;
            Y2 y22 = this.f29066f;
            J h11 = h(i11, i12 - 1, i13, y22.s(y22.f29071f[i12 - 1]));
            this.f29061a = i12;
            this.f29063c = 0;
            this.f29065e = y22.f29071f[i12];
            return h11;
        } else if (i11 != i12) {
            return null;
        } else {
            int i14 = this.f29063c;
            int i15 = (this.f29064d - i14) / 2;
            if (i15 == 0) {
                return null;
            }
            J g11 = g(this.f29065e, i14, i15);
            this.f29063c += i15;
            return g11;
        }
    }
}
