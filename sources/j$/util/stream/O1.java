package j$.util.stream;

import j$.util.C0186k;
import j$.util.function.Consumer;
import j$.util.function.G;
import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

final class O1 implements S1, C0262n2 {

    /* renamed from: a  reason: collision with root package name */
    private boolean f28999a;

    /* renamed from: b  reason: collision with root package name */
    private int f29000b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ G f29001c;

    O1(G g11) {
        this.f29001c = g11;
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final void accept(int i11) {
        if (this.f28999a) {
            this.f28999a = false;
        } else {
            i11 = this.f29001c.applyAsInt(this.f29000b, i11);
        }
        this.f29000b = i11;
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
        this.f28999a = true;
        this.f29000b = 0;
    }

    public final /* synthetic */ void g(Integer num) {
        C0314y0.g0(this, num);
    }

    public final Object get() {
        return this.f28999a ? C0186k.a() : C0186k.d(this.f29000b);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final void k(S1 s12) {
        O1 o12 = (O1) s12;
        if (!o12.f28999a) {
            accept(o12.f29000b);
        }
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
