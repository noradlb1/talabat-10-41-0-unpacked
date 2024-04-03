package org.mockito.internal.creation.proxy;

import java.io.Serializable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.mockito.internal.SuppressSignatureCheck;
import org.mockito.internal.invocation.RealMethod;

@SuppressSignatureCheck
class MethodHandleProxy implements ProxyRealMethod {
    private final MethodHandles.Lookup lookup = MethodHandles.lookup();

    @SuppressSignatureCheck
    public static class LegacyVersion implements ProxyRealMethod {
        private final Constructor<MethodHandles.Lookup> constructor;

        public LegacyVersion() throws Throwable {
            try {
                Class.forName("java.lang.Module");
                throw new RuntimeException("Must not be used when modules are available");
            } catch (ClassNotFoundException unused) {
                Constructor<MethodHandles.Lookup> declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class});
                this.constructor = declaredConstructor;
                declaredConstructor.setAccessible(true);
            }
        }

        public RealMethod resolve(Object obj, Method method, Object[] objArr) {
            try {
                return new MethodHandleRealMethod(this.constructor.newInstance(new Object[]{method.getDeclaringClass()}).in(method.getDeclaringClass()).unreflectSpecial(method, method.getDeclaringClass()).bindTo(obj), objArr);
            } catch (Throwable unused) {
                return RealMethod.IsIllegal.INSTANCE;
            }
        }
    }

    @SuppressSignatureCheck
    public static class MethodHandleRealMethod implements RealMethod, Serializable {
        private static final long serialVersionUID = -1;
        private final Object[] args;
        private final MethodHandle handle;

        public Object invoke() throws Throwable {
            return this.handle.invokeWithArguments(this.args);
        }

        public boolean isInvokable() {
            return true;
        }

        private MethodHandleRealMethod(MethodHandle methodHandle, Object[] objArr) {
            this.handle = methodHandle;
            this.args = objArr;
        }
    }

    public RealMethod resolve(Object obj, Method method, Object[] objArr) {
        try {
            return new MethodHandleRealMethod(this.lookup.findSpecial(method.getDeclaringClass(), method.getName(), MethodType.methodType(method.getReturnType(), method.getParameterTypes()), method.getDeclaringClass()).bindTo(obj), objArr);
        } catch (Throwable unused) {
            return RealMethod.IsIllegal.INSTANCE;
        }
    }
}
