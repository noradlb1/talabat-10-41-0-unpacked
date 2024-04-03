package org.junit.jupiter.engine.descriptor;

import d30.e1;
import d30.z;
import j$.util.Optional;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExecutableInvoker;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.platform.engine.EngineExecutionListener;
import org.junit.platform.engine.support.hierarchical.Node;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

final class MethodExtensionContext extends AbstractExtensionContext<TestMethodTestDescriptor> {
    private TestInstances testInstances;
    private final ThrowableCollector throwableCollector;

    public MethodExtensionContext(ExtensionContext extensionContext, EngineExecutionListener engineExecutionListener, TestMethodTestDescriptor testMethodTestDescriptor, JupiterConfiguration jupiterConfiguration, ThrowableCollector throwableCollector2, ExecutableInvoker executableInvoker) {
        super(extensionContext, engineExecutionListener, testMethodTestDescriptor, jupiterConfiguration, executableInvoker);
        this.throwableCollector = throwableCollector2;
    }

    public Node.ExecutionMode a() {
        return ((TestMethodTestDescriptor) b()).getExecutionMode();
    }

    public void c(TestInstances testInstances2) {
        this.testInstances = testInstances2;
    }

    public Optional<AnnotatedElement> getElement() {
        return Optional.of(((TestMethodTestDescriptor) b()).getTestMethod());
    }

    public Optional<Throwable> getExecutionException() {
        return Optional.ofNullable(this.throwableCollector.getThrowable());
    }

    public Optional<Class<?>> getTestClass() {
        return Optional.of(((TestMethodTestDescriptor) b()).getTestClass());
    }

    public Optional<Object> getTestInstance() {
        return getTestInstances().map(new z());
    }

    public Optional<TestInstance.Lifecycle> getTestInstanceLifecycle() {
        return getParent().flatMap(new e1());
    }

    public Optional<TestInstances> getTestInstances() {
        return Optional.ofNullable(this.testInstances);
    }

    public Optional<Method> getTestMethod() {
        return Optional.of(((TestMethodTestDescriptor) b()).getTestMethod());
    }
}
