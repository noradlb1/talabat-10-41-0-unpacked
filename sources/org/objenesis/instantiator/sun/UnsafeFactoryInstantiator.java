package org.objenesis.instantiator.sun;

import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;
import org.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

@Instantiator(Typology.STANDARD)
public class UnsafeFactoryInstantiator<T> implements ObjectInstantiator<T> {
    private final Class<T> type;
    private final Unsafe unsafe = UnsafeUtils.getUnsafe();

    public UnsafeFactoryInstantiator(Class<T> cls) {
        this.type = cls;
    }

    public T newInstance() {
        try {
            Class<T> cls = this.type;
            return cls.cast(this.unsafe.allocateInstance(cls));
        } catch (InstantiationException e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }
}
