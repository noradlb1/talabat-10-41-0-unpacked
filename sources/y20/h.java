package y20;

import j$.util.function.Predicate;

public final /* synthetic */ class h implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f57995a;

    public /* synthetic */ h(String str) {
        this.f57995a = str;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return this.f57995a.equalsIgnoreCase((String) obj);
    }
}
