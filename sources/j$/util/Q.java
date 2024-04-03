package j$.util;

import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Comparator;

final class Q implements A {

    /* renamed from: a  reason: collision with root package name */
    private final double[] f28570a;

    /* renamed from: b  reason: collision with root package name */
    private int f28571b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28572c;

    /* renamed from: d  reason: collision with root package name */
    private final int f28573d;

    public Q(double[] dArr, int i11, int i12, int i13) {
        this.f28570a = dArr;
        this.f28571b = i11;
        this.f28572c = i12;
        this.f28573d = i13 | 64 | 16384;
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.m(this, consumer);
    }

    public final int characteristics() {
        return this.f28573d;
    }

    /* renamed from: d */
    public final void forEachRemaining(C0165m mVar) {
        int i11;
        mVar.getClass();
        double[] dArr = this.f28570a;
        int length = dArr.length;
        int i12 = this.f28572c;
        if (length >= i12 && (i11 = this.f28571b) >= 0) {
            this.f28571b = i12;
            if (i11 < i12) {
                do {
                    mVar.accept(dArr[i11]);
                    i11++;
                } while (i11 < i12);
            }
        }
    }

    public final long estimateSize() {
        return (long) (this.f28572c - this.f28571b);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.f(this, consumer);
    }

    public final Comparator getComparator() {
        if (C0189n.k(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    /* renamed from: o */
    public final boolean tryAdvance(C0165m mVar) {
        mVar.getClass();
        int i11 = this.f28571b;
        if (i11 < 0 || i11 >= this.f28572c) {
            return false;
        }
        this.f28571b = i11 + 1;
        mVar.accept(this.f28570a[i11]);
        return true;
    }

    public final A trySplit() {
        int i11 = this.f28571b;
        int i12 = (this.f28572c + i11) >>> 1;
        if (i11 >= i12) {
            return null;
        }
        this.f28571b = i12;
        return new Q(this.f28570a, i11, i12, this.f28573d);
    }
}
