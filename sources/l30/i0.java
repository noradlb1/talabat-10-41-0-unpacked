package l30;

import j$.util.function.Function;
import j$.util.function.Predicate;

public final /* synthetic */ class i0 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f26480a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function f26481b;

    public /* synthetic */ i0(Predicate predicate, Function function) {
        this.f26480a = predicate;
        this.f26481b = function;
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
        return this.f26480a.test(this.f26481b.apply(obj));
    }
}
