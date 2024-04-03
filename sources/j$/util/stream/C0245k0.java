package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0152f0;

/* renamed from: j$.util.stream.k0  reason: case insensitive filesystem */
final class C0245k0 extends C0260n0 {
    C0245k0(Spliterator spliterator, int i11) {
        super(spliterator, i11);
    }

    public final void B(C0152f0 f0Var) {
        if (!isParallel()) {
            C0260n0.B1(x1()).b(f0Var);
        } else {
            super.B(f0Var);
        }
    }

    public final /* bridge */ /* synthetic */ LongStream parallel() {
        parallel();
        return this;
    }

    public final /* bridge */ /* synthetic */ LongStream sequential() {
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

    public final void w(C0152f0 f0Var) {
        if (!isParallel()) {
            C0260n0.B1(x1()).b(f0Var);
        } else {
            super.w(f0Var);
        }
    }
}
