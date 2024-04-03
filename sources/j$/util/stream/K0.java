package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import java.util.Arrays;

class K0 implements H0 {

    /* renamed from: a  reason: collision with root package name */
    final Object[] f28958a;

    /* renamed from: b  reason: collision with root package name */
    int f28959b;

    K0(long j11, IntFunction intFunction) {
        if (j11 < 2147483639) {
            this.f28958a = (Object[]) intFunction.apply((int) j11);
            this.f28959b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    K0(Object[] objArr) {
        this.f28958a = objArr;
        this.f28959b = objArr.length;
    }

    public final H0 a(int i11) {
        throw new IndexOutOfBoundsException();
    }

    public final long count() {
        return (long) this.f28959b;
    }

    public final void e(Object[] objArr, int i11) {
        System.arraycopy(this.f28958a, 0, objArr, i11, this.f28959b);
    }

    public final void forEach(Consumer consumer) {
        for (int i11 = 0; i11 < this.f28959b; i11++) {
            consumer.accept(this.f28958a[i11]);
        }
    }

    public final /* synthetic */ int j() {
        return 0;
    }

    public final Object[] o(IntFunction intFunction) {
        Object[] objArr = this.f28958a;
        if (objArr.length == this.f28959b) {
            return objArr;
        }
        throw new IllegalStateException();
    }

    public final /* synthetic */ H0 q(long j11, long j12, IntFunction intFunction) {
        return C0314y0.w0(this, j11, j12, intFunction);
    }

    public final Spliterator spliterator() {
        return Spliterators.m(this.f28958a, 0, this.f28959b);
    }

    public String toString() {
        Object[] objArr = this.f28958a;
        return String.format("ArrayNode[%d][%s]", new Object[]{Integer.valueOf(objArr.length - this.f28959b), Arrays.toString(objArr)});
    }
}
