package org.objenesis.instantiator.gcj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public abstract class GCJInstantiatorBase<T> implements ObjectInstantiator<T> {

    /* renamed from: b  reason: collision with root package name */
    public static Method f63299b;

    /* renamed from: c  reason: collision with root package name */
    public static ObjectInputStream f63300c;

    /* renamed from: a  reason: collision with root package name */
    public final Class<T> f63301a;

    public static class DummyStream extends ObjectInputStream {
    }

    public GCJInstantiatorBase(Class<T> cls) {
        this.f63301a = cls;
        initialize();
    }

    private static void initialize() {
        Class<Class> cls = Class.class;
        if (f63299b == null) {
            try {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newObject", new Class[]{cls, cls});
                f63299b = declaredMethod;
                declaredMethod.setAccessible(true);
                f63300c = new DummyStream();
            } catch (IOException | NoSuchMethodException | RuntimeException e11) {
                throw new ObjenesisException(e11);
            }
        }
    }

    public abstract T newInstance();
}
