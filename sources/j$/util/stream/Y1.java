package j$.util.stream;

import j$.util.function.Consumer;

abstract class Y1 extends T1 implements S1 {

    /* renamed from: b  reason: collision with root package name */
    long f29069b;

    Y1() {
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

    public final void f(long j11) {
        this.f29069b = 0;
    }

    public final Object get() {
        return Long.valueOf(this.f29069b);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final void k(S1 s12) {
        this.f29069b += ((Y1) s12).f29069b;
    }
}
