package org.objenesis.instantiator.gcj;

import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(Typology.STANDARD)
public class GCJInstantiator<T> extends GCJInstantiatorBase<T> {
    public GCJInstantiator(Class<T> cls) {
        super(cls);
    }

    public T newInstance() {
        try {
            Class<T> cls = this.f63301a;
            return cls.cast(GCJInstantiatorBase.f63299b.invoke(GCJInstantiatorBase.f63300c, new Object[]{cls, Object.class}));
        } catch (IllegalAccessException | RuntimeException | InvocationTargetException e11) {
            throw new ObjenesisException(e11);
        }
    }
}
