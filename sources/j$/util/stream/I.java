package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Predicate;
import j$.util.function.Supplier;

final class I implements U3 {

    /* renamed from: a  reason: collision with root package name */
    final int f28935a;

    /* renamed from: b  reason: collision with root package name */
    final Object f28936b;

    /* renamed from: c  reason: collision with root package name */
    final Predicate f28937c;

    /* renamed from: d  reason: collision with root package name */
    final Supplier f28938d;

    I(boolean z11, C0218e3 e3Var, Object obj, N0 n02, C0199b bVar) {
        this.f28935a = (z11 ? 0 : C0213d3.f29121r) | C0213d3.f29124u;
        this.f28936b = obj;
        this.f28937c = n02;
        this.f28938d = bVar;
    }

    public final int G() {
        return this.f28935a;
    }

    public final Object b0(C0314y0 y0Var, Spliterator spliterator) {
        V3 v32 = (V3) this.f28938d.get();
        y0Var.g1(spliterator, v32);
        Object obj = v32.get();
        return obj != null ? obj : this.f28936b;
    }

    public final Object v(C0314y0 y0Var, Spliterator spliterator) {
        return new O(this, C0213d3.ORDERED.k(y0Var.T0()), y0Var, spliterator).invoke();
    }
}
