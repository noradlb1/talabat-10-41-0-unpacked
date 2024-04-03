package j$.util.stream;

import j$.util.function.BinaryOperator;
import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import j$.util.function.D0;
import j$.util.function.Supplier;
import java.util.Objects;

/* renamed from: j$.util.stream.z1  reason: case insensitive filesystem */
final class C0319z1 extends T1 implements S1, C0267o2 {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Supplier f29287b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ D0 f29288c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ BinaryOperator f29289d;

    C0319z1(Supplier supplier, D0 d02, BinaryOperator binaryOperator) {
        this.f29287b = supplier;
        this.f29288c = d02;
        this.f29289d = binaryOperator;
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final void accept(long j11) {
        this.f29288c.accept(this.f29039a, j11);
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void end() {
    }

    public final void f(long j11) {
        this.f29039a = this.f29287b.get();
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }

    public final void k(S1 s12) {
        this.f29039a = this.f29289d.apply(this.f29039a, ((C0319z1) s12).f29039a);
    }

    public final /* synthetic */ void l(Long l11) {
        C0314y0.i0(this, l11);
    }
}
