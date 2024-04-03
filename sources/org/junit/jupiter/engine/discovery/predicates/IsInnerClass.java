package org.junit.jupiter.engine.discovery.predicates;

import j$.util.function.Predicate;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ReflectionUtils;

@API(since = "5.0", status = API.Status.INTERNAL)
public class IsInnerClass implements Predicate<Class<?>> {
    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public boolean test(Class<?> cls) {
        if (!ReflectionUtils.isPrivate(cls) && ReflectionUtils.isInnerClass(cls)) {
            return true;
        }
        return false;
    }
}
