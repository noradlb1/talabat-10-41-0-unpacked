package j$.util.function;

import j$.util.function.Predicate;

public final /* synthetic */ class F0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28796a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f28797b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Predicate f28798c;

    public /* synthetic */ F0(Predicate predicate, Predicate predicate2, int i11) {
        this.f28796a = i11;
        this.f28797b = predicate;
        this.f28798c = predicate2;
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f28796a) {
            case 0:
                return Predicate.CC.$default$and(this, predicate);
            default:
                return Predicate.CC.$default$and(this, predicate);
        }
    }

    public final /* synthetic */ Predicate negate() {
        switch (this.f28796a) {
            case 0:
                return Predicate.CC.$default$negate(this);
            default:
                return Predicate.CC.$default$negate(this);
        }
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.f28796a) {
            case 0:
                return Predicate.CC.$default$or(this, predicate);
            default:
                return Predicate.CC.$default$or(this, predicate);
        }
    }

    public final boolean test(Object obj) {
        int i11 = this.f28796a;
        Predicate predicate = this.f28798c;
        Predicate predicate2 = this.f28797b;
        switch (i11) {
            case 0:
                return predicate2.test(obj) && predicate.test(obj);
            default:
                return predicate2.test(obj) || predicate.test(obj);
        }
    }
}
