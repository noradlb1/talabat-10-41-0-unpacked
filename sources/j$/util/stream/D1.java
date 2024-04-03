package j$.util.stream;

import j$.util.C0185j;
import j$.util.function.C0157i;
import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Objects;

final class D1 implements S1, C0257m2 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f28910a;

    /* renamed from: b  reason: collision with root package name */
    private double f28911b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0157i f28912c;

    D1(C0157i iVar) {
        this.f28912c = iVar;
    }

    public final void accept(double d11) {
        if (this.f28910a) {
            this.f28910a = false;
        } else {
            d11 = this.f28912c.applyAsDouble(this.f28911b, d11);
        }
        this.f28911b = d11;
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
        this.f28910a = true;
        this.f28911b = 0.0d;
    }

    public final Object get() {
        return this.f28910a ? C0185j.a() : C0185j.d(this.f28911b);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final void k(S1 s12) {
        D1 d12 = (D1) s12;
        if (!d12.f28910a) {
            accept(d12.f28911b);
        }
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    public final /* synthetic */ void p(Double d11) {
        C0314y0.e0(this, d11);
    }
}
