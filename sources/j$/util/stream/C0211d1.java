package j$.util.stream;

import j$.util.J;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import j$.util.function.K;
import java.util.Arrays;

/* renamed from: j$.util.stream.d1  reason: case insensitive filesystem */
class C0211d1 implements E0 {

    /* renamed from: a  reason: collision with root package name */
    final int[] f29105a;

    /* renamed from: b  reason: collision with root package name */
    int f29106b;

    C0211d1(long j11) {
        if (j11 < 2147483639) {
            this.f29105a = new int[((int) j11)];
            this.f29106b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    C0211d1(int[] iArr) {
        this.f29105a = iArr;
        this.f29106b = iArr.length;
    }

    public final G0 a(int i11) {
        throw new IndexOutOfBoundsException();
    }

    public final Object b() {
        int[] iArr = this.f29105a;
        int length = iArr.length;
        int i11 = this.f29106b;
        return length == i11 ? iArr : Arrays.copyOf(iArr, i11);
    }

    public final void c(int i11, Object obj) {
        int i12 = this.f29106b;
        System.arraycopy(this.f29105a, 0, (int[]) obj, i11, i12);
    }

    public final long count() {
        return (long) this.f29106b;
    }

    public final void d(Object obj) {
        K k11 = (K) obj;
        for (int i11 = 0; i11 < this.f29106b; i11++) {
            k11.accept(this.f29105a[i11]);
        }
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0314y0.r0(this, consumer);
    }

    /* renamed from: i */
    public final /* synthetic */ void e(Integer[] numArr, int i11) {
        C0314y0.o0(this, numArr, i11);
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
        return Spliterators.k(this.f29105a, 0, this.f29106b);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8090spliterator() {
        return Spliterators.k(this.f29105a, 0, this.f29106b);
    }

    public String toString() {
        int[] iArr = this.f29105a;
        return String.format("IntArrayNode[%d][%s]", new Object[]{Integer.valueOf(iArr.length - this.f29106b), Arrays.toString(iArr)});
    }
}
