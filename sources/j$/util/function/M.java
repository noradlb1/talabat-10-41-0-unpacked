package j$.util.function;

import j$.util.function.IntPredicate;

public final /* synthetic */ class M implements IntPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28810a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IntPredicate f28811b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IntPredicate f28812c;

    public /* synthetic */ M(IntPredicate intPredicate, IntPredicate intPredicate2, int i11) {
        this.f28810a = i11;
        this.f28811b = intPredicate;
        this.f28812c = intPredicate2;
    }

    public final /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        switch (this.f28810a) {
            case 0:
                return IntPredicate.CC.$default$and(this, intPredicate);
            default:
                return IntPredicate.CC.$default$and(this, intPredicate);
        }
    }

    public final /* synthetic */ IntPredicate negate() {
        switch (this.f28810a) {
            case 0:
                return IntPredicate.CC.$default$negate(this);
            default:
                return IntPredicate.CC.$default$negate(this);
        }
    }

    public final /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        switch (this.f28810a) {
            case 0:
                return IntPredicate.CC.$default$or(this, intPredicate);
            default:
                return IntPredicate.CC.$default$or(this, intPredicate);
        }
    }

    public final boolean test(int i11) {
        int i12 = this.f28810a;
        IntPredicate intPredicate = this.f28812c;
        IntPredicate intPredicate2 = this.f28811b;
        switch (i12) {
            case 0:
                return intPredicate2.test(i11) || intPredicate.test(i11);
            default:
                return intPredicate2.test(i11) && intPredicate.test(i11);
        }
    }
}
