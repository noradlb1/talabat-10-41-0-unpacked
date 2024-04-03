package l30;

import j$.util.function.Predicate;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class d1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f26469a;

    public /* synthetic */ d1(List list) {
        this.f26469a = list;
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
        return ReflectionUtils.lambda$findAllMethodsInHierarchy$29(this.f26469a, (Method) obj);
    }
}
