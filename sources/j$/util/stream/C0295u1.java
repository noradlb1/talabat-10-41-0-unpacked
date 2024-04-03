package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;

/* renamed from: j$.util.stream.u1  reason: case insensitive filesystem */
final class C0295u1 extends Z2 implements H0, C0 {
    C0295u1() {
    }

    public final H0 a(int i11) {
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

    public final /* synthetic */ void accept(long j11) {
        C0314y0.l0();
        throw null;
    }

    public final void accept(Object obj) {
        super.accept(obj);
    }

    public final H0 build() {
        return this;
    }

    public final void e(Object[] objArr, int i11) {
        long j11 = (long) i11;
        long count = count() + j11;
        if (count > ((long) objArr.length) || count < j11) {
            throw new IndexOutOfBoundsException("does not fit");
        } else if (this.f29133c == 0) {
            System.arraycopy(this.f29075e, 0, objArr, i11, this.f29132b);
        } else {
            for (int i12 = 0; i12 < this.f29133c; i12++) {
                Object[] objArr2 = this.f29076f[i12];
                System.arraycopy(objArr2, 0, objArr, i11, objArr2.length);
                i11 += this.f29076f[i12].length;
            }
            int i13 = this.f29132b;
            if (i13 > 0) {
                System.arraycopy(this.f29075e, 0, objArr, i11, i13);
            }
        }
    }

    public final void end() {
    }

    public final void f(long j11) {
        clear();
        r(j11);
    }

    public final void forEach(Consumer consumer) {
        super.forEach(consumer);
    }

    public final /* synthetic */ boolean h() {
        return false;
    }

    public final /* synthetic */ int j() {
        return 0;
    }

    public final Object[] o(IntFunction intFunction) {
        long count = count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) count);
            e(objArr, 0);
            return objArr;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.w0(this, j11, j12, intFunction);
    }

    public final Spliterator spliterator() {
        return super.spliterator();
    }
}
