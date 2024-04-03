package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.C0165m;

final class C extends F {
    C(Spliterator spliterator, int i11) {
        super(spliterator, i11);
    }

    public final void D(C0165m mVar) {
        if (!isParallel()) {
            F.B1(x1()).d(mVar);
        } else {
            super.D(mVar);
        }
    }

    public final void a0(C0165m mVar) {
        if (!isParallel()) {
            F.B1(x1()).d(mVar);
        } else {
            super.a0(mVar);
        }
    }

    public final /* bridge */ /* synthetic */ DoubleStream parallel() {
        parallel();
        return this;
    }

    public final /* bridge */ /* synthetic */ DoubleStream sequential() {
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
