package org.objenesis.instantiator.basic;

import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(Typology.NOT_COMPLIANT)
public class ConstructorInstantiator<T> implements ObjectInstantiator<T> {

    /* renamed from: a  reason: collision with root package name */
    public Constructor<T> f63298a;

    public ConstructorInstantiator(Class<T> cls) {
        try {
            this.f63298a = cls.getDeclaredConstructor((Class[]) null);
        } catch (Exception e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }

    public T newInstance() {
        try {
            return this.f63298a.newInstance((Object[]) null);
        } catch (Exception e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }
}
