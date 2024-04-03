package j$.util.stream;

import j$.util.function.IntFunction;

abstract class S0 extends J0 implements G0 {
    S0(G0 g02, G0 g03) {
        super(g02, g03);
    }

    public final Object b() {
        long count = count();
        if (count < 2147483639) {
            Object newArray = newArray((int) count);
            c(0, newArray);
            return newArray;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void c(int i11, Object obj) {
        H0 h02 = this.f28948a;
        ((G0) h02).c(i11, obj);
        ((G0) this.f28949b).c(i11 + ((int) ((G0) h02).count()), obj);
    }

    public final void d(Object obj) {
        ((G0) this.f28948a).d(obj);
        ((G0) this.f28949b).d(obj);
    }

    public final /* synthetic */ Object[] o(IntFunction intFunction) {
        return C0314y0.m0(this, intFunction);
    }

    public final String toString() {
        if (count() < 32) {
            return String.format("%s[%s.%s]", new Object[]{getClass().getName(), this.f28948a, this.f28949b});
        }
        return String.format("%s[size=%d]", new Object[]{getClass().getName(), Long.valueOf(count())});
    }
}
