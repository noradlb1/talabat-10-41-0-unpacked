package org.mockito.internal.creation.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.invocation.RealMethod;
import org.mockito.internal.invocation.SerializableMethod;
import org.mockito.internal.util.Platform;
import org.mockito.internal.util.StringUtil;

class InvokeDefaultProxy implements ProxyRealMethod {
    /* access modifiers changed from: private */
    public final Method invokeDefault = InvocationHandler.class.getMethod("invokeDefault", new Class[]{Object.class, Method.class, Object[].class});

    public class InvokeDefaultRealMethod implements RealMethod, Serializable {
        private static final long serialVersionUID = -1;
        private final Object[] args;
        private final Object proxy;
        private final SerializableMethod serializableMethod;

        public Object invoke() throws Throwable {
            try {
                return InvokeDefaultProxy.this.invokeDefault.invoke((Object) null, new Object[]{this.proxy, this.serializableMethod.getJavaMethod(), this.args});
            } catch (InvocationTargetException e11) {
                throw e11.getTargetException();
            } catch (IllegalAccessException | IllegalArgumentException e12) {
                throw new MockitoException(StringUtil.join("Failed to access default method or invoked method with illegal arguments", "", "Method " + this.serializableMethod.getJavaMethod() + " could not be delegated, this is not supposed to happen", Platform.describe()), e12);
            }
        }

        public boolean isInvokable() {
            return true;
        }

        private InvokeDefaultRealMethod(Object obj, Method method, Object[] objArr) {
            this.proxy = obj;
            this.serializableMethod = new SerializableMethod(method);
            this.args = objArr;
        }
    }

    public RealMethod resolve(Object obj, Method method, Object[] objArr) {
        return new InvokeDefaultRealMethod(obj, method, objArr);
    }
}
