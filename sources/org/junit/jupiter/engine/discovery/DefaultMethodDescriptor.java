package org.junit.jupiter.engine.discovery;

import java.lang.reflect.Method;
import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.engine.descriptor.MethodBasedTestDescriptor;
import org.junit.platform.commons.util.ToStringBuilder;

class DefaultMethodDescriptor extends AbstractAnnotatedDescriptorWrapper<Method> implements MethodDescriptor {
    public DefaultMethodDescriptor(MethodBasedTestDescriptor methodBasedTestDescriptor) {
        super(methodBasedTestDescriptor, methodBasedTestDescriptor.getTestMethod());
    }

    public final Method getMethod() {
        return (Method) a();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("method", getMethod().toGenericString()).toString();
    }
}
