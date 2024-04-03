package org.junit.jupiter.engine.descriptor;

import d30.m0;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.DefaultExecutableInvoker;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.hierarchical.Node;

abstract class DynamicNodeTestDescriptor extends JupiterTestDescriptor {
    private final int index;

    public DynamicNodeTestDescriptor(UniqueId uniqueId, int i11, DynamicNode dynamicNode, TestSource testSource, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, dynamicNode.getDisplayName(), testSource, jupiterConfiguration);
        this.index = i11;
    }

    public String getLegacyReportingName() {
        return ((String) getParent().map(new m0()).orElseGet(new l(this))) + "[" + this.index + "]";
    }

    public JupiterEngineExecutionContext prepare(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        return jupiterEngineExecutionContext.extend().withExtensionContext(new DynamicExtensionContext(jupiterEngineExecutionContext.getExtensionContext(), jupiterEngineExecutionContext.getExecutionListener(), this, jupiterEngineExecutionContext.getConfiguration(), new DefaultExecutableInvoker(jupiterEngineExecutionContext))).build();
    }

    public Node.SkipResult shouldBeSkipped(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        return Node.SkipResult.doNotSkip();
    }
}
