package j$.util;

import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Comparator;

final class Y implements G {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f28594a;

    /* renamed from: b  reason: collision with root package name */
    private int f28595b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28596c;

    /* renamed from: d  reason: collision with root package name */
    private final int f28597d;

    public Y(long[] jArr, int i11, int i12, int i13) {
        this.f28594a = jArr;
        this.f28595b = i11;
        this.f28596c = i12;
        this.f28597d = i13 | 64 | 16384;
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.p(this, consumer);
    }

    /* renamed from: b */
    public final void forEachRemaining(C0152f0 f0Var) {
        int i11;
        f0Var.getClass();
        long[] jArr = this.f28594a;
        int length = jArr.length;
        int i12 = this.f28596c;
        if (length >= i12 && (i11 = this.f28595b) >= 0) {
            this.f28595b = i12;
            if (i11 < i12) {
                do {
                    f0Var.accept(jArr[i11]);
                    i11++;
                } while (i11 < i12);
            }
        }
    }

    public final int characteristics() {
        return this.f28597d;
    }

    /* renamed from: e */
    public final boolean tryAdvance(C0152f0 f0Var) {
        f0Var.getClass();
        int i11 = this.f28595b;
        if (i11 < 0 || i11 >= this.f28596c) {
            return false;
        }
        this.f28595b = i11 + 1;
        f0Var.accept(this.f28594a[i11]);
        return true;
    }

    public final long estimateSize() {
        return (long) (this.f28596c - this.f28595b);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.h(this, consumer);
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

    public final G trySplit() {
        int i11 = this.f28595b;
        int i12 = (this.f28596c + i11) >>> 1;
        if (i11 >= i12) {
            return null;
        }
        this.f28595b = i12;
        return new Y(this.f28594a, i11, i12, this.f28597d);
    }
}
