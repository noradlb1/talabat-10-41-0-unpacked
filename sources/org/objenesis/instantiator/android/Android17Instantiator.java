package org.objenesis.instantiator.android;

import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(Typology.STANDARD)
public class Android17Instantiator<T> implements ObjectInstantiator<T> {
    private final Method newInstanceMethod = getNewInstanceMethod();
    private final Integer objectConstructorId = findConstructorIdForJavaLangObjectConstructor();
    private final Class<T> type;

    public Android17Instantiator(Class<T> cls) {
        this.type = cls;
    }

    private static Integer findConstructorIdForJavaLangObjectConstructor() {
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
            declaredMethod.setAccessible(true);
            return (Integer) declaredMethod.invoke((Object) null, new Object[]{Object.class});
        } catch (IllegalAccessException | NoSuchMethodException | RuntimeException | InvocationTargetException e11) {
            throw new ObjenesisException(e11);
        }
    }

    private static Method getNewInstanceMethod() {
        Class<ObjectStreamClass> cls = ObjectStreamClass.class;
        try {
            Method declaredMethod = cls.getDeclaredMethod(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME, new Class[]{Class.class, Integer.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException | RuntimeException e11) {
            throw new ObjenesisException(e11);
        }
    }

    public T newInstance() {
        try {
            Class<T> cls = this.type;
            return cls.cast(this.newInstanceMethod.invoke((Object) null, new Object[]{cls, this.objectConstructorId}));
        } catch (Exception e11) {
            throw new ObjenesisException((Throwable) e11);
        }
    }
}
