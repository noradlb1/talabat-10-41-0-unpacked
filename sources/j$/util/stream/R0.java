package j$.util.stream;

import j$.util.J;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

final class R0 extends S0 implements F0 {
    R0(F0 f02, F0 f03) {
        super(f02, f03);
    }

    /* renamed from: f */
    public final /* synthetic */ void e(Long[] lArr, int i11) {
        C0314y0.p0(this, lArr, i11);
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0314y0.s0(this, consumer);
    }

    public final Object newArray(int i11) {
        return new long[i11];
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.v0(this, j11, j12);
    }

    public final J spliterator() {
        return new C0236i1(this);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8083spliterator() {
        return new C0236i1(this);
    }
}
