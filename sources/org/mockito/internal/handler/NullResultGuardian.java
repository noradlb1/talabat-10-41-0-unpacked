package org.mockito.internal.handler;

import org.mockito.internal.util.Primitives;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.InvocationContainer;
import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;

class NullResultGuardian<T> implements MockHandler<T> {
    private final MockHandler<T> delegate;

    public NullResultGuardian(MockHandler<T> mockHandler) {
        this.delegate = mockHandler;
    }

    public InvocationContainer getInvocationContainer() {
        return this.delegate.getInvocationContainer();
    }

    public MockCreationSettings<T> getMockSettings() {
        return this.delegate.getMockSettings();
    }

    public Object handle(Invocation invocation) throws Throwable {
        Object handle = this.delegate.handle(invocation);
        Class<?> returnType = invocation.getMethod().getReturnType();
        if (handle != null || !returnType.isPrimitive()) {
            return handle;
        }
        return Primitives.defaultValue(returnType);
    }
}
