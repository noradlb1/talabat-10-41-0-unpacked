package org.mockito.internal.handler;

import org.mockito.invocation.MockHandler;
import org.mockito.mock.MockCreationSettings;

public final class MockHandlerFactory {
    private MockHandlerFactory() {
    }

    public static <T> MockHandler<T> createMockHandler(MockCreationSettings<T> mockCreationSettings) {
        return new InvocationNotifierHandler(new NullResultGuardian(new MockHandlerImpl(mockCreationSettings)), mockCreationSettings);
    }
}
