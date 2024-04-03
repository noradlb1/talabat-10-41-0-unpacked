package j$.util.stream;

import j$.util.G;
import j$.util.J;
import j$.util.Spliterator;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

/* renamed from: j$.util.stream.o1  reason: case insensitive filesystem */
final class C0266o1 extends W2 implements F0, B0 {
    C0266o1() {
    }

    public final G0 a(int i11) {
        throw new IndexOutOfBoundsException();
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final /* synthetic */ void accept(int i11) {
        C0314y0.k0();
        throw null;
    }

    public final void accept(long j11) {
        super.accept(j11);
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final Object b() {
        return (long[]) super.b();
    }

    public final F0 build() {
        return this;
    }

    /* renamed from: build  reason: collision with other method in class */
    public final H0 m8094build() {
        return this;
    }

    public final void c(int i11, Object obj) {
        super.c(i11, (long[]) obj);
    }

    public final void d(Object obj) {
        super.d((C0152f0) obj);
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

    public final /* synthetic */ void l(Long l11) {
        C0314y0.i0(this, l11);
    }

    public final /* synthetic */ Object[] o(IntFunction intFunction) {
        return C0314y0.m0(this, intFunction);
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.v0(this, j11, j12);
    }

    public final J spliterator() {
        return super.spliterator();
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8095spliterator() {
        return super.spliterator();
    }

    public final G x() {
        return super.spliterator();
    }

    /* renamed from: y */
    public final /* synthetic */ void e(Long[] lArr, int i11) {
        C0314y0.p0(this, lArr, i11);
    }
}
