package org.junit.jupiter.engine.descriptor;

import d30.a1;
import d30.b1;
import d30.c1;
import d30.d1;
import j$.lang.Iterable;
import j$.util.Optional;
import j$.util.function.Consumer;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.ClassUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestTag;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.engine.support.hierarchical.ExclusiveResource;
import org.junit.platform.engine.support.hierarchical.Node;
import x20.n;

@API(since = "5.0", status = API.Status.INTERNAL)
public abstract class MethodBasedTestDescriptor extends JupiterTestDescriptor {
    private static final Logger logger = LoggerFactory.getLogger(MethodBasedTestDescriptor.class);
    private final Set<TestTag> tags;
    private final Class<?> testClass;
    private final Method testMethod;

    public MethodBasedTestDescriptor(UniqueId uniqueId, Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration) {
        this(uniqueId, DisplayNameUtils.i(cls, method, jupiterConfiguration), cls, method, jupiterConfiguration);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$invokeTestWatchers$2(TestWatcher testWatcher, ExtensionContext extensionContext) {
        return String.format("Failed to invoke TestWatcher [%s] for method [%s] with display name [%s]", new Object[]{testWatcher.getClass().getName(), ReflectionUtils.getFullyQualifiedMethodName(extensionContext.getRequiredTestClass(), extensionContext.getRequiredTestMethod()), getDisplayName()});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeTestWatchers$3(Consumer consumer, JupiterEngineExecutionContext jupiterEngineExecutionContext, TestWatcher testWatcher) {
        try {
            consumer.accept(testWatcher);
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            logger.warn(th2, new b1(this, testWatcher, jupiterEngineExecutionContext.getExtensionContext()));
        }
    }

    public Set<ExclusiveResource> getExclusiveResources() {
        return g(getTestMethod());
    }

    public String getLegacyReportingName() {
        return String.format("%s(%s)", new Object[]{this.testMethod.getName(), ClassUtils.nullSafeToString(new n(), this.testMethod.getParameterTypes())});
    }

    public final Set<TestTag> getTags() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.tags);
        getParent().ifPresent(new c1(linkedHashSet));
        return linkedHashSet;
    }

    public final Class<?> getTestClass() {
        return this.testClass;
    }

    public final Method getTestMethod() {
        return this.testMethod;
    }

    public Optional<Node.ExecutionMode> i() {
        return h(getTestMethod());
    }

    public void p(JupiterEngineExecutionContext jupiterEngineExecutionContext, boolean z11, Consumer<TestWatcher> consumer) {
        List<E> list;
        MutableExtensionRegistry extensionRegistry = jupiterEngineExecutionContext.getExtensionRegistry();
        Class<TestWatcher> cls = TestWatcher.class;
        if (z11) {
            list = extensionRegistry.getReversedExtensions(cls);
        } else {
            list = extensionRegistry.getExtensions(cls);
        }
        Iterable.EL.forEach(list, new d1(this, consumer, jupiterEngineExecutionContext));
    }

    public MethodBasedTestDescriptor(UniqueId uniqueId, String str, Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, str, MethodSource.from(cls, method), jupiterConfiguration);
        this.testClass = (Class) Preconditions.notNull(cls, "Class must not be null");
        this.testMethod = method;
        this.tags = JupiterTestDescriptor.j(method);
    }

    public void nodeSkipped(JupiterEngineExecutionContext jupiterEngineExecutionContext, TestDescriptor testDescriptor, Node.SkipResult skipResult) {
        if (jupiterEngineExecutionContext != null) {
            p(jupiterEngineExecutionContext, false, new a1(jupiterEngineExecutionContext, skipResult));
        }
    }
}
