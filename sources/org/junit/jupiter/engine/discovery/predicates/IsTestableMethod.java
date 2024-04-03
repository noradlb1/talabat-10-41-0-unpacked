package org.junit.jupiter.engine.discovery.predicates;

import j$.util.function.Predicate;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.ReflectionUtils;

abstract class IsTestableMethod implements Predicate<Method> {
    private final Class<? extends Annotation> annotationType;
    private final boolean mustReturnVoid;

    public IsTestableMethod(Class<? extends Annotation> cls, boolean z11) {
        this.annotationType = cls;
        this.mustReturnVoid = z11;
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

    public boolean test(Method method) {
        if (!ReflectionUtils.isStatic((Member) method) && !ReflectionUtils.isPrivate((Member) method) && !ReflectionUtils.isAbstract((Member) method) && ReflectionUtils.returnsVoid(method) == this.mustReturnVoid) {
            return AnnotationUtils.isAnnotated((AnnotatedElement) method, this.annotationType);
        }
        return false;
    }
}
