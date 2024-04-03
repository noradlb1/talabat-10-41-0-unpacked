package org.mockito.internal.junit;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public class DefaultTestFinishedEvent implements TestFinishedEvent {
    private final Object testClassInstance;
    private final Throwable testFailure;
    private final String testMethodName;

    public DefaultTestFinishedEvent(Object obj, String str, Throwable th2) {
        this.testClassInstance = obj;
        this.testMethodName = str;
        this.testFailure = th2;
    }

    public Throwable getFailure() {
        return this.testFailure;
    }

    public String getTestName() {
        return this.testClassInstance.getClass().getSimpleName() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + this.testMethodName;
    }
}
