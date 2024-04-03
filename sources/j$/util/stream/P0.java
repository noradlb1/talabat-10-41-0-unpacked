package j$.util.stream;

import j$.util.J;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

final class P0 extends S0 implements D0 {
    P0(D0 d02, D0 d03) {
        super(d02, d03);
    }

    /* renamed from: f */
    public final /* synthetic */ void e(Double[] dArr, int i11) {
        C0314y0.n0(this, dArr, i11);
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0314y0.q0(this, consumer);
    }

    public final Object newArray(int i11) {
        return new double[i11];
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.t0(this, j11, j12);
    }

    public final J spliterator() {
        return new C0226g1(this);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8081spliterator() {
        return new C0226g1(this);
    }
}
