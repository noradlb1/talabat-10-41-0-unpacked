package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.G;
import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

final class M1 implements S1, C0262n2 {

    /* renamed from: a  reason: collision with root package name */
    private int f28976a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f28977b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ G f28978c;

    M1(int i11, G g11) {
        this.f28977b = i11;
        this.f28978c = g11;
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final void accept(int i11) {
        this.f28976a = this.f28978c.applyAsInt(this.f28976a, i11);
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
        this.f28976a = this.f28977b;
    }

    public final /* synthetic */ void g(Integer num) {
        C0314y0.g0(this, num);
    }

    public final Object get() {
        return Integer.valueOf(this.f28976a);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final void k(S1 s12) {
        accept(((M1) s12).f28976a);
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
