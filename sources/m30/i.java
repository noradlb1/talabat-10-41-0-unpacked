package m30;

import j$.util.function.Predicate;
import org.junit.platform.engine.Filter;

public final /* synthetic */ class i implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Filter f26879a;

    public /* synthetic */ i(Filter filter) {
        this.f26879a = filter;
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
        return this.f26879a.apply(obj).included();
    }
}
