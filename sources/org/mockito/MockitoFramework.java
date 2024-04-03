package org.mockito;

import org.mockito.exceptions.misusing.RedundantListenerException;
import org.mockito.invocation.InvocationFactory;
import org.mockito.listeners.MockitoListener;
import org.mockito.plugins.MockitoPlugins;

@NotExtensible
public interface MockitoFramework {
    MockitoFramework addListener(MockitoListener mockitoListener) throws RedundantListenerException;

    void clearInlineMock(Object obj);

    void clearInlineMocks();

    InvocationFactory getInvocationFactory();

    MockitoPlugins getPlugins();

    MockitoFramework removeListener(MockitoListener mockitoListener);
}
