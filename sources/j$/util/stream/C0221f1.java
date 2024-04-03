package j$.util.stream;

import j$.util.D;
import j$.util.J;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.K;

/* renamed from: j$.util.stream.f1  reason: case insensitive filesystem */
final class C0221f1 extends U2 implements E0, A0 {
    C0221f1() {
    }

    public final G0 a(int i11) {
        throw new IndexOutOfBoundsException();
    }

    public final /* synthetic */ void accept(double d11) {
        C0314y0.d0();
        throw null;
    }

    public final void accept(int i11) {
        super.accept(i11);
    }

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        g((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final Object b() {
        return (int[]) super.b();
    }

    public final E0 build() {
        return this;
    }

    /* renamed from: build  reason: collision with other method in class */
    public final H0 m8091build() {
        return this;
    }

    public final void c(int i11, Object obj) {
        super.c(i11, (int[]) obj);
    }

    public final void d(Object obj) {
        super.d((K) obj);
    }

    public final void end() {
    }

    public final void f(long j11) {
        clear();
        u(j11);
    }

    public final /* synthetic */ void g(Integer num) {
        C0314y0.g0(this, num);
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

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.u0(this, j11, j12);
    }

    public final J spliterator() {
        return super.spliterator();
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8092spliterator() {
        return super.spliterator();
    }

    public final D x() {
        return super.spliterator();
    }

    /* renamed from: y */
    public final /* synthetic */ void e(Integer[] numArr, int i11) {
        C0314y0.o0(this, numArr, i11);
    }
}
