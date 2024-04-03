package org.apache.commons.lang3.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;

public class MethodUtils {
    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return getAccessibleMethod(cls.getMethod(str, clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        Class<? super Object> cls2;
        while (cls2 != null) {
            Class[] interfaces = cls2.getInterfaces();
            for (int i11 = 0; i11 < interfaces.length; i11++) {
                if (Modifier.isPublic(interfaces[i11].getModifiers())) {
                    try {
                        return interfaces[i11].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(interfaces[i11], str, clsArr);
                        if (accessibleMethodFromInterfaceNest != null) {
                            return accessibleMethodFromInterfaceNest;
                        }
                    }
                }
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Method getAccessibleMethodFromSuperclass(java.lang.Class<?> r2, java.lang.String r3, java.lang.Class<?>... r4) {
        /*
            java.lang.Class r2 = r2.getSuperclass()
        L_0x0004:
            r0 = 0
            if (r2 == 0) goto L_0x001c
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
            if (r1 == 0) goto L_0x0017
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0016 }
            return r2
        L_0x0016:
            return r0
        L_0x0017:
            java.lang.Class r2 = r2.getSuperclass()
            goto L_0x0004
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethodFromSuperclass(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method accessibleMethod;
        try {
            Method method = cls.getMethod(str, clsArr);
            MemberUtils.d(method);
            return method;
        } catch (NoSuchMethodException unused) {
            Method method2 = null;
            for (Method method3 : cls.getMethods()) {
                if (method3.getName().equals(str) && ClassUtils.isAssignable(clsArr, (Class<?>[]) method3.getParameterTypes(), true) && (accessibleMethod = getAccessibleMethod(method3)) != null && (method2 == null || MemberUtils.a(accessibleMethod.getParameterTypes(), method2.getParameterTypes(), clsArr) < 0)) {
                    method2 = accessibleMethod;
                }
            }
            if (method2 != null) {
                MemberUtils.d(method2);
            }
            return method2;
        }
    }

    public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfaces) {
        Validate.notNull(method);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(method);
        Class[] parameterTypes = method.getParameterTypes();
        Class<?> declaringClass = method.getDeclaringClass();
        Iterator<Class<?>> it = ClassUtils.hierarchy(declaringClass, interfaces).iterator();
        it.next();
        while (it.hasNext()) {
            Method matchingAccessibleMethod = getMatchingAccessibleMethod(it.next(), method.getName(), parameterTypes);
            if (matchingAccessibleMethod != null) {
                if (!Arrays.equals(matchingAccessibleMethod.getParameterTypes(), parameterTypes)) {
                    Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(declaringClass, matchingAccessibleMethod.getDeclaringClass());
                    int i11 = 0;
                    while (true) {
                        if (i11 >= parameterTypes.length) {
                            linkedHashSet.add(matchingAccessibleMethod);
                            break;
                        } else if (!TypeUtils.equals(TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i11]), TypeUtils.unrollVariables(typeArguments, matchingAccessibleMethod.getGenericParameterTypes()[i11]))) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                } else {
                    linkedHashSet.add(matchingAccessibleMethod);
                }
            }
        }
        return linkedHashSet;
    }

    public static Object invokeExactMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactMethod(obj, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod != null) {
            return accessibleMethod.invoke((Object) null, nullToEmpty);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeStaticMethod(cls, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Method getAccessibleMethod(Method method) {
        if (!MemberUtils.b(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name2 = method.getName();
        Class[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name2, parameterTypes);
        return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(declaringClass, name2, parameterTypes) : accessibleMethodFromInterfaceNest;
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, nullToEmpty);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class[] nullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Object[] nullToEmpty2 = ArrayUtils.nullToEmpty(objArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, nullToEmpty);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(obj, nullToEmpty2);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke((Object) null, nullToEmpty);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactStaticMethod(cls, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }
}
