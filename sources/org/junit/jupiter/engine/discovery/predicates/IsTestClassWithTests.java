package org.junit.jupiter.engine.discovery.predicates;

import j$.util.function.Predicate;
import java.lang.reflect.Method;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ReflectionUtils;

@API(since = "5.1", status = API.Status.INTERNAL)
public class IsTestClassWithTests implements Predicate<Class<?>> {
    private static final IsNestedTestClass isNestedTestClass = new IsNestedTestClass();
    private static final IsPotentialTestContainer isPotentialTestContainer = new IsPotentialTestContainer();
    private static final IsTestFactoryMethod isTestFactoryMethod;
    private static final IsTestMethod isTestMethod;
    public static final Predicate<Method> isTestOrTestFactoryOrTestTemplateMethod;
    private static final IsTestTemplateMethod isTestTemplateMethod;

    static {
        IsTestMethod isTestMethod2 = new IsTestMethod();
        isTestMethod = isTestMethod2;
        IsTestFactoryMethod isTestFactoryMethod2 = new IsTestFactoryMethod();
        isTestFactoryMethod = isTestFactoryMethod2;
        IsTestTemplateMethod isTestTemplateMethod2 = new IsTestTemplateMethod();
        isTestTemplateMethod = isTestTemplateMethod2;
        isTestOrTestFactoryOrTestTemplateMethod = isTestMethod2.or(isTestFactoryMethod2).or(isTestTemplateMethod2);
    }

    private boolean hasNestedTests(Class<?> cls) {
        return !ReflectionUtils.findNestedClasses(cls, isNestedTestClass).isEmpty();
    }

    private boolean hasTestOrTestFactoryOrTestTemplateMethods(Class<?> cls) {
        return ReflectionUtils.isMethodPresent(cls, isTestOrTestFactoryOrTestTemplateMethod);
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

    public boolean test(Class<?> cls) {
        return isPotentialTestContainer.test(cls) && (hasTestOrTestFactoryOrTestTemplateMethods(cls) || hasNestedTests(cls));
    }
}
