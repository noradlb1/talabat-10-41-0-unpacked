package x20;

import j$.util.function.Predicate;

public final /* synthetic */ class p implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f57973a;

    public /* synthetic */ p(Class cls) {
        this.f57973a = cls;
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
        return this.f57973a.equals((Class) obj);
    }
}
