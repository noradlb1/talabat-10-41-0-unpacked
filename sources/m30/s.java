package m30;

import j$.util.function.Predicate;

public final /* synthetic */ class s implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f26883a;

    public /* synthetic */ s(String str) {
        this.f26883a = str;
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
        return this.f26883a.contains((String) obj);
    }
}
