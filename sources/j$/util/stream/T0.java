package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntFunction;
import java.util.Objects;

final class T0 extends J0 {
    T0(H0 h02, H0 h03) {
        super(h02, h03);
    }

    public final void e(Object[] objArr, int i11) {
        Objects.requireNonNull(objArr);
        H0 h02 = this.f28948a;
        h02.e(objArr, i11);
        this.f28949b.e(objArr, i11 + ((int) h02.count()));
    }

    public final void forEach(Consumer consumer) {
        this.f28948a.forEach(consumer);
        this.f28949b.forEach(consumer);
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

    public final H0 q(long j11, long j12, IntFunction intFunction) {
        if (j11 == 0 && j12 == count()) {
            return this;
        }
        long count = this.f28948a.count();
        if (j11 >= count) {
            return this.f28949b.q(j11 - count, j12 - count, intFunction);
        }
        if (j12 <= count) {
            return this.f28948a.q(j11, j12, intFunction);
        }
        IntFunction intFunction2 = intFunction;
        return C0314y0.I0(C0218e3.REFERENCE, this.f28948a.q(j11, count, intFunction2), this.f28949b.q(0, j12 - count, intFunction2));
    }

    public final Spliterator spliterator() {
        return new C0246k1(this);
    }

    public final String toString() {
        if (count() < 32) {
            return String.format("ConcNode[%s.%s]", new Object[]{this.f28948a, this.f28949b});
        }
        return String.format("ConcNode[size=%d]", new Object[]{Long.valueOf(count())});
    }
}
