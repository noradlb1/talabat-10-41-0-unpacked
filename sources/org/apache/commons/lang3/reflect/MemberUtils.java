package org.apache.commons.lang3.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

abstract class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    public static int a(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float totalTransformationCost = getTotalTransformationCost(clsArr3, clsArr);
        float totalTransformationCost2 = getTotalTransformationCost(clsArr3, clsArr2);
        if (totalTransformationCost < totalTransformationCost2) {
            return -1;
        }
        if (totalTransformationCost2 < totalTransformationCost) {
            return 1;
        }
        return 0;
    }

    public static boolean b(Member member) {
        return member != null && Modifier.isPublic(member.getModifiers()) && !member.isSynthetic();
    }

    public static boolean c(int i11) {
        return (i11 & 7) == 0;
    }

    public static boolean d(AccessibleObject accessibleObject) {
        if (accessibleObject != null && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && c(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (SecurityException unused) {
                }
            }
        }
        return false;
    }

    private static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitivePromotionCost(cls, cls2);
        }
        float f11 = 0.0f;
        Class<? super Object> cls3 = cls;
        while (true) {
            if (cls3 != null && !cls2.equals(cls3)) {
                if (cls2.isInterface() && ClassUtils.isAssignable(cls3, cls2)) {
                    f11 += 0.25f;
                    break;
                }
                f11 += 1.0f;
                cls3 = cls3.getSuperclass();
            } else {
                break;
            }
        }
        if (cls3 == null) {
            return f11 + 1.5f;
        }
        return f11;
    }

    private static float getPrimitivePromotionCost(Class<?> cls, Class<?> cls2) {
        float f11;
        if (!cls.isPrimitive()) {
            cls = ClassUtils.wrapperToPrimitive(cls);
            f11 = 0.1f;
        } else {
            f11 = 0.0f;
        }
        int i11 = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = ORDERED_PRIMITIVE_TYPES;
            if (i11 >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i11]) {
                f11 += 0.1f;
                if (i11 < clsArr.length - 1) {
                    cls = clsArr[i11 + 1];
                }
            }
            i11++;
        }
        return f11;
    }

    private static float getTotalTransformationCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f11 = 0.0f;
        for (int i11 = 0; i11 < clsArr.length; i11++) {
            f11 += getObjectTransformationCost(clsArr[i11], clsArr2[i11]);
        }
        return f11;
    }
}
