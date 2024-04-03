package org.objenesis.instantiator.gcj;

import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.SerializationInstantiatorHelper;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(Typology.SERIALIZATION)
public class GCJSerializationInstantiator<T> extends GCJInstantiatorBase<T> {
    private final Class<? super T> superType;

    public GCJSerializationInstantiator(Class<T> cls) {
        super(cls);
        this.superType = SerializationInstantiatorHelper.getNonSerializableSuperClass(cls);
    }

    public T newInstance() {
        try {
            Class<T> cls = this.f63301a;
            return cls.cast(GCJInstantiatorBase.f63299b.invoke(GCJInstantiatorBase.f63300c, new Object[]{cls, this.superType}));
        } catch (Exception e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }
}
