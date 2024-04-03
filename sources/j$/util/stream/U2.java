package j$.util.stream;

import j$.util.D;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import j$.util.function.H;
import j$.util.function.K;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

class U2 extends Y2 implements K {
    U2() {
    }

    U2(int i11) {
        super(i11);
    }

    public void accept(int i11) {
        w();
        int i12 = this.f29132b;
        this.f29132b = i12 + 1;
        ((int[]) this.f29070e)[i12] = i11;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof K) {
            d((K) consumer);
        } else if (!X3.f29067a) {
            spliterator().forEachRemaining(consumer);
        } else {
            X3.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
            throw null;
        }
    }

    public final Iterator iterator() {
        return Spliterators.g(spliterator());
    }

    public final K n(K k11) {
        Objects.requireNonNull(k11);
        return new H(this, k11);
    }

    public final Object newArray(int i11) {
        return new int[i11];
    }

    /* access modifiers changed from: protected */
    public final void r(Object obj, int i11, int i12, Object obj2) {
        int[] iArr = (int[]) obj;
        K k11 = (K) obj2;
        while (i11 < i12) {
            k11.accept(iArr[i11]);
            i11++;
        }
    }

    /* access modifiers changed from: protected */
    public final int s(Object obj) {
        return ((int[]) obj).length;
    }

    public final String toString() {
        int[] iArr = (int[]) b();
        if (iArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f29133c), Arrays.toString(iArr)});
        }
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f29133c), Arrays.toString(Arrays.copyOf(iArr, 200))});
    }

    /* access modifiers changed from: protected */
    public final Object[] v() {
        return new int[8][];
    }

    /* renamed from: x */
    public D spliterator() {
        return new T2(this, 0, this.f29133c, 0, this.f29132b);
    }
}
