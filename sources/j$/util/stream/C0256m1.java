package j$.util.stream;

import j$.util.J;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import java.util.Arrays;

/* renamed from: j$.util.stream.m1  reason: case insensitive filesystem */
class C0256m1 implements F0 {

    /* renamed from: a  reason: collision with root package name */
    final long[] f29182a;

    /* renamed from: b  reason: collision with root package name */
    int f29183b;

    C0256m1(long j11) {
        if (j11 < 2147483639) {
            this.f29182a = new long[((int) j11)];
            this.f29183b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    C0256m1(long[] jArr) {
        this.f29182a = jArr;
        this.f29183b = jArr.length;
    }

    public final G0 a(int i11) {
        throw new IndexOutOfBoundsException();
    }

    public final Object b() {
        long[] jArr = this.f29182a;
        int length = jArr.length;
        int i11 = this.f29183b;
        return length == i11 ? jArr : Arrays.copyOf(jArr, i11);
    }

    public final void c(int i11, Object obj) {
        int i12 = this.f29183b;
        System.arraycopy(this.f29182a, 0, (long[]) obj, i11, i12);
    }

    public final long count() {
        return (long) this.f29183b;
    }

    public final void d(Object obj) {
        C0152f0 f0Var = (C0152f0) obj;
        for (int i11 = 0; i11 < this.f29183b; i11++) {
            f0Var.accept(this.f29182a[i11]);
        }
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        C0314y0.s0(this, consumer);
    }

    public final /* synthetic */ int j() {
        return 0;
    }

    /* renamed from: m */
    public final /* synthetic */ void e(Long[] lArr, int i11) {
        C0314y0.p0(this, lArr, i11);
    }

    public final /* synthetic */ Object[] o(IntFunction intFunction) {
        return C0314y0.m0(this, intFunction);
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.v0(this, j11, j12);
    }

    public final J spliterator() {
        return Spliterators.l(this.f29182a, 0, this.f29183b);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final Spliterator m8093spliterator() {
        return Spliterators.l(this.f29182a, 0, this.f29183b);
    }

    public String toString() {
        long[] jArr = this.f29182a;
        return String.format("LongArrayNode[%d][%s]", new Object[]{Integer.valueOf(jArr.length - this.f29183b), Arrays.toString(jArr)});
    }
}
