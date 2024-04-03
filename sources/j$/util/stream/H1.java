package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;

final class H1 extends T1 implements S1 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f28931b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BiFunction f28932c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ BinaryOperator f28933d;

    H1(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        this.f28931b = obj;
        this.f28932c = biFunction;
        this.f28933d = binaryOperator;
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final void accept(Object obj) {
        this.f29039a = this.f28932c.apply(this.f29039a, obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void end() {
    }

    public final void f(long j11) {
        this.f29039a = this.f28931b;
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final void k(S1 s12) {
        this.f29039a = this.f28933d.apply(this.f29039a, ((H1) s12).f29039a);
    }
}
