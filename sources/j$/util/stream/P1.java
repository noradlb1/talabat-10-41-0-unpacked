package j$.util.stream;

import j$.util.function.A0;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.H;
import j$.util.function.K;
import j$.util.function.Supplier;
import java.util.Objects;

final class P1 extends T1 implements S1, C0262n2 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Supplier f29007b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ A0 f29008c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ BinaryOperator f29009d;

    P1(Supplier supplier, A0 a02, BinaryOperator binaryOperator) {
        this.f29007b = supplier;
        this.f29008c = a02;
        this.f29009d = binaryOperator;
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final void accept(int i11) {
        this.f29008c.accept(this.f29039a, i11);
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        g((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void end() {
    }

    public final void f(long j11) {
        this.f29039a = this.f29007b.get();
    }

    public final /* synthetic */ void g(Integer num) {
        C0314y0.g0(this, num);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final void k(S1 s12) {
        this.f29039a = this.f29009d.apply(this.f29039a, ((P1) s12).f29039a);
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
