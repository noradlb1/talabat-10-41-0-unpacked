package l30;

import j$.util.function.Predicate;
import java.lang.reflect.Method;
import java.util.List;

public final /* synthetic */ class g2 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f26476a;

    public /* synthetic */ g2(List list) {
        this.f26476a = list;
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
        return this.f26476a.contains((Method) obj);
    }
}
