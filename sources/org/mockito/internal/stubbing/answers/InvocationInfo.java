package org.mockito.internal.stubbing.answers;

import java.lang.reflect.Method;
import org.mockito.internal.invocation.AbstractAwareMethod;
import org.mockito.internal.util.MockUtil;
import org.mockito.internal.util.Primitives;
import org.mockito.internal.util.reflection.GenericMetadataSupport;
import org.mockito.invocation.InvocationOnMock;

public class InvocationInfo implements AbstractAwareMethod {
    private final InvocationOnMock invocation;
    private final Method method;

    public InvocationInfo(InvocationOnMock invocationOnMock) {
        this.method = invocationOnMock.getMethod();
        this.invocation = invocationOnMock;
    }

    public Method getMethod() {
        return this.method;
    }

    public String getMethodName() {
        return this.method.getName();
    }

    public boolean isAbstract() {
        return (this.method.getModifiers() & 1024) != 0;
    }

    public boolean isDeclaredOnInterface() {
        return this.method.getDeclaringClass().isInterface();
    }

    public boolean isValidException(Throwable th2) {
        Class[] exceptionTypes = this.method.getExceptionTypes();
        Class<?> cls = th2.getClass();
        for (Class isAssignableFrom : exceptionTypes) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidReturnType(Class<?> cls) {
        if (!this.method.getReturnType().isPrimitive() && !cls.isPrimitive()) {
            return this.method.getReturnType().isAssignableFrom(cls);
        }
        if (Primitives.primitiveTypeOf(cls) == Primitives.primitiveTypeOf(this.method.getReturnType())) {
            return true;
        }
        return false;
    }

    public boolean isVoid() {
        Class<?> rawType = GenericMetadataSupport.inferFrom(MockUtil.getMockHandler(this.invocation.getMock()).getMockSettings().getTypeToMock()).resolveGenericReturnType(this.method).rawType();
        if (rawType == Void.TYPE || rawType == Void.class) {
            return true;
        }
        return false;
    }

    public String printMethodReturnType() {
        return this.method.getReturnType().getSimpleName();
    }

    public boolean returnsPrimitive() {
        return this.method.getReturnType().isPrimitive();
    }
}
