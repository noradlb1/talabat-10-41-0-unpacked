package org.mockito.internal.util;

import java.util.HashMap;
import java.util.Map;

public final class Primitives {
    private static final Map<Class<?>, Object> PRIMITIVE_OR_WRAPPER_DEFAULT_VALUES;
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TYPES;

    static {
        HashMap hashMap = new HashMap();
        PRIMITIVE_TYPES = hashMap;
        HashMap hashMap2 = new HashMap();
        PRIMITIVE_OR_WRAPPER_DEFAULT_VALUES = hashMap2;
        Class cls = Boolean.TYPE;
        Class<Boolean> cls2 = Boolean.class;
        hashMap.put(cls2, cls);
        Class<Character> cls3 = Character.class;
        hashMap.put(cls3, Character.TYPE);
        Class<Byte> cls4 = Byte.class;
        hashMap.put(cls4, Byte.TYPE);
        Class<Short> cls5 = Short.class;
        hashMap.put(cls5, Short.TYPE);
        Class cls6 = Integer.TYPE;
        Class<Integer> cls7 = Integer.class;
        hashMap.put(cls7, cls6);
        Class cls8 = Long.TYPE;
        Class<Long> cls9 = Long.class;
        hashMap.put(cls9, cls8);
        Class cls10 = Float.TYPE;
        Class<Float> cls11 = Float.class;
        hashMap.put(cls11, cls10);
        Class<Double> cls12 = Double.class;
        hashMap.put(cls12, Double.TYPE);
        Boolean bool = Boolean.FALSE;
        hashMap2.put(cls2, bool);
        hashMap2.put(cls3, 0);
        hashMap2.put(cls4, (byte) 0);
        hashMap2.put(cls5, (short) 0);
        hashMap2.put(cls7, 0);
        hashMap2.put(cls9, 0L);
        Float valueOf = Float.valueOf(0.0f);
        hashMap2.put(cls11, valueOf);
        Double valueOf2 = Double.valueOf(0.0d);
        hashMap2.put(cls12, valueOf2);
        hashMap2.put(cls, bool);
        hashMap2.put(Character.TYPE, 0);
        hashMap2.put(Byte.TYPE, (byte) 0);
        hashMap2.put(Short.TYPE, (short) 0);
        hashMap2.put(cls6, 0);
        hashMap2.put(cls8, 0L);
        hashMap2.put(cls10, valueOf);
        hashMap2.put(Double.TYPE, valueOf2);
    }

    private Primitives() {
    }

    public static <T> T defaultValue(Class<T> cls) {
        return PRIMITIVE_OR_WRAPPER_DEFAULT_VALUES.get(cls);
    }

    public static boolean isAssignableFromWrapper(Class<?> cls, Class<?> cls2) {
        if (!isPrimitiveOrWrapper(cls) || !isPrimitiveOrWrapper(cls2)) {
            return false;
        }
        return primitiveTypeOf(cls).isAssignableFrom(primitiveTypeOf(cls2));
    }

    public static boolean isPrimitiveOrWrapper(Class<?> cls) {
        return PRIMITIVE_OR_WRAPPER_DEFAULT_VALUES.containsKey(cls);
    }

    public static <T> Class<T> primitiveTypeOf(Class<T> cls) {
        if (cls.isPrimitive()) {
            return cls;
        }
        return PRIMITIVE_TYPES.get(cls);
    }
}
