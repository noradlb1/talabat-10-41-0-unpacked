package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Supplier;

/* renamed from: j$.util.stream.w0  reason: case insensitive filesystem */
final class C0304w0 implements U3 {

    /* renamed from: a  reason: collision with root package name */
    final C0299v0 f29256a;

    /* renamed from: b  reason: collision with root package name */
    final Supplier f29257b;

    C0304w0(C0218e3 e3Var, C0299v0 v0Var, C0269p pVar) {
        this.f29256a = v0Var;
        this.f29257b = pVar;
    }

    public final int G() {
        return C0213d3.f29124u | C0213d3.f29121r;
    }

    public final Object b0(C0314y0 y0Var, Spliterator spliterator) {
        return Boolean.valueOf(((C0294u0) y0Var.g1(spliterator, (C0294u0) this.f29257b.get())).f29241b);
    }

    public final Object v(C0314y0 y0Var, Spliterator spliterator) {
        return (Boolean) new C0309x0(this, y0Var, spliterator).invoke();
    }
}
