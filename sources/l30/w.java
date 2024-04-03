package l30;

import j$.util.Collection;
import j$.util.function.Predicate;
import java.util.List;

public final /* synthetic */ class w implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f26505a;

    public /* synthetic */ w(List list) {
        this.f26505a = list;
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
        return Collection.EL.stream(this.f26505a).noneMatch(new p(obj));
    }
}
