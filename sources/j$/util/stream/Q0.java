package j$.util.stream;

import j$.util.J;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

final class Q0 extends S0 implements E0 {
    Q0(E0 e02, E0 e03) {
        super(e02, e03);
    }

    /* renamed from: f */
    public final /* synthetic */ void e(Integer[] numArr, int i11) {
        C0314y0.o0(this, numArr, i11);
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0314y0.r0(this, consumer);
    }

    public final Object newArray(int i11) {
        return new int[i11];
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.u0(this, j11, j12);
    }

    public final J spliterator() {
        return new C0231h1(this);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8082spliterator() {
        return new C0231h1(this);
    }
}
