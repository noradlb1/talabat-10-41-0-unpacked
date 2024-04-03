package j$.util.stream;

import j$.util.C0189n;
import j$.util.J;
import java.util.Comparator;
import java.util.Objects;

abstract class E3 extends G3 implements J {
    E3(J j11, long j12, long j13) {
        super(j11, j12, j13, 0, Math.min(j11.estimateSize(), j13));
    }

    E3(J j11, long j12, long j13, long j14, long j15) {
        super(j11, j12, j13, j14, j15);
    }

    /* renamed from: forEachRemaining */
    public final void d(Object obj) {
        Objects.requireNonNull(obj);
        long j11 = this.f28929e;
        long j12 = this.f28925a;
        if (j12 < j11) {
            long j13 = this.f28928d;
            if (j13 < j11) {
                if (j13 < j12 || ((J) this.f28927c).estimateSize() + j13 > this.f28926b) {
                    while (j12 > this.f28928d) {
                        ((J) this.f28927c).tryAdvance(g());
                        this.f28928d++;
                    }
                    while (this.f28928d < this.f28929e) {
                        ((J) this.f28927c).tryAdvance(obj);
                        this.f28928d++;
                    }
                    return;
                }
                ((J) this.f28927c).forEachRemaining(obj);
                this.f28928d = this.f28929e;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object g();

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    /* renamed from: tryAdvance */
    public final boolean o(Object obj) {
        long j11;
        Objects.requireNonNull(obj);
        long j12 = this.f28929e;
        long j13 = this.f28925a;
        if (j13 >= j12) {
            return false;
        }
        while (true) {
            j11 = this.f28928d;
            if (j13 <= j11) {
                break;
            }
            ((J) this.f28927c).tryAdvance(g());
            this.f28928d++;
        }
        if (j11 >= this.f28929e) {
            return false;
        }
        this.f28928d = j11 + 1;
        return ((J) this.f28927c).tryAdvance(obj);
    }
}
