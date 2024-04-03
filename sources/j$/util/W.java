package j$.util;

import j$.util.function.Consumer;
import j$.util.function.K;
import java.util.Comparator;

final class W implements D {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f28585a;

    /* renamed from: b  reason: collision with root package name */
    private int f28586b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28587c;

    /* renamed from: d  reason: collision with root package name */
    private final int f28588d;

    public W(int[] iArr, int i11, int i12, int i13) {
        this.f28585a = iArr;
        this.f28586b = i11;
        this.f28587c = i12;
        this.f28588d = i13 | 64 | 16384;
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.n(this, consumer);
    }

    /* renamed from: c */
    public final void forEachRemaining(K k11) {
        int i11;
        k11.getClass();
        int[] iArr = this.f28585a;
        int length = iArr.length;
        int i12 = this.f28587c;
        if (length >= i12 && (i11 = this.f28586b) >= 0) {
            this.f28586b = i12;
            if (i11 < i12) {
                do {
                    k11.accept(iArr[i11]);
                    i11++;
                } while (i11 < i12);
            }
        }
    }

    public final int characteristics() {
        return this.f28588d;
    }

    public final long estimateSize() {
        return (long) (this.f28587c - this.f28586b);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.g(this, consumer);
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

    /* renamed from: j */
    public final boolean tryAdvance(K k11) {
        k11.getClass();
        int i11 = this.f28586b;
        if (i11 < 0 || i11 >= this.f28587c) {
            return false;
        }
        this.f28586b = i11 + 1;
        k11.accept(this.f28585a[i11]);
        return true;
    }

    public final D trySplit() {
        int i11 = this.f28586b;
        int i12 = (this.f28587c + i11) >>> 1;
        if (i11 >= i12) {
            return null;
        }
        this.f28586b = i12;
        return new W(this.f28585a, i11, i12, this.f28588d);
    }
}
