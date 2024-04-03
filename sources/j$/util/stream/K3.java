package j$.util.stream;

import j$.util.C0189n;
import j$.util.J;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.Objects;

abstract class K3 extends N3 implements J {
    K3(J j11, long j12, long j13) {
        super(j11, j12, j13);
    }

    K3(J j11, K3 k32) {
        super(j11, k32);
    }

    /* renamed from: forEachRemaining */
    public final void d(Object obj) {
        Objects.requireNonNull(obj);
        C0243j3 j3Var = null;
        while (true) {
            M3 s11 = s();
            if (s11 != M3.NO_MORE) {
                M3 m32 = M3.MAYBE_MORE;
                Spliterator spliterator = this.f28989a;
                if (s11 == m32) {
                    int i11 = this.f28991c;
                    if (j3Var == null) {
                        j3Var = u(i11);
                    } else {
                        j3Var.f29167b = 0;
                    }
                    long j11 = 0;
                    while (((J) spliterator).tryAdvance(j3Var)) {
                        j11++;
                        if (j11 >= ((long) i11)) {
                            break;
                        }
                    }
                    if (j11 != 0) {
                        j3Var.a(obj, q(j11));
                    } else {
                        return;
                    }
                } else {
                    ((J) spliterator).forEachRemaining(obj);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C0189n.i(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i11) {
        return C0189n.k(this, i11);
    }

    /* access modifiers changed from: protected */
    public abstract void t(Object obj);

    /* renamed from: tryAdvance */
    public final boolean o(Object obj) {
        Objects.requireNonNull(obj);
        while (s() != M3.NO_MORE && ((J) this.f28989a).tryAdvance(this)) {
            if (q(1) == 1) {
                t(obj);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract C0243j3 u(int i11);
}
