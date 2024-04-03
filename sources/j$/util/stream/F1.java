package j$.util.stream;

import j$.util.function.BinaryOperator;
import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import j$.util.function.Supplier;
import j$.util.function.x0;
import java.util.Objects;

final class F1 extends T1 implements S1, C0257m2 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Supplier f28917b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ x0 f28918c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ BinaryOperator f28919d;

    F1(Supplier supplier, x0 x0Var, BinaryOperator binaryOperator) {
        this.f28917b = supplier;
        this.f28918c = x0Var;
        this.f28919d = binaryOperator;
    }

    public final void accept(double d11) {
        this.f28918c.accept(this.f29039a, d11);
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        p((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void end() {
    }

    public final void f(long j11) {
        this.f29039a = this.f28917b.get();
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final void k(S1 s12) {
        this.f29039a = this.f28919d.apply(this.f29039a, ((F1) s12).f29039a);
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    public final /* synthetic */ void p(Double d11) {
        C0314y0.e0(this, d11);
    }
}
