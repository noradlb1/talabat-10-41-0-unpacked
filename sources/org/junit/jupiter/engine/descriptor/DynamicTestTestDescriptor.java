package org.junit.jupiter.engine.descriptor;

import f30.k;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.InvocationInterceptorChain;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.hierarchical.Node;

class DynamicTestTestDescriptor extends DynamicNodeTestDescriptor {
    private static final InvocationInterceptorChain interceptorChain = new InvocationInterceptorChain();
    private DynamicTest dynamicTest;

    public DynamicTestTestDescriptor(UniqueId uniqueId, int i11, DynamicTest dynamicTest2, TestSource testSource, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, i11, dynamicTest2, testSource, jupiterConfiguration);
        this.dynamicTest = dynamicTest2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void lambda$execute$0() throws Throwable {
        this.dynamicTest.getExecutable().execute();
        return null;
    }

    public TestDescriptor.Type getType() {
        return TestDescriptor.Type.TEST;
    }

    public void after(JupiterEngineExecutionContext jupiterEngineExecutionContext) throws Exception {
        super.after(jupiterEngineExecutionContext);
        this.dynamicTest = null;
    }

    public JupiterEngineExecutionContext execute(JupiterEngineExecutionContext jupiterEngineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) {
        m mVar = new m(this);
        DefaultDynamicTestInvocationContext defaultDynamicTestInvocationContext = new DefaultDynamicTestInvocationContext(this.dynamicTest.getExecutable());
        ExtensionContext extensionContext = jupiterEngineExecutionContext.getExtensionContext();
        interceptorChain.invoke(mVar, jupiterEngineExecutionContext.getExtensionRegistry(), k.b(new n(defaultDynamicTestInvocationContext, extensionContext)));
        return jupiterEngineExecutionContext;
    }
}
