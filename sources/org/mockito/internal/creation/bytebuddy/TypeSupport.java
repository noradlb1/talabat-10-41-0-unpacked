package org.mockito.internal.creation.bytebuddy;

import java.lang.reflect.Method;
import org.mockito.exceptions.base.MockitoException;

class TypeSupport {

    /* renamed from: a  reason: collision with root package name */
    public static final TypeSupport f63171a;
    private final Method isSealed;

    static {
        Method method;
        try {
            method = Class.class.getMethod("isSealed", new Class[0]);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        f63171a = new TypeSupport(method);
    }

    private TypeSupport(Method method) {
        this.isSealed = method;
    }

    public boolean a(Class<?> cls) {
        Method method = this.isSealed;
        if (method == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(cls, new Object[0])).booleanValue();
        } catch (Throwable th2) {
            throw new MockitoException("Failed to check if type is sealed using handle " + this.isSealed, th2);
        }
    }
}
