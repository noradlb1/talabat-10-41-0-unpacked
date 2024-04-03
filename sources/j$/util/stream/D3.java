package j$.util.stream;

import j$.util.C0189n;
import j$.util.G;
import j$.util.Spliterator;
import j$.util.function.Consumer;

final class D3 extends E3 implements G {
    D3(G g11, long j11, long j12) {
        super(g11, j11, j12);
    }

    D3(G g11, long j11, long j12, long j13, long j14) {
        super(g11, j11, j12, j13, j14);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.p(this, consumer);
    }

    /* access modifiers changed from: protected */
    public final Spliterator f(Spliterator spliterator, long j11, long j12, long j13, long j14) {
        return new D3((G) spliterator, j11, j12, j13, j14);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.h(this, consumer);
    }

    /* access modifiers changed from: protected */
    public final Object g() {
        return new C3(0);
    }
}
