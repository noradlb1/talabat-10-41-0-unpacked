package j$.util.stream;

import j$.util.A;
import j$.util.Spliterators;
import j$.util.function.C0159j;
import j$.util.function.C0165m;
import j$.util.function.Consumer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

class S2 extends Y2 implements C0165m {
    S2() {
    }

    S2(int i11) {
        super(i11);
    }

    public void accept(double d11) {
        w();
        int i11 = this.f29132b;
        this.f29132b = i11 + 1;
        ((double[]) this.f29070e)[i11] = d11;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof C0165m) {
            d((C0165m) consumer);
        } else if (!X3.f29067a) {
            spliterator().forEachRemaining(consumer);
        } else {
            X3.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
            throw null;
        }
    }

    public final Iterator iterator() {
        return Spliterators.f(spliterator());
    }

    public final C0165m m(C0165m mVar) {
        Objects.requireNonNull(mVar);
        return new C0159j(this, mVar);
    }

    public final Object newArray(int i11) {
        return new double[i11];
    }

    /* access modifiers changed from: protected */
    public final void r(Object obj, int i11, int i12, Object obj2) {
        double[] dArr = (double[]) obj;
        C0165m mVar = (C0165m) obj2;
        while (i11 < i12) {
            mVar.accept(dArr[i11]);
            i11++;
        }
    }

    /* access modifiers changed from: protected */
    public final int s(Object obj) {
        return ((double[]) obj).length;
    }

    public final String toString() {
        double[] dArr = (double[]) b();
        if (dArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f29133c), Arrays.toString(dArr)});
        }
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f29133c), Arrays.toString(Arrays.copyOf(dArr, 200))});
    }

    /* access modifiers changed from: protected */
    public final Object[] v() {
        return new double[8][];
    }

    /* renamed from: x */
    public A spliterator() {
        return new R2(this, 0, this.f29133c, 0, this.f29132b);
    }
}
