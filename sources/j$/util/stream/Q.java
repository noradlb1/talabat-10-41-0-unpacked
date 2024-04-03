package j$.util.stream;

import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

final class Q extends U implements C0262n2 {

    /* renamed from: b  reason: collision with root package name */
    final K f29012b;

    Q(K k11, boolean z11) {
        super(z11);
        this.f29012b = k11;
    }

    public final void accept(int i11) {
        this.f29012b.accept(i11);
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        g((Integer) obj);
    }

    public final /* synthetic */ void g(Integer num) {
        C0314y0.g0(this, num);
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }
}
