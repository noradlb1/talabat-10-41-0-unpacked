package org.junit.jupiter.engine.discovery.predicates;

import j$.util.function.Predicate;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import org.apiguardian.api.API;
import org.junit.jupiter.api.Nested;
import org.junit.platform.commons.util.AnnotationUtils;

@API(since = "5.0", status = API.Status.INTERNAL)
public class IsNestedTestClass implements Predicate<Class<?>> {
    private static final IsInnerClass isInnerClass = new IsInnerClass();

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
        if (!isInnerClass.test(cls)) {
            return false;
        }
        return AnnotationUtils.isAnnotated((AnnotatedElement) cls, (Class<? extends Annotation>) Nested.class);
    }
}
