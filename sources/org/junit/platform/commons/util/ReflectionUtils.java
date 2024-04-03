package org.junit.platform.commons.util;

import e30.c;
import f30.n;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.DesugarArrays;
import j$.util.Optional;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import java.io.File;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l30.a1;
import l30.a2;
import l30.b0;
import l30.b1;
import l30.b2;
import l30.c1;
import l30.c2;
import l30.d1;
import l30.d2;
import l30.e1;
import l30.e2;
import l30.f1;
import l30.f2;
import l30.g1;
import l30.g2;
import l30.h1;
import l30.h2;
import l30.i1;
import l30.j1;
import l30.k1;
import l30.l1;
import l30.m1;
import l30.n1;
import l30.o1;
import l30.p1;
import l30.q0;
import l30.q1;
import l30.r0;
import l30.r1;
import l30.s0;
import l30.s1;
import l30.t0;
import l30.t1;
import l30.u0;
import l30.u1;
import l30.v0;
import l30.v1;
import l30.w0;
import l30.w1;
import l30.x0;
import l30.x1;
import l30.y0;
import l30.y1;
import l30.z0;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import x20.v;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class ReflectionUtils {
    private static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    private static final Pattern SOURCE_CODE_SYNTAX_ARRAY_PATTERN = Pattern.compile("^([^\\[\\]]+)((?>\\[\\])++)$");
    private static final Pattern VM_INTERNAL_OBJECT_ARRAY_PATTERN = Pattern.compile("^(\\[+)L(.+);$");
    private static final Pattern VM_INTERNAL_PRIMITIVE_ARRAY_PATTERN = Pattern.compile("^(\\[+)(\\[[ZBCDFIJS])$");
    private static final Map<String, Class<?>> classNameToTypeMap;
    private static final ClasspathScanner classpathScanner = new ClasspathScanner(new h2(), new q0());
    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);
    private static final Set<String> noCyclesDetectedCache = ConcurrentHashMap.newKeySet();
    private static final Map<Class<?>, Class<?>> primitiveToWrapperMap;

    public enum HierarchyTraversalMode {
        TOP_DOWN,
        BOTTOM_UP
    }

    static {
        Class cls = Boolean.TYPE;
        Class cls2 = Integer.TYPE;
        Class cls3 = Long.TYPE;
        Class cls4 = Float.TYPE;
        Class<Boolean> cls5 = Boolean.class;
        Class<Byte> cls6 = Byte.class;
        Class<Character> cls7 = Character.class;
        Class<Short> cls8 = Short.class;
        Class<Integer> cls9 = Integer.class;
        Class<Long> cls10 = Long.class;
        Class<Float> cls11 = Float.class;
        Class<Double> cls12 = Double.class;
        List asList = Arrays.asList(new Class[]{cls, Byte.TYPE, Character.TYPE, Short.TYPE, cls2, cls3, cls4, Double.TYPE, boolean[].class, byte[].class, char[].class, short[].class, int[].class, long[].class, float[].class, double[].class, boolean[][].class, byte[][].class, char[][].class, short[][].class, int[][].class, long[][].class, float[][].class, double[][].class, cls5, cls6, cls7, cls8, cls9, cls10, cls11, cls12, String.class, Boolean[].class, Byte[].class, Character[].class, Short[].class, Integer[].class, Long[].class, Float[].class, Double[].class, String[].class, Boolean[][].class, Byte[][].class, Character[][].class, Short[][].class, Integer[][].class, Long[][].class, Float[][].class, Double[][].class, String[][].class});
        HashMap hashMap = new HashMap(64);
        Iterable.EL.forEach(asList, new r0(hashMap));
        classNameToTypeMap = Collections.unmodifiableMap(hashMap);
        IdentityHashMap identityHashMap = new IdentityHashMap(8);
        identityHashMap.put(cls, cls5);
        identityHashMap.put(Byte.TYPE, cls6);
        identityHashMap.put(Character.TYPE, cls7);
        identityHashMap.put(Short.TYPE, cls8);
        identityHashMap.put(cls2, cls9);
        identityHashMap.put(cls3, cls10);
        identityHashMap.put(cls4, cls11);
        identityHashMap.put(Double.TYPE, cls12);
        primitiveToWrapperMap = Collections.unmodifiableMap(identityHashMap);
    }

    private ReflectionUtils() {
    }

    public static boolean N(Method method) {
        if (isGeneric(method.getGenericReturnType()) || DesugarArrays.stream((T[]) method.getGenericParameterTypes()).anyMatch(new b2())) {
            return true;
        }
        return false;
    }

    public static boolean O(Class<?> cls, Class<?> cls2) {
        Preconditions.condition(cls2.isPrimitive(), "targetType must be primitive");
        boolean isPrimitive = cls.isPrimitive();
        Map<Class<?>, Class<?>> map = primitiveToWrapperMap;
        boolean containsValue = map.containsValue(cls);
        if (!isPrimitive && !containsValue) {
            return false;
        }
        if (isPrimitive) {
            cls = map.get(cls);
        }
        if (cls == Byte.class) {
            if (cls2 == Short.TYPE || cls2 == Integer.TYPE || cls2 == Long.TYPE || cls2 == Float.TYPE || cls2 == Double.TYPE) {
                return true;
            }
            return false;
        } else if (cls == Short.class || cls == Character.class) {
            if (cls2 == Integer.TYPE || cls2 == Long.TYPE || cls2 == Float.TYPE || cls2 == Double.TYPE) {
                return true;
            }
            return false;
        } else if (cls == Integer.class) {
            if (cls2 == Long.TYPE || cls2 == Float.TYPE || cls2 == Double.TYPE) {
                return true;
            }
            return false;
        } else if (cls == Long.class) {
            if (cls2 == Float.TYPE || cls2 == Double.TYPE) {
                return true;
            }
            return false;
        } else if (cls == Float.class && cls2 == Double.TYPE) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static int defaultFieldSorter(Field field, Field field2) {
        return Integer.compare(field.getName().hashCode(), field2.getName().hashCode());
    }

    /* access modifiers changed from: private */
    public static int defaultMethodSorter(Method method, Method method2) {
        String name2 = method.getName();
        String name3 = method2.getName();
        int compare = Integer.compare(name2.hashCode(), name3.hashCode());
        if (compare != 0) {
            return compare;
        }
        int compareTo = name2.compareTo(name3);
        if (compareTo == 0) {
            return method.toString().compareTo(method2.toString());
        }
        return compareTo;
    }

    private static void detectInnerClassCycle(Class<?> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        String name2 = cls.getName();
        if (!noCyclesDetectedCache.contains(name2)) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (isInnerClass(cls) && isSearchable(superclass)) {
                do {
                    cls = cls.getEnclosingClass();
                    if (cls != null) {
                    }
                } while (!superclass.equals(cls));
                throw new JUnitException(String.format("Detected cycle in inner class hierarchy between %s and %s", new Object[]{name2, cls.getName()}));
            }
            noCyclesDetectedCache.add(name2);
        }
    }

    public static List<Class<?>> findAllClassesInClasspathRoot(URI uri, Predicate<Class<?>> predicate, Predicate<String> predicate2) {
        return findAllClassesInClasspathRoot(uri, ClassFilter.of(predicate2, predicate));
    }

    public static List<Class<?>> findAllClassesInModule(String str, Predicate<Class<?>> predicate, Predicate<String> predicate2) {
        return findAllClassesInModule(str, ClassFilter.of(predicate2, predicate));
    }

    public static List<Class<?>> findAllClassesInPackage(String str, Predicate<Class<?>> predicate, Predicate<String> predicate2) {
        return findAllClassesInPackage(str, ClassFilter.of(predicate2, predicate));
    }

    private static List<Field> findAllFieldsInHierarchy(Class<?> cls, HierarchyTraversalMode hierarchyTraversalMode) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(hierarchyTraversalMode, "HierarchyTraversalMode must not be null");
        List list = (List) Collection.EL.stream(getDeclaredFields(cls)).filter(new u0()).collect(Collectors.toList());
        List list2 = (List) Collection.EL.stream(getSuperclassFields(cls, hierarchyTraversalMode)).filter(new v0(list)).collect(Collectors.toList());
        List list3 = (List) Collection.EL.stream(getInterfaceFields(cls, hierarchyTraversalMode)).filter(new w0(list)).collect(Collectors.toList());
        ArrayList arrayList = new ArrayList();
        if (hierarchyTraversalMode == HierarchyTraversalMode.TOP_DOWN) {
            arrayList.addAll(list2);
            arrayList.addAll(list3);
        }
        arrayList.addAll(list);
        if (hierarchyTraversalMode == HierarchyTraversalMode.BOTTOM_UP) {
            arrayList.addAll(list3);
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    private static List<Method> findAllMethodsInHierarchy(Class<?> cls, HierarchyTraversalMode hierarchyTraversalMode) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(hierarchyTraversalMode, "HierarchyTraversalMode must not be null");
        List list = (List) Collection.EL.stream(getDeclaredMethods(cls, hierarchyTraversalMode)).filter(new b1()).collect(Collectors.toList());
        List list2 = (List) Collection.EL.stream(getSuperclassMethods(cls, hierarchyTraversalMode)).filter(new c1(list)).collect(Collectors.toList());
        List list3 = (List) Collection.EL.stream(getInterfaceMethods(cls, hierarchyTraversalMode)).filter(new d1(list)).collect(Collectors.toList());
        ArrayList arrayList = new ArrayList();
        if (hierarchyTraversalMode == HierarchyTraversalMode.TOP_DOWN) {
            arrayList.addAll(list2);
            arrayList.addAll(list3);
        }
        arrayList.addAll(list);
        if (hierarchyTraversalMode == HierarchyTraversalMode.BOTTOM_UP) {
            arrayList.addAll(list3);
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    public static List<Constructor<?>> findConstructors(Class<?> cls, Predicate<Constructor<?>> predicate) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(predicate, "Predicate must not be null");
        try {
            return (List) DesugarArrays.stream((T[]) cls.getDeclaredConstructors()).filter(predicate).collect(CollectionUtils.toUnmodifiableList());
        } catch (Throwable th2) {
            throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(th2));
        }
    }

    public static List<Field> findFields(Class<?> cls, Predicate<Field> predicate, HierarchyTraversalMode hierarchyTraversalMode) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(predicate, "Predicate must not be null");
        Preconditions.notNull(hierarchyTraversalMode, "HierarchyTraversalMode must not be null");
        return (List) Collection.EL.stream(findAllFieldsInHierarchy(cls, hierarchyTraversalMode)).filter(predicate).collect(CollectionUtils.toUnmodifiableList());
    }

    public static Optional<Method> findMethod(Class<?> cls, String str, String str2) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notBlank(str, "Method name must not be null or blank");
        return findMethod(cls, str, (Class<?>[]) resolveParameterTypes(cls, str, str2));
    }

    public static List<Method> findMethods(Class<?> cls, Predicate<Method> predicate) {
        return findMethods(cls, predicate, HierarchyTraversalMode.TOP_DOWN);
    }

    public static List<Class<?>> findNestedClasses(Class<?> cls, Predicate<Class<?>> predicate) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(predicate, "Predicate must not be null");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        findNestedClasses(cls, predicate, linkedHashSet);
        return Collections.unmodifiableList(new ArrayList(linkedHashSet));
    }

    public static Set<Class<?>> getAllAssignmentCompatibleClasses(Class<?> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllAssignmentCompatibleClasses(cls, linkedHashSet);
        return linkedHashSet;
    }

    public static Set<Path> getAllClasspathRootDirectories() {
        return (Set) DesugarArrays.stream((T[]) System.getProperty("java.class.path").split(File.pathSeparator)).map(new i1()).filter(new j1()).collect(Collectors.toSet());
    }

    public static <T> Constructor<T> getDeclaredConstructor(Class<T> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        try {
            List list = (List) DesugarArrays.stream((T[]) cls.getDeclaredConstructors()).filter(new g1()).collect(Collectors.toList());
            boolean z11 = true;
            if (list.size() != 1) {
                z11 = false;
            }
            Preconditions.condition(z11, (Supplier<String>) new h1(cls));
            return (Constructor) list.get(0);
        } catch (Throwable th2) {
            throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(th2));
        }
    }

    private static List<Field> getDeclaredFields(Class<?> cls) {
        return toSortedMutableList(cls.getDeclaredFields());
    }

    private static List<Method> getDeclaredMethods(Class<?> cls, HierarchyTraversalMode hierarchyTraversalMode) {
        List<Method> defaultMethods = getDefaultMethods(cls);
        List<Method> sortedMutableList = toSortedMutableList(cls.getDeclaredMethods());
        if (hierarchyTraversalMode == HierarchyTraversalMode.BOTTOM_UP) {
            sortedMutableList.addAll(defaultMethods);
            return sortedMutableList;
        }
        defaultMethods.addAll(sortedMutableList);
        return defaultMethods;
    }

    private static List<Method> getDefaultMethods(Class<?> cls) {
        List<Method> list = (List) DesugarArrays.stream((T[]) cls.getMethods()).filter(new e2()).collect(Collectors.toCollection(new c()));
        if (list.isEmpty()) {
            return list;
        }
        return (List) DesugarArrays.stream((T[]) cls.getInterfaces()).map(new f2()).flatMap(new b0()).filter(new g2(list)).collect(Collectors.toCollection(new c()));
    }

    private static List<Field> getFields(Class<?> cls) {
        return toSortedMutableList(cls.getFields());
    }

    public static String getFullyQualifiedMethodName(Class<?> cls, Method method) {
        Preconditions.notNull(method, "Method must not be null");
        return getFullyQualifiedMethodName(cls, method.getName(), method.getParameterTypes());
    }

    private static List<Field> getInterfaceFields(Class<?> cls, HierarchyTraversalMode hierarchyTraversalMode) {
        ArrayList arrayList = new ArrayList();
        for (Class cls2 : cls.getInterfaces()) {
            List<Field> fields = getFields(cls2);
            List list = (List) Collection.EL.stream(getInterfaceFields(cls2, hierarchyTraversalMode)).filter(new d2(fields)).collect(Collectors.toList());
            if (hierarchyTraversalMode == HierarchyTraversalMode.TOP_DOWN) {
                arrayList.addAll(list);
            }
            arrayList.addAll(fields);
            if (hierarchyTraversalMode == HierarchyTraversalMode.BOTTOM_UP) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    private static List<Method> getInterfaceMethods(Class<?> cls, HierarchyTraversalMode hierarchyTraversalMode) {
        ArrayList arrayList = new ArrayList();
        for (Class cls2 : cls.getInterfaces()) {
            List list = (List) Collection.EL.stream(getMethods(cls2)).filter(new t1()).collect(Collectors.toList());
            List list2 = (List) Collection.EL.stream(getInterfaceMethods(cls2, hierarchyTraversalMode)).filter(new u1(list)).collect(Collectors.toList());
            if (hierarchyTraversalMode == HierarchyTraversalMode.TOP_DOWN) {
                arrayList.addAll(list2);
            }
            arrayList.addAll(list);
            if (hierarchyTraversalMode == HierarchyTraversalMode.BOTTOM_UP) {
                arrayList.addAll(list2);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static List<Method> getMethods(Class<?> cls) {
        return toSortedMutableList(cls.getMethods());
    }

    private static Optional<Object> getOuterInstance(Object obj) {
        return DesugarArrays.stream((T[]) obj.getClass().getDeclaredFields()).filter(new y0()).findFirst().map(new z0(obj));
    }

    @Deprecated
    @API(since = "1.4", status = API.Status.DEPRECATED)
    public static Optional<Object> getOutermostInstance(Object obj, Class<?> cls) {
        Preconditions.notNull(obj, "inner object must not be null");
        Preconditions.notNull(cls, "requiredType must not be null");
        if (cls.isInstance(obj)) {
            return Optional.of(obj);
        }
        Optional<Object> outerInstance = getOuterInstance(obj);
        if (outerInstance.isPresent()) {
            return getOutermostInstance(outerInstance.get(), cls);
        }
        return Optional.empty();
    }

    @API(since = "1.7", status = API.Status.STABLE)
    public static Method getRequiredMethod(Class<?> cls, String str, Class<?>... clsArr) {
        return findMethod(cls, str, clsArr).orElseThrow(new e1(str, cls));
    }

    private static List<Field> getSuperclassFields(Class<?> cls, HierarchyTraversalMode hierarchyTraversalMode) {
        Class<? super Object> superclass = cls.getSuperclass();
        if (!isSearchable(superclass)) {
            return Collections.emptyList();
        }
        return findAllFieldsInHierarchy(superclass, hierarchyTraversalMode);
    }

    private static List<Method> getSuperclassMethods(Class<?> cls, HierarchyTraversalMode hierarchyTraversalMode) {
        Class<? super Object> superclass = cls.getSuperclass();
        if (!isSearchable(superclass)) {
            return Collections.emptyList();
        }
        return findAllMethodsInHierarchy(superclass, hierarchyTraversalMode);
    }

    private static Throwable getUnderlyingCause(Throwable th2) {
        if (th2 instanceof InvocationTargetException) {
            return getUnderlyingCause(((InvocationTargetException) th2).getTargetException());
        }
        return th2;
    }

    public static Class<?> getWrapperType(Class<?> cls) {
        return primitiveToWrapperMap.get(cls);
    }

    /* access modifiers changed from: private */
    public static boolean hasCompatibleSignature(Method method, String str, Class<?>[] clsArr) {
        if (!str.equals(method.getName()) || clsArr.length != method.getParameterCount()) {
            return false;
        }
        if (Arrays.equals(clsArr, method.getParameterTypes())) {
            return true;
        }
        for (int i11 = 0; i11 < clsArr.length; i11++) {
            if (!method.getParameterTypes()[i11].isAssignableFrom(clsArr[i11])) {
                return false;
            }
        }
        if (N(method)) {
            return true;
        }
        return false;
    }

    public static Object invokeMethod(Method method, Object obj, Object... objArr) {
        boolean z11;
        Preconditions.notNull(method, "Method must not be null");
        if (obj != null || isStatic((Member) method)) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.condition(z11, (Supplier<String>) new r1(method));
        try {
            return ((Method) makeAccessible(method)).invoke(obj, objArr);
        } catch (Throwable th2) {
            throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(th2));
        }
    }

    public static boolean isAbstract(Class<?> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        return Modifier.isAbstract(cls.getModifiers());
    }

    public static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    public static boolean isAssignableTo(Class<?> cls, Class<?> cls2) {
        Preconditions.notNull(cls, "source type must not be null");
        Preconditions.condition(!cls.isPrimitive(), "source type must not be a primitive type");
        Preconditions.notNull(cls2, "target type must not be null");
        if (cls2.isAssignableFrom(cls)) {
            return true;
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (cls == primitiveToWrapperMap.get(cls2) || O(cls, cls2)) {
            return true;
        }
        return false;
    }

    private static boolean isFieldShadowedByLocalFields(Field field, List<Field> list) {
        return Collection.EL.stream(list).anyMatch(new s1(field));
    }

    @API(since = "1.5", status = API.Status.INTERNAL)
    public static boolean isFinal(Class<?> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        return Modifier.isFinal(cls.getModifiers());
    }

    /* access modifiers changed from: private */
    public static boolean isGeneric(Type type) {
        return (type instanceof TypeVariable) || (type instanceof GenericArrayType);
    }

    public static boolean isInnerClass(Class<?> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        if (isStatic(cls) || !cls.isMemberClass()) {
            return false;
        }
        return true;
    }

    public static boolean isMethodPresent(Class<?> cls, Predicate<Method> predicate) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(predicate, "Predicate must not be null");
        return findMethod(cls, predicate).isPresent();
    }

    /* access modifiers changed from: private */
    public static boolean isMethodShadowedBy(Method method, Method method2) {
        return hasCompatibleSignature(method, method2.getName(), method2.getParameterTypes());
    }

    private static boolean isMethodShadowedByLocalMethods(Method method, List<Method> list) {
        return Collection.EL.stream(list).anyMatch(new f1(method));
    }

    @API(since = "1.3.2", status = API.Status.INTERNAL)
    public static boolean isMultidimensionalArray(Object obj) {
        return obj != null && obj.getClass().isArray() && obj.getClass().getComponentType().isArray();
    }

    @API(since = "1.5", status = API.Status.INTERNAL)
    public static boolean isNotFinal(Class<?> cls) {
        return !isFinal(cls);
    }

    @API(since = "1.4", status = API.Status.INTERNAL)
    public static boolean isNotPrivate(Class<?> cls) {
        return !isPrivate(cls);
    }

    @API(since = "1.4", status = API.Status.INTERNAL)
    public static boolean isNotStatic(Class<?> cls) {
        return !isStatic(cls);
    }

    public static boolean isPrivate(Class<?> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        return Modifier.isPrivate(cls.getModifiers());
    }

    public static boolean isPublic(Class<?> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        return Modifier.isPublic(cls.getModifiers());
    }

    private static boolean isSearchable(Class<?> cls) {
        return (cls == null || cls == Object.class) ? false : true;
    }

    public static boolean isStatic(Class<?> cls) {
        Preconditions.notNull(cls, "Class must not be null");
        return Modifier.isStatic(cls.getModifiers());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAllFieldsInHierarchy$18(Field field) {
        return !field.isSynthetic();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAllFieldsInHierarchy$19(List list, Field field) {
        return !isFieldShadowedByLocalFields(field, list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAllFieldsInHierarchy$20(List list, Field field) {
        return !isFieldShadowedByLocalFields(field, list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAllMethodsInHierarchy$27(Method method) {
        return !method.isSynthetic();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAllMethodsInHierarchy$28(List list, Method method) {
        return !isMethodShadowedByLocalMethods(method, list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findAllMethodsInHierarchy$29(List list, Method method) {
        return !isMethodShadowedByLocalMethods(method, list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$findNestedClasses$15(Class cls) {
        return "Failed to retrieve declared classes for " + cls.getName();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getDeclaredConstructor$16(Constructor constructor) {
        return !constructor.isSynthetic();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInterfaceFields$32(List list, Field field) {
        return !isFieldShadowedByLocalFields(field, list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInterfaceMethods$30(Method method) {
        return !isAbstract((Member) method);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInterfaceMethods$31(List list, Method method) {
        return !isMethodShadowedByLocalMethods(method, list);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getOuterInstance$12(Object obj, Field field) {
        try {
            return ((Field) makeAccessible(field)).get(obj);
        } catch (Throwable th2) {
            throw ExceptionUtils.throwAsUncheckedException(th2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JUnitException lambda$getRequiredMethod$26(String str, Class cls) {
        return new JUnitException(String.format("Could not find method [%s] in class [%s]", new Object[]{str, cls.getName()}));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JUnitException lambda$loadRequiredParameterType$24(String str, String str2, Class cls, Exception exc) {
        return new JUnitException(String.format("Failed to load parameter type [%s] for method [%s] in class [%s].", new Object[]{str, str2, cls.getName()}), exc);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Class[] lambda$newInstance$1(int i11) {
        return new Class[i11];
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$parseFullyQualifiedMethodName$10(String str) {
        return "[" + str + "] is not a valid fully qualified method name: it must start with a fully qualified class name followed by a '#' and then the method name, optionally followed by a parameter list enclosed in parentheses.";
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$readFieldValues$6(Field field) {
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Class[] lambda$resolveParameterTypes$23(int i11) {
        return new Class[i11];
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Map map, Class cls) {
        map.put(cls.getName(), cls);
        map.put(cls.getCanonicalName(), cls);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Class lambda$tryToLoadClass$9(String str, ClassLoader classLoader) throws Exception {
        Matcher matcher = VM_INTERNAL_PRIMITIVE_ARRAY_PATTERN.matcher(str);
        if (matcher.matches()) {
            return loadArrayType(classLoader, matcher.group(2), matcher.group(1).length());
        }
        Matcher matcher2 = VM_INTERNAL_OBJECT_ARRAY_PATTERN.matcher(str);
        if (matcher2.matches()) {
            return loadArrayType(classLoader, matcher2.group(2), matcher2.group(1).length());
        }
        Matcher matcher3 = SOURCE_CODE_SYNTAX_ARRAY_PATTERN.matcher(str);
        if (matcher3.matches()) {
            return loadArrayType(classLoader, matcher3.group(1), matcher3.group(2).length() / 2);
        }
        return classLoader.loadClass(str);
    }

    private static Class<?> loadArrayType(ClassLoader classLoader, String str, int i11) throws ClassNotFoundException {
        Class<?> cls;
        Map<String, Class<?>> map = classNameToTypeMap;
        if (map.containsKey(str)) {
            cls = map.get(str);
        } else {
            cls = classLoader.loadClass(str);
        }
        return Array.newInstance(cls, new int[i11]).getClass();
    }

    @Deprecated
    @API(since = "1.4", status = API.Status.DEPRECATED)
    public static Optional<Class<?>> loadClass(String str) {
        return tryToLoadClass(str).toOptional();
    }

    /* access modifiers changed from: private */
    public static Class<?> loadRequiredParameterType(Class<?> cls, String str, String str2) {
        return tryToLoadClass(str2).getOrThrow(new a2(str2, str, cls));
    }

    public static <T extends AccessibleObject> T makeAccessible(T t11) {
        if (!t11.isAccessible()) {
            t11.setAccessible(true);
        }
        return t11;
    }

    public static <T> T newInstance(Class<T> cls, Object... objArr) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(objArr, "Argument array must not be null");
        Preconditions.containsNoNullElements((T[]) objArr, "Individual arguments must not be null");
        try {
            return newInstance(cls.getDeclaredConstructor((Class[]) DesugarArrays.stream((T[]) objArr).map(new n()).toArray(new w1())), objArr);
        } catch (Throwable th2) {
            throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(th2));
        }
    }

    public static String[] parseFullyQualifiedMethodName(String str) {
        boolean z11;
        int lastIndexOf;
        Preconditions.notBlank(str, "fullyQualifiedMethodName must not be null or blank");
        int indexOf = str.indexOf(35);
        if (indexOf <= 0 || indexOf >= str.length() - 1) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.condition(z11, (Supplier<String>) new o1(str));
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        String str2 = "";
        if (substring2.endsWith("()")) {
            substring2 = substring2.substring(0, substring2.length() - 2);
        } else if (substring2.endsWith(")") && (lastIndexOf = substring2.lastIndexOf(40)) > 0 && lastIndexOf < substring2.length() - 1) {
            String substring3 = substring2.substring(0, lastIndexOf);
            str2 = substring2.substring(lastIndexOf + 1, substring2.length() - 1);
            substring2 = substring3;
        }
        return new String[]{substring, substring2, str2};
    }

    @Deprecated
    @API(since = "1.4", status = API.Status.DEPRECATED)
    public static <T> Optional<Object> readFieldValue(Class<T> cls, String str, T t11) {
        return tryToReadFieldValue(cls, str, t11).toOptional();
    }

    public static List<Object> readFieldValues(List<Field> list, Object obj) {
        return readFieldValues(list, obj, new n1());
    }

    private static Class<?>[] resolveParameterTypes(Class<?> cls, String str, String str2) {
        if (StringUtils.isBlank(str2)) {
            return EMPTY_CLASS_ARRAY;
        }
        return (Class[]) DesugarArrays.stream((T[]) str2.split(",")).map(new v()).map(new a1(cls, str)).toArray(new l1());
    }

    public static boolean returnsVoid(Method method) {
        return method.getReturnType().equals(Void.TYPE);
    }

    private static List<Field> toSortedMutableList(Field[] fieldArr) {
        return (List) DesugarArrays.stream((T[]) fieldArr).sorted(new v1()).collect(Collectors.toCollection(new c()));
    }

    @API(since = "1.4", status = API.Status.INTERNAL)
    public static Try<Method> tryToGetMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notBlank(str, "Method name must not be null or blank");
        return Try.call(new c2(cls, str, clsArr));
    }

    @API(since = "1.4", status = API.Status.INTERNAL)
    public static Try<Class<?>> tryToLoadClass(String str) {
        return tryToLoadClass(str, ClassLoaderUtils.getDefaultClassLoader());
    }

    @API(since = "1.4", status = API.Status.INTERNAL)
    public static <T> Try<Object> tryToReadFieldValue(Class<T> cls, String str, T t11) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notBlank(str, "Field name must not be null or blank");
        return Try.call(new s0(cls, str)).andThen(new t0(t11));
    }

    public static List<Class<?>> findAllClassesInClasspathRoot(URI uri, ClassFilter classFilter) {
        return Collections.unmodifiableList(classpathScanner.k(uri, classFilter));
    }

    public static List<Class<?>> findAllClassesInModule(String str, ClassFilter classFilter) {
        return Collections.unmodifiableList(ModuleUtils.findAllClassesInModule(str, classFilter));
    }

    public static List<Class<?>> findAllClassesInPackage(String str, ClassFilter classFilter) {
        return Collections.unmodifiableList(classpathScanner.l(str, classFilter));
    }

    public static List<Method> findMethods(Class<?> cls, Predicate<Method> predicate, HierarchyTraversalMode hierarchyTraversalMode) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(predicate, "Predicate must not be null");
        Preconditions.notNull(hierarchyTraversalMode, "HierarchyTraversalMode must not be null");
        return (List) Collection.EL.stream(findAllMethodsInHierarchy(cls, hierarchyTraversalMode)).filter(predicate).distinct().collect(CollectionUtils.toUnmodifiableList());
    }

    @API(since = "1.5", status = API.Status.INTERNAL)
    public static boolean isNotFinal(Member member) {
        return !isFinal(member);
    }

    @API(since = "1.1", status = API.Status.INTERNAL)
    public static boolean isNotPrivate(Member member) {
        return !isPrivate(member);
    }

    @API(since = "1.1", status = API.Status.INTERNAL)
    public static boolean isNotStatic(Member member) {
        return !isStatic(member);
    }

    @Deprecated
    @API(since = "1.4", status = API.Status.DEPRECATED)
    public static Optional<Class<?>> loadClass(String str, ClassLoader classLoader) {
        return tryToLoadClass(str, classLoader).toOptional();
    }

    @Deprecated
    @API(since = "1.4", status = API.Status.DEPRECATED)
    public static Optional<Object> readFieldValue(Field field) {
        return tryToReadFieldValue(field).toOptional();
    }

    public static List<Object> readFieldValues(List<Field> list, Object obj, Predicate<Field> predicate) {
        Preconditions.notNull(list, "fields list must not be null");
        Preconditions.notNull(predicate, "Predicate must not be null");
        return (List) Collection.EL.stream(list).filter(predicate).map(new x1(obj)).collect(CollectionUtils.toUnmodifiableList());
    }

    @API(since = "1.4", status = API.Status.INTERNAL)
    public static Try<Class<?>> tryToLoadClass(String str, ClassLoader classLoader) {
        Preconditions.notBlank(str, "Class name must not be null or blank");
        Preconditions.notNull(classLoader, "ClassLoader must not be null");
        String trim = str.trim();
        Map<String, Class<?>> map = classNameToTypeMap;
        if (map.containsKey(trim)) {
            return Try.success(map.get(trim));
        }
        return Try.call(new x0(trim, classLoader));
    }

    public static String getFullyQualifiedMethodName(Class<?> cls, String str, Class<?>... clsArr) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notBlank(str, "Method name must not be null or blank");
        return String.format("%s#%s(%s)", new Object[]{cls.getName(), str, ClassUtils.nullSafeToString(clsArr)});
    }

    public static boolean isAbstract(Member member) {
        Preconditions.notNull(member, "Member must not be null");
        return Modifier.isAbstract(member.getModifiers());
    }

    @API(since = "1.5", status = API.Status.INTERNAL)
    public static boolean isFinal(Member member) {
        Preconditions.notNull(member, "Member must not be null");
        return Modifier.isFinal(member.getModifiers());
    }

    public static boolean isPrivate(Member member) {
        Preconditions.notNull(member, "Member must not be null");
        return Modifier.isPrivate(member.getModifiers());
    }

    public static boolean isPublic(Member member) {
        Preconditions.notNull(member, "Member must not be null");
        return Modifier.isPublic(member.getModifiers());
    }

    public static boolean isStatic(Member member) {
        Preconditions.notNull(member, "Member must not be null");
        return Modifier.isStatic(member.getModifiers());
    }

    @Deprecated
    @API(since = "1.4", status = API.Status.DEPRECATED)
    public static Optional<Object> readFieldValue(Field field, Object obj) {
        return tryToReadFieldValue(field, obj).toOptional();
    }

    public static Optional<Method> findMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notBlank(str, "Method name must not be null or blank");
        Preconditions.notNull(clsArr, "Parameter types array must not be null");
        Preconditions.containsNoNullElements((T[]) clsArr, "Individual parameter types must not be null");
        return findMethod(cls, new y1(str, clsArr));
    }

    private static void getAllAssignmentCompatibleClasses(Class<?> cls, Set<Class<?>> set) {
        Class<? super Object> cls2;
        while (cls2 != null) {
            set.add(cls2);
            for (Class cls3 : cls2.getInterfaces()) {
                if (!set.contains(cls3)) {
                    getAllAssignmentCompatibleClasses(cls3, set);
                }
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
    }

    private static List<Method> toSortedMutableList(Method[] methodArr) {
        return (List) DesugarArrays.stream((T[]) methodArr).sorted(new q1()).collect(Collectors.toCollection(new c()));
    }

    @API(since = "1.4", status = API.Status.INTERNAL)
    public static Try<Object> tryToReadFieldValue(Field field) {
        return tryToReadFieldValue(field, (Object) null);
    }

    private static void findNestedClasses(Class<?> cls, Predicate<Class<?>> predicate, Set<Class<?>> set) {
        if (isSearchable(cls)) {
            if (isInnerClass(cls) && predicate.test(cls)) {
                detectInnerClassCycle(cls);
            }
            try {
                for (Class cls2 : cls.getDeclaredClasses()) {
                    if (predicate.test(cls2)) {
                        detectInnerClassCycle(cls2);
                        set.add(cls2);
                    }
                }
            } catch (NoClassDefFoundError e11) {
                logger.debug(e11, new p1(cls));
            }
            findNestedClasses(cls.getSuperclass(), predicate, set);
            for (Class findNestedClasses : cls.getInterfaces()) {
                findNestedClasses(findNestedClasses, predicate, set);
            }
        }
    }

    @API(since = "1.4", status = API.Status.INTERNAL)
    public static Try<Object> tryToReadFieldValue(Field field, Object obj) {
        Preconditions.notNull(field, "Field must not be null");
        Preconditions.condition(obj != null || isStatic((Member) field), (Supplier<String>) new k1(field));
        return Try.call(new m1(field, obj));
    }

    public static boolean isAssignableTo(Object obj, Class<?> cls) {
        Preconditions.notNull(cls, "target type must not be null");
        if (obj == null) {
            return !cls.isPrimitive();
        }
        if (cls.isInstance(obj)) {
            return true;
        }
        if (!cls.isPrimitive()) {
            return false;
        }
        Class<?> cls2 = obj.getClass();
        if (cls2 == primitiveToWrapperMap.get(cls) || O(cls2, cls)) {
            return true;
        }
        return false;
    }

    public static <T> T newInstance(Constructor<T> constructor, Object... objArr) {
        Preconditions.notNull(constructor, "Constructor must not be null");
        try {
            return ((Constructor) makeAccessible(constructor)).newInstance(objArr);
        } catch (Throwable th2) {
            throw ExceptionUtils.throwAsUncheckedException(getUnderlyingCause(th2));
        }
    }

    private static Optional<Method> findMethod(Class<?> cls, Predicate<Method> predicate) {
        Preconditions.notNull(cls, "Class must not be null");
        Preconditions.notNull(predicate, "Predicate must not be null");
        for (Class<? super Object> cls2 = cls; isSearchable(cls2); cls2 = cls2.getSuperclass()) {
            for (Method next : cls2.isInterface() ? getMethods(cls2) : getDeclaredMethods(cls2, HierarchyTraversalMode.BOTTOM_UP)) {
                if (predicate.test(next)) {
                    return Optional.of(next);
                }
            }
            for (Class findMethod : cls2.getInterfaces()) {
                Optional<Method> findMethod2 = findMethod(findMethod, predicate);
                if (findMethod2.isPresent()) {
                    return findMethod2;
                }
            }
        }
        return Optional.empty();
    }
}
