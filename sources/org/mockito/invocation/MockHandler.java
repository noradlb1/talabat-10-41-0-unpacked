package org.mockito.invocation;

import java.io.Serializable;
import org.mockito.mock.MockCreationSettings;

public interface MockHandler<T> extends Serializable {
    InvocationContainer getInvocationContainer();

    MockCreationSettings<T> getMockSettings();

    Object handle(Invocation invocation) throws Throwable;
}
