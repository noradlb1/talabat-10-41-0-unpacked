package org.mockito.internal.framework;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import org.mockito.MockitoFramework;
import org.mockito.internal.configuration.plugins.Plugins;
import org.mockito.internal.invocation.DefaultInvocationFactory;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.util.Checks;
import org.mockito.invocation.InvocationFactory;
import org.mockito.listeners.MockitoListener;
import org.mockito.plugins.InlineMockMaker;
import org.mockito.plugins.MockMaker;
import org.mockito.plugins.MockitoPlugins;

public class DefaultMockitoFramework implements MockitoFramework {
    private InlineMockMaker getInlineMockMaker() {
        MockMaker mockMaker = Plugins.getMockMaker();
        if (mockMaker instanceof InlineMockMaker) {
            return (InlineMockMaker) mockMaker;
        }
        return null;
    }

    public MockitoFramework addListener(MockitoListener mockitoListener) {
        Checks.checkNotNull(mockitoListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ThreadSafeMockingProgress.mockingProgress().addListener(mockitoListener);
        return this;
    }

    public void clearInlineMock(Object obj) {
        InlineMockMaker inlineMockMaker = getInlineMockMaker();
        if (inlineMockMaker != null) {
            inlineMockMaker.clearMock(obj);
        }
    }

    public void clearInlineMocks() {
        InlineMockMaker inlineMockMaker = getInlineMockMaker();
        if (inlineMockMaker != null) {
            inlineMockMaker.clearAllMocks();
        }
    }

    public InvocationFactory getInvocationFactory() {
        return new DefaultInvocationFactory();
    }

    public MockitoPlugins getPlugins() {
        return Plugins.getPlugins();
    }

    public MockitoFramework removeListener(MockitoListener mockitoListener) {
        Checks.checkNotNull(mockitoListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ThreadSafeMockingProgress.mockingProgress().removeListener(mockitoListener);
        return this;
    }
}
