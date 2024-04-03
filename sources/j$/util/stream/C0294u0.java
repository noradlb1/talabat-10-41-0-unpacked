package j$.util.stream;

import j$.util.function.Consumer;

/* renamed from: j$.util.stream.u0  reason: case insensitive filesystem */
abstract class C0294u0 implements C0272p2 {

    /* renamed from: a  reason: collision with root package name */
    boolean f29240a;

    /* renamed from: b  reason: collision with root package name */
    boolean f29241b;

    C0294u0(C0299v0 v0Var) {
        this.f29241b = !v0Var.f29251b;
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

    public final /* synthetic */ void end() {
    }

    public final /* synthetic */ void f(long j11) {
    }

    public final boolean h() {
        return this.f29240a;
    }
}
