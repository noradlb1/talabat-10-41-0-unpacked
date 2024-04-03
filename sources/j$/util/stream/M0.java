package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;

final class M0 extends O0 {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f28975k = 0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public M0(int i11, Spliterator spliterator, C0314y0 y0Var) {
        super(y0Var, spliterator, new C0199b(28), new C0249l(4));
        if (i11 == 1) {
            super(y0Var, spliterator, new C0199b(29), new C0249l(5));
        } else if (i11 != 2) {
        } else {
            super(y0Var, spliterator, new N0(0), new C0249l(6));
        }
    }

    public /* synthetic */ M0(Spliterator spliterator, IntFunction intFunction, C0314y0 y0Var) {
        super(y0Var, spliterator, new C0194a(4, intFunction), new C0249l(7));
    }
}
