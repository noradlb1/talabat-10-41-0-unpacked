package org.junit.jupiter.engine.descriptor;

import j$.lang.Iterable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.ReflectionUtils;

final class LifecycleMethodUtils {
    private LifecycleMethodUtils() {
    }

    /* access modifiers changed from: private */
    public static void assertNonPrivate(Class<? extends Annotation> cls, Method method) {
        if (ReflectionUtils.isPrivate((Member) method)) {
            throw new JUnitException(String.format("@%s method '%s' must not be private.", new Object[]{cls.getSimpleName(), method.toGenericString()}));
        }
    }

    private static void assertNonStatic(Class<? extends Annotation> cls, Method method) {
        if (ReflectionUtils.isStatic((Member) method)) {
            throw new JUnitException(String.format("@%s method '%s' must not be static.", new Object[]{cls.getSimpleName(), method.toGenericString()}));
        }
    }

    /* access modifiers changed from: private */
    public static void assertStatic(Class<? extends Annotation> cls, Method method) {
        if (ReflectionUtils.isNotStatic((Member) method)) {
            throw new JUnitException(String.format("@%s method '%s' must be static unless the test class is annotated with @TestInstance(Lifecycle.PER_CLASS).", new Object[]{cls.getSimpleName(), method.toGenericString()}));
        }
    }

    /* access modifiers changed from: private */
    public static void assertVoid(Class<? extends Annotation> cls, Method method) {
        if (!ReflectionUtils.returnsVoid(method)) {
            throw new JUnitException(String.format("@%s method '%s' must not return a value.", new Object[]{cls.getSimpleName(), method.toGenericString()}));
        }
    }

    public static List<Method> e(Class<?> cls, boolean z11) {
        return findMethodsAndAssertStaticAndNonPrivate(cls, z11, AfterAll.class, ReflectionUtils.HierarchyTraversalMode.BOTTOM_UP);
    }

    public static List<Method> f(Class<?> cls) {
        return findMethodsAndAssertNonStaticAndNonPrivate(cls, AfterEach.class, ReflectionUtils.HierarchyTraversalMode.BOTTOM_UP);
    }

    private static List<Method> findMethodsAndAssertNonStaticAndNonPrivate(Class<?> cls, Class<? extends Annotation> cls2, ReflectionUtils.HierarchyTraversalMode hierarchyTraversalMode) {
        List<Method> findMethodsAndCheckVoidReturnType = findMethodsAndCheckVoidReturnType(cls, cls2, hierarchyTraversalMode);
        Iterable.EL.forEach(findMethodsAndCheckVoidReturnType, new z(cls2));
        return findMethodsAndCheckVoidReturnType;
    }

    private static List<Method> findMethodsAndAssertStaticAndNonPrivate(Class<?> cls, boolean z11, Class<? extends Annotation> cls2, ReflectionUtils.HierarchyTraversalMode hierarchyTraversalMode) {
        List<Method> findMethodsAndCheckVoidReturnType = findMethodsAndCheckVoidReturnType(cls, cls2, hierarchyTraversalMode);
        if (z11) {
            Iterable.EL.forEach(findMethodsAndCheckVoidReturnType, new x(cls2));
        }
        Iterable.EL.forEach(findMethodsAndCheckVoidReturnType, new y(cls2));
        return findMethodsAndCheckVoidReturnType;
    }

    private static List<Method> findMethodsAndCheckVoidReturnType(Class<?> cls, Class<? extends Annotation> cls2, ReflectionUtils.HierarchyTraversalMode hierarchyTraversalMode) {
        List<Method> findAnnotatedMethods = AnnotationUtils.findAnnotatedMethods(cls, cls2, hierarchyTraversalMode);
        Iterable.EL.forEach(findAnnotatedMethods, new w(cls2));
        return findAnnotatedMethods;
    }

    public static List<Method> g(Class<?> cls, boolean z11) {
        return findMethodsAndAssertStaticAndNonPrivate(cls, z11, BeforeAll.class, ReflectionUtils.HierarchyTraversalMode.TOP_DOWN);
    }

    public static List<Method> h(Class<?> cls) {
        return findMethodsAndAssertNonStaticAndNonPrivate(cls, BeforeEach.class, ReflectionUtils.HierarchyTraversalMode.TOP_DOWN);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$findMethodsAndAssertNonStaticAndNonPrivate$2(Class cls, Method method) {
        assertNonStatic(cls, method);
        assertNonPrivate(cls, method);
    }
}
