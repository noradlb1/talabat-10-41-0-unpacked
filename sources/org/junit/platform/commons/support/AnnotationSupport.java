package org.junit.platform.commons.support;

import j$.util.Optional;
import j$.util.function.Predicate;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.List;
import k30.a;
import k30.b;
import k30.c;
import k30.d;
import k30.e;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;

@API(since = "1.0", status = API.Status.MAINTAINED)
public final class AnnotationSupport {
    private AnnotationSupport() {
    }

    @API(since = "1.4", status = API.Status.MAINTAINED)
    public static List<Object> findAnnotatedFieldValues(Object obj, Class<? extends Annotation> cls) {
        Preconditions.notNull(obj, "instance must not be null");
        return ReflectionUtils.readFieldValues(findAnnotatedFields(obj.getClass(), cls, new d(), HierarchyTraversalMode.TOP_DOWN), obj);
    }

    @API(since = "1.4", status = API.Status.MAINTAINED)
    public static List<Field> findAnnotatedFields(Class<?> cls, Class<? extends Annotation> cls2) {
        return AnnotationUtils.findAnnotatedFields(cls, cls2, new c());
    }

    public static List<Method> findAnnotatedMethods(Class<?> cls, Class<? extends Annotation> cls2, HierarchyTraversalMode hierarchyTraversalMode) {
        Preconditions.notNull(hierarchyTraversalMode, "HierarchyTraversalMode must not be null");
        return AnnotationUtils.findAnnotatedMethods(cls, cls2, ReflectionUtils.HierarchyTraversalMode.valueOf(hierarchyTraversalMode.name()));
    }

    @API(since = "1.1", status = API.Status.MAINTAINED)
    public static <A extends Annotation> Optional<A> findAnnotation(Optional<? extends AnnotatedElement> optional, Class<A> cls) {
        return AnnotationUtils.findAnnotation(optional, cls);
    }

    public static List<Field> findPublicAnnotatedFields(Class<?> cls, Class<?> cls2, Class<? extends Annotation> cls3) {
        return AnnotationUtils.findPublicAnnotatedFields(cls, cls2, cls3);
    }

    @API(since = "1.5", status = API.Status.MAINTAINED)
    public static <A extends Annotation> List<A> findRepeatableAnnotations(Optional<? extends AnnotatedElement> optional, Class<A> cls) {
        return AnnotationUtils.findRepeatableAnnotations(optional, cls);
    }

    @API(since = "1.3", status = API.Status.MAINTAINED)
    public static boolean isAnnotated(Optional<? extends AnnotatedElement> optional, Class<? extends Annotation> cls) {
        return AnnotationUtils.isAnnotated(optional, cls);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAnnotatedFieldValues$1(Class cls, Field field) {
        return ModifierSupport.isNotStatic((Member) field) && cls.isAssignableFrom(field.getType());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAnnotatedFieldValues$2(Class cls, Field field) {
        return ModifierSupport.isStatic((Member) field) && cls.isAssignableFrom(field.getType());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAnnotatedFields$0(Field field) {
        return true;
    }

    @API(since = "1.4", status = API.Status.MAINTAINED)
    public static List<Field> findAnnotatedFields(Class<?> cls, Class<? extends Annotation> cls2, Predicate<Field> predicate, HierarchyTraversalMode hierarchyTraversalMode) {
        Preconditions.notNull(hierarchyTraversalMode, "HierarchyTraversalMode must not be null");
        return AnnotationUtils.findAnnotatedFields(cls, cls2, predicate, ReflectionUtils.HierarchyTraversalMode.valueOf(hierarchyTraversalMode.name()));
    }

    public static <A extends Annotation> Optional<A> findAnnotation(AnnotatedElement annotatedElement, Class<A> cls) {
        return AnnotationUtils.findAnnotation(annotatedElement, cls);
    }

    public static <A extends Annotation> List<A> findRepeatableAnnotations(AnnotatedElement annotatedElement, Class<A> cls) {
        return AnnotationUtils.findRepeatableAnnotations(annotatedElement, cls);
    }

    public static boolean isAnnotated(AnnotatedElement annotatedElement, Class<? extends Annotation> cls) {
        return AnnotationUtils.isAnnotated(annotatedElement, cls);
    }

    @API(since = "1.8", status = API.Status.EXPERIMENTAL)
    public static <A extends Annotation> Optional<A> findAnnotation(Class<?> cls, Class<A> cls2, SearchOption searchOption) {
        Preconditions.notNull(searchOption, "SearchOption must not be null");
        return AnnotationUtils.findAnnotation(cls, cls2, searchOption == SearchOption.INCLUDE_ENCLOSING_CLASSES);
    }

    @API(since = "1.4", status = API.Status.MAINTAINED)
    public static List<Object> findAnnotatedFieldValues(Class<?> cls, Class<? extends Annotation> cls2) {
        return ReflectionUtils.readFieldValues(findAnnotatedFields(cls, cls2, new b(), HierarchyTraversalMode.TOP_DOWN), (Object) null);
    }

    @API(since = "1.4", status = API.Status.MAINTAINED)
    public static <T> List<T> findAnnotatedFieldValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        Preconditions.notNull(obj, "instance must not be null");
        Preconditions.notNull(cls2, "fieldType must not be null");
        return ReflectionUtils.readFieldValues(findAnnotatedFields(obj.getClass(), cls, new a(cls2), HierarchyTraversalMode.TOP_DOWN), obj);
    }

    @API(since = "1.4", status = API.Status.MAINTAINED)
    public static <T> List<T> findAnnotatedFieldValues(Class<?> cls, Class<? extends Annotation> cls2, Class<T> cls3) {
        Preconditions.notNull(cls3, "fieldType must not be null");
        return ReflectionUtils.readFieldValues(findAnnotatedFields(cls, cls2, new e(cls3), HierarchyTraversalMode.TOP_DOWN), (Object) null);
    }
}
