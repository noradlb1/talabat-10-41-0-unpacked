package org.objenesis.instantiator.android;

import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(Typology.SERIALIZATION)
public class AndroidSerializationInstantiator<T> implements ObjectInstantiator<T> {
    private final Method newInstanceMethod = getNewInstanceMethod();
    private final ObjectStreamClass objectStreamClass;
    private final Class<T> type;

    public AndroidSerializationInstantiator(Class<T> cls) {
        this.type = cls;
        try {
            try {
                this.objectStreamClass = (ObjectStreamClass) ObjectStreamClass.class.getMethod("lookupAny", new Class[]{Class.class}).invoke((Object) null, new Object[]{cls});
            } catch (IllegalAccessException | InvocationTargetException e11) {
                throw new ObjenesisException(e11);
            }
        } catch (NoSuchMethodException e12) {
            throw new ObjenesisException((Throwable) e12);
        }
    }

    private static Method getNewInstanceMethod() {
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, new Class[]{Class.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException | RuntimeException e11) {
            throw new ObjenesisException(e11);
        }
    }

    public T newInstance() {
        try {
            Class<T> cls = this.type;
            return cls.cast(this.newInstanceMethod.invoke(this.objectStreamClass, new Object[]{cls}));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
            throw new ObjenesisException(e11);
        }
    }
}
