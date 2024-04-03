package j$.util.function;

import j$.util.function.BiPredicate;

/* renamed from: j$.util.function.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0143b implements BiPredicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28832a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BiPredicate f28833b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BiPredicate f28834c;

    public /* synthetic */ C0143b(BiPredicate biPredicate, BiPredicate biPredicate2, int i11) {
        this.f28832a = i11;
        this.f28833b = biPredicate;
        this.f28834c = biPredicate2;
    }

    public final /* synthetic */ BiPredicate and(BiPredicate biPredicate) {
        switch (this.f28832a) {
            case 0:
                return BiPredicate.CC.$default$and(this, biPredicate);
            default:
                return BiPredicate.CC.$default$and(this, biPredicate);
        }
    }

    public final /* synthetic */ BiPredicate negate() {
        switch (this.f28832a) {
            case 0:
                return BiPredicate.CC.$default$negate(this);
            default:
                return BiPredicate.CC.$default$negate(this);
        }
    }

    public final /* synthetic */ BiPredicate or(BiPredicate biPredicate) {
        switch (this.f28832a) {
            case 0:
                return BiPredicate.CC.$default$or(this, biPredicate);
            default:
                return BiPredicate.CC.$default$or(this, biPredicate);
        }
    }

    public final boolean test(Object obj, Object obj2) {
        int i11 = this.f28832a;
        BiPredicate biPredicate = this.f28834c;
        BiPredicate biPredicate2 = this.f28833b;
        switch (i11) {
            case 0:
                return biPredicate2.test(obj, obj2) && biPredicate.test(obj, obj2);
            default:
                return biPredicate2.test(obj, obj2) || biPredicate.test(obj, obj2);
        }
    }
}
