package j$.util.stream;

import j$.util.function.H;
import j$.util.function.K;
import java.util.Objects;

final class V1 extends Y1 implements C0262n2 {
    V1() {
    }

    public final void accept(int i11) {
        this.f29069b++;
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
