package org.objenesis.instantiator.perc;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(Typology.SERIALIZATION)
public class PercSerializationInstantiator<T> implements ObjectInstantiator<T> {
    private final Method newInstanceMethod;
    private final Object[] typeArgs;

    public PercSerializationInstantiator(Class<T> cls) {
        Class<Class> cls2 = Class.class;
        Class<T> cls3 = cls;
        while (Serializable.class.isAssignableFrom(cls3)) {
            cls3 = cls3.getSuperclass();
        }
        try {
            Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("noArgConstruct", new Class[]{cls2, Object.class, Class.forName("COM.newmonics.PercClassLoader.Method")});
            this.newInstanceMethod = declaredMethod;
            declaredMethod.setAccessible(true);
            Object invoke = Class.forName("COM.newmonics.PercClassLoader.PercClass").getDeclaredMethod("getPercClass", new Class[]{cls2}).invoke((Object) null, new Object[]{cls3});
            this.typeArgs = new Object[]{cls3, cls, invoke.getClass().getDeclaredMethod("findMethod", new Class[]{String.class}).invoke(invoke, new Object[]{"<init>()V"})};
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            throw new ObjenesisException(e11);
        }
    }

    public T newInstance() {
        try {
            return this.newInstanceMethod.invoke((Object) null, this.typeArgs);
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new ObjenesisException(e11);
        }
    }
}
