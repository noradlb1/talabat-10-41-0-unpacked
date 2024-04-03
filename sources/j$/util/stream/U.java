package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;

abstract class U implements U3, V3 {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f29044a;

    protected U(boolean z11) {
        this.f29044a = z11;
    }

    public final int G() {
        if (this.f29044a) {
            return 0;
        }
        return C0213d3.f29121r;
    }

    public /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final Object b0(C0314y0 y0Var, Spliterator spliterator) {
        ((U) y0Var.g1(spliterator, this)).getClass();
        return null;
    }

    public final /* synthetic */ void end() {
    }

    public final /* synthetic */ void f(long j11) {
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final Object v(C0314y0 y0Var, Spliterator spliterator) {
        (this.f29044a ? new V(y0Var, spliterator, (C0272p2) this) : new W(y0Var, spliterator, y0Var.h1(this))).invoke();
        return null;
    }
}
