package org.objenesis.instantiator.sun;

import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(Typology.STANDARD)
public class SunReflectionFactoryInstantiator<T> implements ObjectInstantiator<T> {
    private final Constructor<T> mungedConstructor;

    public SunReflectionFactoryInstantiator(Class<T> cls) {
        Constructor<T> newConstructorForSerialization = SunReflectionFactoryHelper.newConstructorForSerialization(cls, getJavaLangObjectConstructor());
        this.mungedConstructor = newConstructorForSerialization;
        newConstructorForSerialization.setAccessible(true);
    }

    private static Constructor<Object> getJavaLangObjectConstructor() {
        try {
            return Object.class.getConstructor((Class[]) null);
        } catch (NoSuchMethodException e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }

    public T newInstance() {
        try {
            return this.mungedConstructor.newInstance((Object[]) null);
        } catch (Exception e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }
}
