package j$.util.stream;

import j$.util.J;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

final class X0 extends C0201b1 implements D0 {
    X0() {
    }

    public final G0 a(int i11) {
        throw new IndexOutOfBoundsException();
    }

    public final Object b() {
        return C0314y0.f29280g;
    }

    /* renamed from: f */
    public final /* synthetic */ void e(Double[] dArr, int i11) {
        C0314y0.n0(this, dArr, i11);
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0314y0.q0(this, consumer);
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.t0(this, j11, j12);
    }

    public final J spliterator() {
        return Spliterators.b();
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8087spliterator() {
        return Spliterators.b();
    }
}
