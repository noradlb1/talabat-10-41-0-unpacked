package org.mockito.internal.util;

import java.lang.reflect.Method;
import org.mockito.creation.instance.InstantiationException;

public final class JavaEightUtil {
    private static Object emptyDuration;
    private static Object emptyOptional;
    private static Object emptyOptionalDouble;
    private static Object emptyOptionalInt;
    private static Object emptyOptionalLong;
    private static Object emptyPeriod;

    private JavaEightUtil() {
    }

    public static Object emptyDoubleStream() {
        return invokeNullaryFactoryMethod("java.util.stream.DoubleStream", "empty");
    }

    public static Object emptyDuration() {
        Object obj = emptyDuration;
        if (obj != null) {
            return obj;
        }
        Object staticFieldValue = getStaticFieldValue("java.time.Duration", "ZERO");
        emptyDuration = staticFieldValue;
        return staticFieldValue;
    }

    public static Object emptyIntStream() {
        return invokeNullaryFactoryMethod("java.util.stream.IntStream", "empty");
    }

    public static Object emptyLongStream() {
        return invokeNullaryFactoryMethod("java.util.stream.LongStream", "empty");
    }

    public static Object emptyOptional() {
        Object obj = emptyOptional;
        if (obj != null) {
            return obj;
        }
        Object invokeNullaryFactoryMethod = invokeNullaryFactoryMethod("java.util.Optional", "empty");
        emptyOptional = invokeNullaryFactoryMethod;
        return invokeNullaryFactoryMethod;
    }

    public static Object emptyOptionalDouble() {
        Object obj = emptyOptionalDouble;
        if (obj != null) {
            return obj;
        }
        Object invokeNullaryFactoryMethod = invokeNullaryFactoryMethod("java.util.OptionalDouble", "empty");
        emptyOptionalDouble = invokeNullaryFactoryMethod;
        return invokeNullaryFactoryMethod;
    }

    public static Object emptyOptionalInt() {
        Object obj = emptyOptionalInt;
        if (obj != null) {
            return obj;
        }
        Object invokeNullaryFactoryMethod = invokeNullaryFactoryMethod("java.util.OptionalInt", "empty");
        emptyOptionalInt = invokeNullaryFactoryMethod;
        return invokeNullaryFactoryMethod;
    }

    public static Object emptyOptionalLong() {
        Object obj = emptyOptionalLong;
        if (obj != null) {
            return obj;
        }
        Object invokeNullaryFactoryMethod = invokeNullaryFactoryMethod("java.util.OptionalLong", "empty");
        emptyOptionalLong = invokeNullaryFactoryMethod;
        return invokeNullaryFactoryMethod;
    }

    public static Object emptyPeriod() {
        Object obj = emptyPeriod;
        if (obj != null) {
            return obj;
        }
        Object staticFieldValue = getStaticFieldValue("java.time.Period", "ZERO");
        emptyPeriod = staticFieldValue;
        return staticFieldValue;
    }

    public static Object emptyStream() {
        return invokeNullaryFactoryMethod("java.util.stream.Stream", "empty");
    }

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new InstantiationException(String.format("Could not find %s: %s", new Object[]{str, e11}), e11);
        }
    }

    private static Method getMethod(String str, String str2, Class<?>... clsArr) {
        try {
            return getClass(str).getMethod(str2, clsArr);
        } catch (Exception e11) {
            throw new InstantiationException(String.format("Could not find %s#%s(): %s", new Object[]{str, str2, e11}), e11);
        }
    }

    private static Object getStaticFieldValue(String str, String str2) {
        try {
            return getClass(str).getField(str2).get((Object) null);
        } catch (Exception e11) {
            throw new InstantiationException(String.format("Could not get %s#%s(): %s", new Object[]{str, str2, e11}), e11);
        }
    }

    private static Object invokeNullaryFactoryMethod(String str, String str2) {
        try {
            return getMethod(str, str2, new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e11) {
            throw new InstantiationException(String.format("Could not create %s#%s(): %s", new Object[]{str, str2, e11}), e11);
        }
    }
}
