package l30;

import j$.util.function.Predicate;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.platform.commons.util.ReflectionUtils;

public final /* synthetic */ class u1 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f26503a;

    public /* synthetic */ u1(List list) {
        this.f26503a = list;
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
        return ReflectionUtils.lambda$getInterfaceMethods$31(this.f26503a, (Method) obj);
    }
}
