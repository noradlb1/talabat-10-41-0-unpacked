package org.junit.jupiter.engine.descriptor;

import d30.a2;
import d30.b2;
import d30.i0;
import d30.u1;
import d30.v1;
import d30.w1;
import d30.x1;
import d30.y1;
import d30.z1;
import j$.util.Collection;
import j$.util.Optional;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apiguardian.api.API;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.DefaultExecutableInvoker;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.hierarchical.Node;

@API(since = "5.0", status = API.Status.INTERNAL)
public class TestTemplateTestDescriptor extends MethodBasedTestDescriptor implements Filterable {
    public static final String SEGMENT_TYPE = "test-template";
    private final DynamicDescendantFilter dynamicDescendantFilter = new DynamicDescendantFilter();

    public TestTemplateTestDescriptor(UniqueId uniqueId, Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, cls, method, jupiterConfiguration);
    }

    private Optional<TestDescriptor> createInvocationTestDescriptor(TestTemplateInvocationContext testTemplateInvocationContext, int i11) {
        UniqueId uniqueId = getUniqueId();
        UniqueId append = uniqueId.append(TestTemplateInvocationTestDescriptor.SEGMENT_TYPE, "#" + i11);
        if (!getDynamicDescendantFilter().test(append, Integer.valueOf(i11 - 1))) {
            return Optional.empty();
        }
        return Optional.of(new TestTemplateInvocationTestDescriptor(append, getTestClass(), getTestMethod(), testTemplateInvocationContext, i11, this.f62416b));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$execute$1(AtomicInteger atomicInteger, TestTemplateInvocationContext testTemplateInvocationContext) {
        return createInvocationTestDescriptor(testTemplateInvocationContext, atomicInteger.incrementAndGet());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$validateProviders$4() {
        return String.format("You must register at least one %s that supports @TestTemplate method [%s]", new Object[]{TestTemplateInvocationContextProvider.class.getSimpleName(), getTestMethod()});
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$validateWasAtLeastInvokedOnce$6(List list) {
        return "None of the supporting " + TestTemplateInvocationContextProvider.class.getSimpleName() + "s " + ((String) Collection.EL.stream(list).map(new u1()).collect(Collectors.joining(IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "[", "]"))) + " provided a non-empty stream";
    }

    private List<TestTemplateInvocationContextProvider> validateProviders(ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) {
        return (List) Preconditions.notEmpty((List) extensionRegistry.stream(TestTemplateInvocationContextProvider.class).filter(new w1(extensionContext)).collect(Collectors.toList()), (Supplier<String>) new x1(this));
    }

    private void validateWasAtLeastInvokedOnce(int i11, List<TestTemplateInvocationContextProvider> list) {
        Preconditions.condition(i11 > 0, (Supplier<String>) new v1(list));
    }

    public DynamicDescendantFilter getDynamicDescendantFilter() {
        return this.dynamicDescendantFilter;
    }

    public TestDescriptor.Type getType() {
        return TestDescriptor.Type.CONTAINER;
    }

    public boolean mayRegisterTests() {
        return true;
    }

    public JupiterEngineExecutionContext execute(JupiterEngineExecutionContext jupiterEngineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) throws Exception {
        ExtensionContext extensionContext = jupiterEngineExecutionContext.getExtensionContext();
        List<TestTemplateInvocationContextProvider> validateProviders = validateProviders(extensionContext, jupiterEngineExecutionContext.getExtensionRegistry());
        AtomicInteger atomicInteger = new AtomicInteger();
        Collection.EL.stream(validateProviders).flatMap(new y1(extensionContext)).map(new z1(this, atomicInteger)).filter(new i0()).map(new a2()).forEach(new b2(this, dynamicTestExecutor));
        validateWasAtLeastInvokedOnce(atomicInteger.get(), validateProviders);
        return jupiterEngineExecutionContext;
    }

    public JupiterEngineExecutionContext prepare(JupiterEngineExecutionContext jupiterEngineExecutionContext) throws Exception {
        MutableExtensionRegistry i11 = ExtensionUtils.i(jupiterEngineExecutionContext.getExtensionRegistry(), getTestMethod());
        DefaultExecutableInvoker defaultExecutableInvoker = new DefaultExecutableInvoker(jupiterEngineExecutionContext);
        return jupiterEngineExecutionContext.extend().withExtensionRegistry(i11).withExtensionContext(new TestTemplateExtensionContext(jupiterEngineExecutionContext.getExtensionContext(), jupiterEngineExecutionContext.getExecutionListener(), this, jupiterEngineExecutionContext.getConfiguration(), jupiterEngineExecutionContext.getExtensionContext().getTestInstances().orElse(null), defaultExecutableInvoker)).build();
    }

    /* access modifiers changed from: private */
    /* renamed from: execute */
    public void lambda$execute$2(Node.DynamicTestExecutor dynamicTestExecutor, TestDescriptor testDescriptor) {
        testDescriptor.setParent(this);
        dynamicTestExecutor.execute(testDescriptor);
    }
}
