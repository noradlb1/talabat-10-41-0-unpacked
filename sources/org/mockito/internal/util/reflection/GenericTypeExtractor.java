package org.mockito.internal.util.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class GenericTypeExtractor {
    private GenericTypeExtractor() {
    }

    private static Class<?> extractGeneric(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length <= 0) {
            return Object.class;
        }
        Type type2 = actualTypeArguments[0];
        if (type2 instanceof Class) {
            return (Class) type2;
        }
        return Object.class;
    }

    private static Type findGenericInterface(Class<?> cls, Class<?> cls2) {
        for (int i11 = 0; i11 < cls.getInterfaces().length; i11++) {
            Class<?> cls3 = cls.getInterfaces()[i11];
            if (cls3 == cls2) {
                return cls.getGenericInterfaces()[i11];
            }
            Type findGenericInterface = findGenericInterface(cls3, cls2);
            if (findGenericInterface != null) {
                return findGenericInterface;
            }
        }
        return null;
    }

    public static Class<?> genericTypeOf(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        while (true) {
            Class<Object> cls4 = Object.class;
            Class<? super Object> cls5 = cls;
            if (cls5 == cls4) {
                return cls4;
            }
            if (cls5.getSuperclass() == cls2) {
                return extractGeneric(cls5.getGenericSuperclass());
            }
            Type findGenericInterface = findGenericInterface(cls5, cls3);
            if (findGenericInterface != null) {
                return extractGeneric(findGenericInterface);
            }
            cls5 = cls5.getSuperclass();
        }
    }
}
