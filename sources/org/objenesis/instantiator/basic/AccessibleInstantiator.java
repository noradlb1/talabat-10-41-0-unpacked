package org.objenesis.instantiator.basic;

import java.lang.reflect.Constructor;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(Typology.NOT_COMPLIANT)
public class AccessibleInstantiator<T> extends ConstructorInstantiator<T> {
    public AccessibleInstantiator(Class<T> cls) {
        super(cls);
        Constructor<T> constructor = this.f63298a;
        if (constructor != null) {
            constructor.setAccessible(true);
        }
    }
}
