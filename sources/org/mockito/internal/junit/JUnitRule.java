package org.mockito.internal.junit;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.mockito.junit.MockitoRule;
import org.mockito.plugins.MockitoLogger;
import org.mockito.quality.Strictness;

public final class JUnitRule implements MockitoRule {
    private final JUnitSessionStore sessionStore;

    public JUnitRule(MockitoLogger mockitoLogger, Strictness strictness) {
        this.sessionStore = new JUnitSessionStore(mockitoLogger, strictness);
    }

    public Statement apply(Statement statement, FrameworkMethod frameworkMethod, Object obj) {
        JUnitSessionStore jUnitSessionStore = this.sessionStore;
        return jUnitSessionStore.d(statement, obj.getClass().getSimpleName() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + frameworkMethod.getName(), obj);
    }

    public MockitoRule silent() {
        return strictness(Strictness.LENIENT);
    }

    public MockitoRule strictness(Strictness strictness) {
        this.sessionStore.e(strictness);
        return this;
    }
}
