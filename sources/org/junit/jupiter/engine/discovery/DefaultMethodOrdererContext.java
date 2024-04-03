package org.junit.jupiter.engine.discovery;

import j$.util.Optional;
import java.util.List;
import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrdererContext;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.platform.commons.util.ToStringBuilder;

class DefaultMethodOrdererContext implements MethodOrdererContext {
    private final JupiterConfiguration configuration;
    private final List<? extends MethodDescriptor> methodDescriptors;
    private final Class<?> testClass;

    public DefaultMethodOrdererContext(Class<?> cls, List<? extends MethodDescriptor> list, JupiterConfiguration jupiterConfiguration) {
        this.testClass = cls;
        this.methodDescriptors = list;
        this.configuration = jupiterConfiguration;
    }

    public Optional<String> getConfigurationParameter(String str) {
        return this.configuration.getRawConfigurationParameter(str);
    }

    public List<? extends MethodDescriptor> getMethodDescriptors() {
        return this.methodDescriptors;
    }

    public final Class<?> getTestClass() {
        return this.testClass;
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("testClass", this.testClass.getName()).toString();
    }
}
