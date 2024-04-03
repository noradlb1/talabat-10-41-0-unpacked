package j$.util.stream;

import j$.util.J;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

final class Z0 extends C0201b1 implements F0 {
    Z0() {
    }

    public final G0 a(int i11) {
        throw new IndexOutOfBoundsException();
    }

    public final Object b() {
        return C0314y0.f29279f;
    }

    /* renamed from: f */
    public final /* synthetic */ void e(Long[] lArr, int i11) {
        C0314y0.p0(this, lArr, i11);
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0314y0.s0(this, consumer);
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.v0(this, j11, j12);
    }

    public final J spliterator() {
        return Spliterators.d();
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8089spliterator() {
        return Spliterators.d();
    }
}
