package org.junit.jupiter.engine.discovery;

import j$.util.Optional;
import java.util.List;
import org.junit.jupiter.api.ClassDescriptor;
import org.junit.jupiter.api.ClassOrdererContext;
import org.junit.jupiter.engine.config.JupiterConfiguration;

class DefaultClassOrdererContext implements ClassOrdererContext {
    private final List<? extends ClassDescriptor> classDescriptors;
    private final JupiterConfiguration configuration;

    public DefaultClassOrdererContext(List<? extends ClassDescriptor> list, JupiterConfiguration jupiterConfiguration) {
        this.classDescriptors = list;
        this.configuration = jupiterConfiguration;
    }

    public List<? extends ClassDescriptor> getClassDescriptors() {
        return this.classDescriptors;
    }

    public Optional<String> getConfigurationParameter(String str) {
        return this.configuration.getRawConfigurationParameter(str);
    }
}
