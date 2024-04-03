package org.objenesis.instantiator.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public abstract class DelegatingToExoticInstantiator<T> implements ObjectInstantiator<T> {
    private final ObjectInstantiator<T> wrapped;

    public DelegatingToExoticInstantiator(String str, Class<T> cls) {
        this.wrapped = instantiator(str, cls, instantiatorConstructor(str, instantiatorClass(str)));
    }

    private ObjectInstantiator<T> instantiator(String str, Class<T> cls, Constructor<ObjectInstantiator<T>> constructor) {
        try {
            return constructor.newInstance(new Object[]{cls});
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            throw new RuntimeException("Failed to call constructor of " + str, e11);
        }
    }

    private Class<ObjectInstantiator<T>> instantiatorClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new ObjenesisException(getClass().getSimpleName() + " now requires objenesis-exotic to be in the classpath", e11);
        }
    }

    private Constructor<ObjectInstantiator<T>> instantiatorConstructor(String str, Class<ObjectInstantiator<T>> cls) {
        try {
            return cls.getConstructor(new Class[]{Class.class});
        } catch (NoSuchMethodException e11) {
            throw new ObjenesisException("Try to find constructor taking a Class<T> in parameter on " + str + " but can't find it", e11);
        }
    }

    public T newInstance() {
        return this.wrapped.newInstance();
    }
}
