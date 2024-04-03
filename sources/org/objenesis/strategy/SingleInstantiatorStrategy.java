package org.objenesis.strategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class SingleInstantiatorStrategy implements InstantiatorStrategy {
    private final Constructor<?> constructor;

    public <T extends ObjectInstantiator<?>> SingleInstantiatorStrategy(Class<T> cls) {
        try {
            this.constructor = cls.getConstructor(new Class[]{Class.class});
        } catch (NoSuchMethodException e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }

    public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> cls) {
        try {
            return (ObjectInstantiator) this.constructor.newInstance(new Object[]{cls});
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            throw new ObjenesisException(e11);
        }
    }
}
