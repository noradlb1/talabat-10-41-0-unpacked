package j$.util.stream;

import j$.util.J;
import j$.util.function.Supplier;

/* renamed from: j$.util.stream.p3  reason: case insensitive filesystem */
abstract class C0273p3 extends C0278q3 implements J {
    C0273p3(Supplier supplier) {
        super(supplier);
    }

    /* renamed from: forEachRemaining */
    public final void d(Object obj) {
        ((J) f()).forEachRemaining(obj);
    }

    /* renamed from: tryAdvance */
    public final boolean o(Object obj) {
        return ((J) f()).tryAdvance(obj);
    }
}
