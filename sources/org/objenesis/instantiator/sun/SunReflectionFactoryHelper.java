package org.objenesis.instantiator.sun;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.objenesis.ObjenesisException;

class SunReflectionFactoryHelper {
    private static Object createReflectionFactory(Class<?> cls) {
        try {
            return cls.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.GET_REFLECTION_FACTORY_METHOD_NAME, new Class[0]).invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e11) {
            throw new ObjenesisException(e11);
        }
    }

    private static Method getNewConstructorForSerializationMethod(Class<?> cls) {
        try {
            return cls.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_CONSTRUCTOR_FOR_SERIALIZATION_METHOD_NAME, new Class[]{Class.class, Constructor.class});
        } catch (NoSuchMethodException e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }

    private static Class<?> getReflectionFactoryClass() {
        try {
            return Class.forName("sun.reflect.ReflectionFactory");
        } catch (ClassNotFoundException e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }

    public static <T> Constructor<T> newConstructorForSerialization(Class<T> cls, Constructor<?> constructor) {
        Class<?> reflectionFactoryClass = getReflectionFactoryClass();
        Object createReflectionFactory = createReflectionFactory(reflectionFactoryClass);
        try {
            return (Constructor) getNewConstructorForSerializationMethod(reflectionFactoryClass).invoke(createReflectionFactory, new Object[]{cls, constructor});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
            throw new ObjenesisException(e11);
        }
    }
}
