package j$.util.stream;

import j$.util.C0189n;
import j$.util.D;
import j$.util.Spliterator;
import j$.util.function.Consumer;

final class B3 extends E3 implements D {
    B3(D d11, long j11, long j12) {
        super(d11, j11, j12);
    }

    B3(D d11, long j11, long j12, long j13, long j14) {
        super(d11, j11, j12, j13, j14);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.n(this, consumer);
    }

    /* access modifiers changed from: protected */
    public final Spliterator f(Spliterator spliterator, long j11, long j12, long j13, long j14) {
        return new B3((D) spliterator, j11, j12, j13, j14);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.g(this, consumer);
    }

    /* access modifiers changed from: protected */
    public final Object g() {
        return new A3(0);
    }
}
