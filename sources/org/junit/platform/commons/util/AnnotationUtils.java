package org.junit.platform.commons.util;

import j$.util.DesugarArrays;
import j$.util.Optional;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.ConcurrentMap;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import l30.f;
import l30.g;
import l30.h;
import l30.i;
import l30.j;
import l30.k;
import l30.l;
import l30.m;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.ReflectionUtils;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class AnnotationUtils {
    private static final ConcurrentHashMap<Class<? extends Annotation>, Boolean> repeatableAnnotationContainerCache = new ConcurrentHashMap<>(16);

    private AnnotationUtils() {
    }

    public static List<Field> findAnnotatedFields(Class<?> cls, Class<? extends Annotation> cls2, Predicate<Field> predicate) {
        return findAnnotatedFields(cls, cls2, predicate, ReflectionUtils.HierarchyTraversalMode.TOP_DOWN);
    }

    public static List<Method> findAnnotatedMethods(Class<?> cls, Class<? extends Annotation> cls2, ReflectionUtils.HierarchyTraversalMode hierarchyTraversalMode) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(cls2, "annotationType must not be null");
        return ReflectionUtils.findMethods(cls, new g(cls2), hierarchyTraversalMode);
    }

    public static <A extends Annotation> Optional<A> findAnnotation(Optional<? extends AnnotatedElement> optional, Class<A> cls) {
        if (optional == null || !optional.isPresent()) {
            return Optional.empty();
        }
        return findAnnotation((AnnotatedElement) optional.get(), cls);
    }

    private static <A extends Annotation> Optional<A> findMetaAnnotation(Class<A> cls, Annotation[] annotationArr, boolean z11, Set<Annotation> set) {
        for (Annotation annotation : annotationArr) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            if (!isInJavaLangAnnotationPackage(annotationType) && set.add(annotation)) {
                Optional<A> findAnnotation = findAnnotation(annotationType, cls, z11, set);
                if (findAnnotation.isPresent()) {
                    return findAnnotation;
                }
            }
        }
        return Optional.empty();
    }

    public static List<Field> findPublicAnnotatedFields(Class<?> cls, Class<?> cls2, Class<? extends Annotation> cls3) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(cls2, "fieldType must not be null");
        Preconditions.notNull(cls3, "annotationType must not be null");
        return (List) DesugarArrays.stream((T[]) cls.getFields()).filter(new l(cls2, cls3)).collect(CollectionUtils.toUnmodifiableList());
    }

    public static <A extends Annotation> List<A> findRepeatableAnnotations(Optional<? extends AnnotatedElement> optional, Class<A> cls) {
        if (optional == null || !optional.isPresent()) {
            return Collections.emptyList();
        }
        return findRepeatableAnnotations((AnnotatedElement) optional.get(), cls);
    }

    private static AnnotatedElement getEffectiveAnnotatedParameter(Parameter parameter, int i11) {
        Preconditions.notNull(parameter, "Parameter must not be null");
        Executable a11 = parameter.getDeclaringExecutable();
        if (!(a11 instanceof Constructor) || !ReflectionUtils.isInnerClass(a11.getDeclaringClass()) || a11.getParameterAnnotations().length != a11.getParameterCount() - 1) {
            return parameter;
        }
        if (i11 == 0) {
            return null;
        }
        return a11.getParameters()[i11 - 1];
    }

    public static boolean isAnnotated(Optional<? extends AnnotatedElement> optional, Class<? extends Annotation> cls) {
        return findAnnotation(optional, cls).isPresent();
    }

    private static boolean isInJavaLangAnnotationPackage(Class<? extends Annotation> cls) {
        return cls != null && cls.getName().startsWith("java.lang.annotation");
    }

    private static boolean isRepeatableAnnotationContainer(Class<? extends Annotation> cls) {
        return ((Boolean) ConcurrentMap.EL.computeIfAbsent(repeatableAnnotationContainerCache, cls, new f())).booleanValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findPublicAnnotatedFields$5(Class cls, Class cls2, Field field) {
        return cls.isAssignableFrom(field.getType()) && isAnnotated((AnnotatedElement) field, (Class<? extends Annotation>) cls2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$findRepeatableAnnotations$0(Class cls) {
        return cls.getName() + " must be @Repeatable";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JUnitException lambda$findRepeatableAnnotations$1(Class cls, Class cls2, Exception exc) {
        return new JUnitException(String.format("Container annotation type '%s' must declare a 'value' attribute of type %s[].", new Object[]{cls, cls2}), exc);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isRepeatableAnnotationContainer$2(Method method) {
        return method.getName().equals("value") && method.getReturnType().isArray();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Repeatable lambda$isRepeatableAnnotationContainer$3(Method method) {
        return (Repeatable) method.getReturnType().getComponentType().getAnnotation(Repeatable.class);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isRepeatableAnnotationContainer$4(Class cls) {
        boolean z11;
        Repeatable repeatable = (Repeatable) DesugarArrays.stream((T[]) cls.getMethods()).filter(new i()).findFirst().map(new j()).orElse(null);
        if (repeatable == null || !cls.equals(repeatable.value())) {
            z11 = false;
        } else {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }

    public static List<Field> findAnnotatedFields(Class<?> cls, Class<? extends Annotation> cls2, Predicate<Field> predicate, ReflectionUtils.HierarchyTraversalMode hierarchyTraversalMode) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(cls2, "annotationType must not be null");
        Preconditions.notNull(predicate, "Predicate must not be null");
        return ReflectionUtils.findFields(cls, new m(cls2).and(predicate), hierarchyTraversalMode);
    }

    public static boolean isAnnotated(Parameter parameter, int i11, Class<? extends Annotation> cls) {
        return findAnnotation(parameter, i11, cls).isPresent();
    }

    public static boolean isAnnotated(AnnotatedElement annotatedElement, Class<? extends Annotation> cls) {
        return findAnnotation(annotatedElement, cls).isPresent();
    }

    public static <A extends Annotation> Optional<A> findAnnotation(Parameter parameter, int i11, Class<A> cls) {
        return findAnnotation(getEffectiveAnnotatedParameter(parameter, i11), cls);
    }

    public static <A extends Annotation> List<A> findRepeatableAnnotations(Parameter parameter, int i11, Class<A> cls) {
        return findRepeatableAnnotations(getEffectiveAnnotatedParameter(parameter, i11), cls);
    }

    public static <A extends Annotation> Optional<A> findAnnotation(AnnotatedElement annotatedElement, Class<A> cls) {
        Preconditions.notNull(cls, "annotationType must not be null");
        return findAnnotation(annotatedElement, cls, cls.isAnnotationPresent(Inherited.class), new HashSet());
    }

    public static <A extends Annotation> List<A> findRepeatableAnnotations(AnnotatedElement annotatedElement, Class<A> cls) {
        Preconditions.notNull(cls, "annotationType must not be null");
        Repeatable repeatable = (Repeatable) cls.getAnnotation(Repeatable.class);
        Preconditions.notNull(repeatable, (Supplier<String>) new h(cls));
        Class a11 = repeatable.value();
        boolean isAnnotationPresent = a11.isAnnotationPresent(Inherited.class);
        if (annotatedElement == null) {
            return Collections.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(16);
        findRepeatableAnnotations(annotatedElement, cls, (Class<? extends Annotation>) a11, isAnnotationPresent, linkedHashSet, (Set<Annotation>) new HashSet(16));
        return Collections.unmodifiableList(new ArrayList(linkedHashSet));
    }

    private static <A extends Annotation> Optional<A> findAnnotation(AnnotatedElement annotatedElement, Class<A> cls, boolean z11, Set<Annotation> set) {
        Class<Object> superclass;
        Preconditions.notNull(cls, "annotationType must not be null");
        if (annotatedElement == null) {
            return Optional.empty();
        }
        Annotation a11 = annotatedElement.getDeclaredAnnotation(cls);
        if (a11 != null) {
            return Optional.of(a11);
        }
        Optional<A> findMetaAnnotation = findMetaAnnotation(cls, annotatedElement.getDeclaredAnnotations(), z11, set);
        if (findMetaAnnotation.isPresent()) {
            return findMetaAnnotation;
        }
        if (annotatedElement instanceof Class) {
            Class cls2 = (Class) annotatedElement;
            for (Class<Annotation> cls3 : cls2.getInterfaces()) {
                if (cls3 != Annotation.class) {
                    Optional<A> findAnnotation = findAnnotation(cls3, cls, z11, set);
                    if (findAnnotation.isPresent()) {
                        return findAnnotation;
                    }
                }
            }
            if (!(!z11 || (superclass = cls2.getSuperclass()) == null || superclass == Object.class)) {
                Optional<A> findAnnotation2 = findAnnotation(superclass, cls, z11, set);
                if (findAnnotation2.isPresent()) {
                    return findAnnotation2;
                }
            }
        }
        return findMetaAnnotation(cls, annotatedElement.getAnnotations(), z11, set);
    }

    private static <A extends Annotation> void findRepeatableAnnotations(AnnotatedElement annotatedElement, Class<A> cls, Class<? extends Annotation> cls2, boolean z11, Set<A> set, Set<Annotation> set2) {
        Class<Object> superclass;
        if (annotatedElement instanceof Class) {
            Class cls3 = (Class) annotatedElement;
            if (!(!z11 || (superclass = cls3.getSuperclass()) == null || superclass == Object.class)) {
                findRepeatableAnnotations((AnnotatedElement) superclass, cls, cls2, z11, set, set2);
            }
            for (Class<Annotation> cls4 : cls3.getInterfaces()) {
                if (cls4 != Annotation.class) {
                    findRepeatableAnnotations((AnnotatedElement) cls4, cls, cls2, z11, set, set2);
                }
            }
        }
        findRepeatableAnnotations(annotatedElement.getDeclaredAnnotations(), cls, cls2, z11, set, set2);
        findRepeatableAnnotations(annotatedElement.getAnnotations(), cls, cls2, z11, set, set2);
    }

    private static <A extends Annotation> void findRepeatableAnnotations(Annotation[] annotationArr, Class<A> cls, Class<? extends Annotation> cls2, boolean z11, Set<A> set, Set<Annotation> set2) {
        Class<A> cls3 = cls;
        Class<? extends Annotation> cls4 = cls2;
        Set<A> set3 = set;
        for (Annotation annotation : annotationArr) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            Set<Annotation> set4 = set2;
            if (!isInJavaLangAnnotationPackage(annotationType) && set4.add(annotation)) {
                if (annotationType.equals(cls3)) {
                    set3.add((Annotation) cls3.cast(annotation));
                } else if (annotationType.equals(cls4)) {
                    set3.addAll(Arrays.asList((Annotation[]) ReflectionUtils.invokeMethod(ReflectionUtils.tryToGetMethod(cls4, "value", new Class[0]).getOrThrow(new k(cls4, cls3)), annotation, new Object[0])));
                } else if (isRepeatableAnnotationContainer(annotationType)) {
                    for (Annotation annotation2 : (Annotation[]) ReflectionUtils.invokeMethod(ReflectionUtils.tryToGetMethod(annotationType, "value", new Class[0]).toOptional().get(), annotation, new Object[0])) {
                        findRepeatableAnnotations((AnnotatedElement) annotation2.getClass(), cls, cls2, z11, set, set2);
                    }
                } else {
                    findRepeatableAnnotations((AnnotatedElement) annotationType, cls, cls2, z11, set, set2);
                }
            }
        }
    }

    public static <A extends Annotation> Optional<A> findAnnotation(Class<?> cls, Class<A> cls2, boolean z11) {
        Preconditions.notNull(cls2, "annotationType must not be null");
        if (!z11) {
            return findAnnotation((AnnotatedElement) cls, cls2);
        }
        while (cls != null) {
            Optional<A> findAnnotation = findAnnotation((AnnotatedElement) cls, cls2);
            if (findAnnotation.isPresent()) {
                return findAnnotation;
            }
            cls = ReflectionUtils.isInnerClass(cls) ? cls.getEnclosingClass() : null;
        }
        return Optional.empty();
    }
}
