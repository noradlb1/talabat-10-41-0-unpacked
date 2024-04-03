package org.junit.platform.commons.support;

import j$.util.Optional;
import j$.util.function.Predicate;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;

@API(since = "1.0", status = API.Status.MAINTAINED)
public final class ReflectionSupport {
    private ReflectionSupport() {
    }

    public static List<Class<?>> findAllClassesInClasspathRoot(URI uri, Predicate<Class<?>> predicate, Predicate<String> predicate2) {
        return ReflectionUtils.findAllClassesInClasspathRoot(uri, predicate, predicate2);
    }

    public static List<Class<?>> findAllClassesInModule(String str, Predicate<Class<?>> predicate, Predicate<String> predicate2) {
        return ReflectionUtils.findAllClassesInModule(str, predicate, predicate2);
    }

    public static List<Class<?>> findAllClassesInPackage(String str, Predicate<Class<?>> predicate, Predicate<String> predicate2) {
        return ReflectionUtils.findAllClassesInPackage(str, predicate, predicate2);
    }

    @API(since = "1.4", status = API.Status.MAINTAINED)
    public static List<Field> findFields(Class<?> cls, Predicate<Field> predicate, HierarchyTraversalMode hierarchyTraversalMode) {
        Preconditions.notNull(hierarchyTraversalMode, "HierarchyTraversalMode must not be null");
        return ReflectionUtils.findFields(cls, predicate, ReflectionUtils.HierarchyTraversalMode.valueOf(hierarchyTraversalMode.name()));
    }

    public static Optional<Method> findMethod(Class<?> cls, String str, String str2) {
        return ReflectionUtils.findMethod(cls, str, str2);
    }

    public static List<Method> findMethods(Class<?> cls, Predicate<Method> predicate, HierarchyTraversalMode hierarchyTraversalMode) {
        Preconditions.notNull(hierarchyTraversalMode, "HierarchyTraversalMode must not be null");
        return ReflectionUtils.findMethods(cls, predicate, ReflectionUtils.HierarchyTraversalMode.valueOf(hierarchyTraversalMode.name()));
    }

    public static List<Class<?>> findNestedClasses(Class<?> cls, Predicate<Class<?>> predicate) throws JUnitException {
        return ReflectionUtils.findNestedClasses(cls, predicate);
    }

    public static Object invokeMethod(Method method, Object obj, Object... objArr) {
        return ReflectionUtils.invokeMethod(method, obj, objArr);
    }

    @Deprecated
    @API(since = "1.4", status = API.Status.DEPRECATED)
    public static Optional<Class<?>> loadClass(String str) {
        return ReflectionUtils.loadClass(str);
    }

    public static <T> T newInstance(Class<T> cls, Object... objArr) {
        return ReflectionUtils.newInstance(cls, objArr);
    }

    @API(since = "1.4", status = API.Status.MAINTAINED)
    public static Try<Class<?>> tryToLoadClass(String str) {
        return ReflectionUtils.tryToLoadClass(str);
    }

    @API(since = "1.4", status = API.Status.MAINTAINED)
    public static Try<Object> tryToReadFieldValue(Field field, Object obj) {
        return ReflectionUtils.tryToReadFieldValue(field, obj);
    }

    public static Optional<Method> findMethod(Class<?> cls, String str, Class<?>... clsArr) {
        return ReflectionUtils.findMethod(cls, str, clsArr);
    }
}
