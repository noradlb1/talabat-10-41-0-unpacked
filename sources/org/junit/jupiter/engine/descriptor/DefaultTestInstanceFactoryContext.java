package org.junit.jupiter.engine.descriptor;

import j$.util.Optional;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.platform.commons.util.ToStringBuilder;

class DefaultTestInstanceFactoryContext implements TestInstanceFactoryContext {
    private final Optional<Object> outerInstance;
    private final Class<?> testClass;

    public DefaultTestInstanceFactoryContext(Class<?> cls, Optional<Object> optional) {
        this.testClass = cls;
        this.outerInstance = optional;
    }

    public Optional<Object> getOuterInstance() {
        return this.outerInstance;
    }

    public Class<?> getTestClass() {
        return this.testClass;
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("testClass", this.testClass).append("outerInstance", this.outerInstance).toString();
    }
}
