package org.objenesis.instantiator.android;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(Typology.STANDARD)
public class Android10Instantiator<T> implements ObjectInstantiator<T> {
    private final Method newStaticMethod = getNewStaticMethod();
    private final Class<T> type;

    public Android10Instantiator(Class<T> cls) {
        this.type = cls;
    }

    private static Method getNewStaticMethod() {
        Class<Class> cls = Class.class;
        try {
            Method declaredMethod = ObjectInputStream.class.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, new Class[]{cls, cls});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException | RuntimeException e11) {
            throw new ObjenesisException(e11);
        }
    }

    public T newInstance() {
        try {
            Class<T> cls = this.type;
            return cls.cast(this.newStaticMethod.invoke((Object) null, new Object[]{cls, Object.class}));
        } catch (Exception e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }
}
