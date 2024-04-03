package j$.util.stream;

import j$.util.G;
import j$.util.Spliterators;
import j$.util.function.C0146c0;
import j$.util.function.C0152f0;
import j$.util.function.Consumer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

class W2 extends Y2 implements C0152f0 {
    W2() {
    }

    W2(int i11) {
        super(i11);
    }

    public void accept(long j11) {
        w();
        int i11 = this.f29132b;
        this.f29132b = i11 + 1;
        ((long[]) this.f29070e)[i11] = j11;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof C0152f0) {
            d((C0152f0) consumer);
        } else if (!X3.f29067a) {
            spliterator().forEachRemaining(consumer);
        } else {
            X3.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
            throw null;
        }
    }

    public final C0152f0 i(C0152f0 f0Var) {
        Objects.requireNonNull(f0Var);
        return new C0146c0(this, f0Var);
    }

    public final Iterator iterator() {
        return Spliterators.h(spliterator());
    }

    public final Object newArray(int i11) {
        return new long[i11];
    }

    /* access modifiers changed from: protected */
    public final void r(Object obj, int i11, int i12, Object obj2) {
        long[] jArr = (long[]) obj;
        C0152f0 f0Var = (C0152f0) obj2;
        while (i11 < i12) {
            f0Var.accept(jArr[i11]);
            i11++;
        }
    }

    /* access modifiers changed from: protected */
    public final int s(Object obj) {
        return ((long[]) obj).length;
    }

    public final String toString() {
        long[] jArr = (long[]) b();
        if (jArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f29133c), Arrays.toString(jArr)});
        }
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f29133c), Arrays.toString(Arrays.copyOf(jArr, 200))});
    }

    /* access modifiers changed from: protected */
    public final Object[] v() {
        return new long[8][];
    }

    /* renamed from: x */
    public G spliterator() {
        return new V2(this, 0, this.f29133c, 0, this.f29132b);
    }
}
