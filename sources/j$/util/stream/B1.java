package j$.util.stream;

import j$.util.function.C0157i;
import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Objects;

final class B1 implements S1, C0257m2 {

    /* renamed from: a  reason: collision with root package name */
    private double f28897a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ double f28898b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0157i f28899c;

    B1(double d11, C0157i iVar) {
        this.f28898b = d11;
        this.f28899c = iVar;
    }

    public final void accept(double d11) {
        this.f28897a = this.f28899c.applyAsDouble(this.f28897a, d11);
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
        this.f28897a = this.f28898b;
    }

    public final Object get() {
        return Double.valueOf(this.f28897a);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final void k(S1 s12) {
        accept(((B1) s12).f28897a);
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    public final /* synthetic */ void p(Double d11) {
        C0314y0.e0(this, d11);
    }
}
