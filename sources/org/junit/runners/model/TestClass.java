package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.internal.MethodSorter;

public class TestClass implements Annotatable {
    private static final FieldComparator FIELD_COMPARATOR = new FieldComparator();
    private static final MethodComparator METHOD_COMPARATOR = new MethodComparator();
    private final Class<?> clazz;
    private final Map<Class<? extends Annotation>, List<FrameworkField>> fieldsForAnnotations;
    private final Map<Class<? extends Annotation>, List<FrameworkMethod>> methodsForAnnotations;

    public static class FieldComparator implements Comparator<Field> {
        private FieldComparator() {
        }

        public int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    }

    public static class MethodComparator implements Comparator<FrameworkMethod> {
        private MethodComparator() {
        }

        public int compare(FrameworkMethod frameworkMethod, FrameworkMethod frameworkMethod2) {
            return MethodSorter.NAME_ASCENDING.compare(frameworkMethod.getMethod(), frameworkMethod2.getMethod());
        }
    }

    public TestClass(Class<?> cls) {
        this.clazz = cls;
        if (cls == null || cls.getConstructors().length <= 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            b(linkedHashMap, linkedHashMap2);
            this.methodsForAnnotations = makeDeeplyUnmodifiable(linkedHashMap);
            this.fieldsForAnnotations = makeDeeplyUnmodifiable(linkedHashMap2);
            return;
        }
        throw new IllegalArgumentException("Test class can only have one constructor");
    }

    public static <T extends FrameworkMember<T>> void a(T t11, Map<Class<? extends Annotation>, List<T>> map) {
        Annotation[] annotations = t11.getAnnotations();
        int length = annotations.length;
        int i11 = 0;
        while (i11 < length) {
            Class<? extends Annotation> annotationType = annotations[i11].annotationType();
            List<? extends Annotation> annotatedMembers = getAnnotatedMembers(map, annotationType, true);
            if (!t11.b(annotatedMembers)) {
                if (runsTopToBottom(annotationType)) {
                    annotatedMembers.add(0, t11);
                } else {
                    annotatedMembers.add(t11);
                }
                i11++;
            } else {
                return;
            }
        }
    }

    private <T> List<T> collectValues(Map<?, List<T>> map) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (List<T> addAll : map.values()) {
            linkedHashSet.addAll(addAll);
        }
        return new ArrayList(linkedHashSet);
    }

    private static <T> List<T> getAnnotatedMembers(Map<Class<? extends Annotation>, List<T>> map, Class<? extends Annotation> cls, boolean z11) {
        if (!map.containsKey(cls) && z11) {
            map.put(cls, new ArrayList());
        }
        List<T> list = map.get(cls);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    private static Field[] getSortedDeclaredFields(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        Arrays.sort(declaredFields, FIELD_COMPARATOR);
        return declaredFields;
    }

    private static List<Class<?>> getSuperClasses(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            arrayList.add(cls2);
        }
        return arrayList;
    }

    private static <T extends FrameworkMember<T>> Map<Class<? extends Annotation>, List<T>> makeDeeplyUnmodifiable(Map<Class<? extends Annotation>, List<T>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            linkedHashMap.put(next.getKey(), Collections.unmodifiableList((List) next.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static boolean runsTopToBottom(Class<? extends Annotation> cls) {
        return cls.equals(Before.class) || cls.equals(BeforeClass.class);
    }

    public void b(Map<Class<? extends Annotation>, List<FrameworkMethod>> map, Map<Class<? extends Annotation>, List<FrameworkField>> map2) {
        for (Class next : getSuperClasses(this.clazz)) {
            for (Method frameworkMethod : MethodSorter.getDeclaredMethods(next)) {
                a(new FrameworkMethod(frameworkMethod), map);
            }
            for (Field frameworkField : getSortedDeclaredFields(next)) {
                a(new FrameworkField(frameworkField), map2);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.clazz == ((TestClass) obj).clazz) {
            return true;
        }
        return false;
    }

    public <T> List<T> getAnnotatedFieldValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        for (FrameworkField frameworkField : getAnnotatedFields(cls)) {
            try {
                Object obj2 = frameworkField.get(obj);
                if (cls2.isInstance(obj2)) {
                    arrayList.add(cls2.cast(obj2));
                }
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("How did getFields return a field we couldn't access?", e11);
            }
        }
        return arrayList;
    }

    public List<FrameworkField> getAnnotatedFields() {
        return collectValues(this.fieldsForAnnotations);
    }

    public <T> List<T> getAnnotatedMethodValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        for (FrameworkMethod next : getAnnotatedMethods(cls)) {
            try {
                if (cls2.isAssignableFrom(next.getReturnType())) {
                    arrayList.add(cls2.cast(next.invokeExplosively(obj, new Object[0])));
                }
            } catch (Throwable th2) {
                throw new RuntimeException("Exception in " + next.getName(), th2);
            }
        }
        return arrayList;
    }

    public List<FrameworkMethod> getAnnotatedMethods() {
        List<FrameworkMethod> collectValues = collectValues(this.methodsForAnnotations);
        Collections.sort(collectValues, METHOD_COMPARATOR);
        return collectValues;
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        Class<?> cls2 = this.clazz;
        if (cls2 == null) {
            return null;
        }
        return cls2.getAnnotation(cls);
    }

    public Annotation[] getAnnotations() {
        Class<?> cls = this.clazz;
        if (cls == null) {
            return new Annotation[0];
        }
        return cls.getAnnotations();
    }

    public Class<?> getJavaClass() {
        return this.clazz;
    }

    public String getName() {
        Class<?> cls = this.clazz;
        if (cls == null) {
            return "null";
        }
        return cls.getName();
    }

    public Constructor<?> getOnlyConstructor() {
        Constructor<?>[] constructors = this.clazz.getConstructors();
        Assert.assertEquals(1, (long) constructors.length);
        return constructors[0];
    }

    public int hashCode() {
        Class<?> cls = this.clazz;
        if (cls == null) {
            return 0;
        }
        return cls.hashCode();
    }

    public boolean isANonStaticInnerClass() {
        return this.clazz.isMemberClass() && !Modifier.isStatic(this.clazz.getModifiers());
    }

    public boolean isPublic() {
        return Modifier.isPublic(this.clazz.getModifiers());
    }

    public List<FrameworkField> getAnnotatedFields(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(getAnnotatedMembers(this.fieldsForAnnotations, cls, false));
    }

    public List<FrameworkMethod> getAnnotatedMethods(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(getAnnotatedMembers(this.methodsForAnnotations, cls, false));
    }
}
