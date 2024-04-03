package j$.util.stream;

import j$.util.J;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import java.util.Arrays;

class U0 implements D0 {

    /* renamed from: a  reason: collision with root package name */
    final double[] f29045a;

    /* renamed from: b  reason: collision with root package name */
    int f29046b;

    U0(long j11) {
        if (j11 < 2147483639) {
            this.f29045a = new double[((int) j11)];
            this.f29046b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    U0(double[] dArr) {
        this.f29045a = dArr;
        this.f29046b = dArr.length;
    }

    public final G0 a(int i11) {
        throw new IndexOutOfBoundsException();
    }

    public final Object b() {
        double[] dArr = this.f29045a;
        int length = dArr.length;
        int i11 = this.f29046b;
        return length == i11 ? dArr : Arrays.copyOf(dArr, i11);
    }

    public final void c(int i11, Object obj) {
        int i12 = this.f29046b;
        System.arraycopy(this.f29045a, 0, (double[]) obj, i11, i12);
    }

    public final long count() {
        return (long) this.f29046b;
    }

    public final void d(Object obj) {
        C0165m mVar = (C0165m) obj;
        for (int i11 = 0; i11 < this.f29046b; i11++) {
            mVar.accept(this.f29045a[i11]);
        }
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0314y0.q0(this, consumer);
    }

    /* renamed from: i */
    public final /* synthetic */ void e(Double[] dArr, int i11) {
        C0314y0.n0(this, dArr, i11);
    }

    public final /* synthetic */ int j() {
        return 0;
    }

    public final /* synthetic */ Object[] o(IntFunction intFunction) {
        return C0314y0.m0(this, intFunction);
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.t0(this, j11, j12);
    }

    public final J spliterator() {
        return Spliterators.j(this.f29045a, 0, this.f29046b);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8084spliterator() {
        return Spliterators.j(this.f29045a, 0, this.f29046b);
    }

    public String toString() {
        double[] dArr = this.f29045a;
        return String.format("DoubleArrayNode[%d][%s]", new Object[]{Integer.valueOf(dArr.length - this.f29046b), Arrays.toString(dArr)});
    }
}
