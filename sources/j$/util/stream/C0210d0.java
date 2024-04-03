package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.K;

/* renamed from: j$.util.stream.d0  reason: case insensitive filesystem */
final class C0210d0 extends C0225g0 {
    C0210d0(Spliterator spliterator, int i11) {
        super(spliterator, i11);
    }

    public final void J(K k11) {
        if (!isParallel()) {
            C0225g0.B1(x1()).c(k11);
        } else {
            super.J(k11);
        }
    }

    public final void Q(K k11) {
        if (!isParallel()) {
            C0225g0.B1(x1()).c(k11);
        } else {
            super.Q(k11);
        }
    }

    public final /* bridge */ /* synthetic */ IntStream parallel() {
        parallel();
        return this;
    }

    public final /* bridge */ /* synthetic */ IntStream sequential() {
        sequential();
        return this;
    }

    /* access modifiers changed from: package-private */
    public final boolean u1() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final C0272p2 v1(int i11, C0272p2 p2Var) {
        throw new UnsupportedOperationException();
    }
}
