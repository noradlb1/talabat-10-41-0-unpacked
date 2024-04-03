package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.Supplier;

final class K1 extends T1 implements S1 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Supplier f28960b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BiConsumer f28961c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ BinaryOperator f28962d;

    K1(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator) {
        this.f28960b = supplier;
        this.f28961c = biConsumer;
        this.f28962d = binaryOperator;
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
        this.f28961c.accept(this.f29039a, obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void end() {
    }

    public final void f(long j11) {
        this.f29039a = this.f28960b.get();
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final void k(S1 s12) {
        this.f29039a = this.f28962d.apply(this.f29039a, ((K1) s12).f29039a);
    }
}
