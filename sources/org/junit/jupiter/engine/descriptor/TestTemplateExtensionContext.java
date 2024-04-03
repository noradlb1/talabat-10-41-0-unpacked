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

final class TestTemplateExtensionContext extends AbstractExtensionContext<TestTemplateTestDescriptor> {
    private final TestInstances testInstances;

    public TestTemplateExtensionContext(ExtensionContext extensionContext, EngineExecutionListener engineExecutionListener, TestTemplateTestDescriptor testTemplateTestDescriptor, JupiterConfiguration jupiterConfiguration, TestInstances testInstances2, ExecutableInvoker executableInvoker) {
        super(extensionContext, engineExecutionListener, testTemplateTestDescriptor, jupiterConfiguration, executableInvoker);
        this.testInstances = testInstances2;
    }

    public Node.ExecutionMode a() {
        return ((TestTemplateTestDescriptor) b()).getExecutionMode();
    }

    public Optional<AnnotatedElement> getElement() {
        return Optional.of(((TestTemplateTestDescriptor) b()).getTestMethod());
    }

    public Optional<Throwable> getExecutionException() {
        return Optional.empty();
    }

    public Optional<Class<?>> getTestClass() {
        return Optional.of(((TestTemplateTestDescriptor) b()).getTestClass());
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
        return Optional.of(((TestTemplateTestDescriptor) b()).getTestMethod());
    }
}
