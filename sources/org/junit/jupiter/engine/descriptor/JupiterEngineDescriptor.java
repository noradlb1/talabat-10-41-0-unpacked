package org.junit.jupiter.engine.descriptor;

import java.util.Set;
import org.apiguardian.api.API;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.DefaultExecutableInvoker;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.EngineDescriptor;
import org.junit.platform.engine.support.hierarchical.EngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.Node;
import r30.l;

@API(since = "5.0", status = API.Status.INTERNAL)
public class JupiterEngineDescriptor extends EngineDescriptor implements Node<JupiterEngineExecutionContext> {
    public static final String ENGINE_ID = "junit-jupiter";
    private final JupiterConfiguration configuration;

    public JupiterEngineDescriptor(UniqueId uniqueId, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, "JUnit Jupiter");
        this.configuration = jupiterConfiguration;
    }

    public /* synthetic */ void after(EngineExecutionContext engineExecutionContext) {
        l.a(this, engineExecutionContext);
    }

    public /* synthetic */ void around(EngineExecutionContext engineExecutionContext, Node.Invocation invocation) {
        l.b(this, engineExecutionContext, invocation);
    }

    public /* synthetic */ EngineExecutionContext before(EngineExecutionContext engineExecutionContext) {
        return l.c(this, engineExecutionContext);
    }

    public /* synthetic */ EngineExecutionContext execute(EngineExecutionContext engineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) {
        return l.e(this, engineExecutionContext, dynamicTestExecutor);
    }

    public JupiterConfiguration getConfiguration() {
        return this.configuration;
    }

    public /* synthetic */ Set getExclusiveResources() {
        return l.f(this);
    }

    public Node.ExecutionMode getExecutionMode() {
        return JupiterTestDescriptor.toExecutionMode(this.configuration.getDefaultExecutionMode());
    }

    public /* synthetic */ void nodeFinished(EngineExecutionContext engineExecutionContext, TestDescriptor testDescriptor, TestExecutionResult testExecutionResult) {
        l.h(this, engineExecutionContext, testDescriptor, testExecutionResult);
    }

    public /* synthetic */ void nodeSkipped(EngineExecutionContext engineExecutionContext, TestDescriptor testDescriptor, Node.SkipResult skipResult) {
        l.i(this, engineExecutionContext, testDescriptor, skipResult);
    }

    public /* synthetic */ Node.SkipResult shouldBeSkipped(EngineExecutionContext engineExecutionContext) {
        return l.k(this, engineExecutionContext);
    }

    public void cleanUp(JupiterEngineExecutionContext jupiterEngineExecutionContext) throws Exception {
        jupiterEngineExecutionContext.close();
    }

    public JupiterEngineExecutionContext prepare(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        MutableExtensionRegistry createRegistryWithDefaultExtensions = MutableExtensionRegistry.createRegistryWithDefaultExtensions(jupiterEngineExecutionContext.getConfiguration());
        return jupiterEngineExecutionContext.extend().withExtensionRegistry(createRegistryWithDefaultExtensions).withExtensionContext(new JupiterEngineExtensionContext(jupiterEngineExecutionContext.getExecutionListener(), this, jupiterEngineExecutionContext.getConfiguration(), new DefaultExecutableInvoker(jupiterEngineExecutionContext))).build();
    }
}
