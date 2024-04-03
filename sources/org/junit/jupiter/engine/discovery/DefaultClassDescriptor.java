package org.junit.jupiter.engine.discovery;

import org.junit.jupiter.api.ClassDescriptor;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.platform.commons.util.ToStringBuilder;

class DefaultClassDescriptor extends AbstractAnnotatedDescriptorWrapper<Class<?>> implements ClassDescriptor {
    public DefaultClassDescriptor(ClassBasedTestDescriptor classBasedTestDescriptor) {
        super(classBasedTestDescriptor, classBasedTestDescriptor.getTestClass());
    }

    public final Class<?> getTestClass() {
        return (Class) a();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("class", getTestClass().toGenericString()).toString();
    }
}
