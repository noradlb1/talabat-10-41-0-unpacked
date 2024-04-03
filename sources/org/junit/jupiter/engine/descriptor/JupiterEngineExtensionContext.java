package org.junit.jupiter.engine.descriptor;

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

final class JupiterEngineExtensionContext extends AbstractExtensionContext<JupiterEngineDescriptor> {
    public JupiterEngineExtensionContext(EngineExecutionListener engineExecutionListener, JupiterEngineDescriptor jupiterEngineDescriptor, JupiterConfiguration jupiterConfiguration, ExecutableInvoker executableInvoker) {
        super((ExtensionContext) null, engineExecutionListener, jupiterEngineDescriptor, jupiterConfiguration, executableInvoker);
    }

    public Node.ExecutionMode a() {
        return ((JupiterEngineDescriptor) b()).getExecutionMode();
    }

    public Optional<AnnotatedElement> getElement() {
        return Optional.empty();
    }

    public Optional<Throwable> getExecutionException() {
        return Optional.empty();
    }

    public Optional<Class<?>> getTestClass() {
        return Optional.empty();
    }

    public Optional<Object> getTestInstance() {
        return Optional.empty();
    }

    public Optional<TestInstance.Lifecycle> getTestInstanceLifecycle() {
        return Optional.empty();
    }

    public Optional<TestInstances> getTestInstances() {
        return Optional.empty();
    }

    public Optional<Method> getTestMethod() {
        return Optional.empty();
    }
}
