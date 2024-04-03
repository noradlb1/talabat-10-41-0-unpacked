package l30;

import j$.util.function.Predicate;
import java.lang.reflect.Method;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class f1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f26474a;

    public /* synthetic */ f1(Method method) {
        this.f26474a = method;
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
        return ReflectionUtils.isMethodShadowedBy(this.f26474a, (Method) obj);
    }
}
