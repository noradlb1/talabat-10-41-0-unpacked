package j$.util.stream;

import j$.util.A;
import j$.util.J;
import j$.util.Spliterator;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

final class W0 extends S2 implements D0, C0318z0 {
    W0() {
    }

    public final G0 a(int i11) {
        throw new IndexOutOfBoundsException();
    }

    public final void accept(double d11) {
        super.accept(d11);
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        p((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final Object b() {
        return (double[]) super.b();
    }

    public final D0 build() {
        return this;
    }

    /* renamed from: build  reason: collision with other method in class */
    public final H0 m8085build() {
        return this;
    }

    public final void c(int i11, Object obj) {
        super.c(i11, (double[]) obj);
    }

    public final void d(Object obj) {
        super.d((C0165m) obj);
    }

    public final void end() {
    }

    public final void f(long j11) {
        clear();
        u(j11);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final /* synthetic */ int j() {
        return 0;
    }

    public final /* synthetic */ Object[] o(IntFunction intFunction) {
        return C0314y0.m0(this, intFunction);
    }

    public final /* synthetic */ void p(Double d11) {
        C0314y0.e0(this, d11);
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.t0(this, j11, j12);
    }

    public final J spliterator() {
        return super.spliterator();
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8086spliterator() {
        return super.spliterator();
    }

    public final A x() {
        return super.spliterator();
    }

    /* renamed from: y */
    public final /* synthetic */ void e(Double[] dArr, int i11) {
        C0314y0.n0(this, dArr, i11);
    }
}
