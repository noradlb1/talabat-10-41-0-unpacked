package j$.util.stream;

import j$.util.A;
import j$.util.C0189n;
import j$.util.Spliterator;
import j$.util.function.Consumer;

final class z3 extends E3 implements A {
    z3(A a11, long j11, long j12) {
        super(a11, j11, j12);
    }

    z3(A a11, long j11, long j12, long j13, long j14) {
        super(a11, j11, j12, j13, j14);
    }

    public final /* synthetic */ boolean a(Consumer consumer) {
        return C0189n.m(this, consumer);
    }

    /* access modifiers changed from: protected */
    public final Spliterator f(Spliterator spliterator, long j11, long j12, long j13, long j14) {
        return new z3((A) spliterator, j11, j12, j13, j14);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        C0189n.f(this, consumer);
    }

    /* access modifiers changed from: protected */
    public final Object g() {
        return new y3(0);
    }
}
