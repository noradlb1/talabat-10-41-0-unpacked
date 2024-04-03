package org.junit.jupiter.engine.descriptor;

import d30.i0;
import d30.j0;
import d30.k0;
import j$.util.Optional;
import j$.util.stream.Stream;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.hierarchical.Node;

class DynamicContainerTestDescriptor extends DynamicNodeTestDescriptor {
    private final DynamicContainer dynamicContainer;
    private final DynamicDescendantFilter dynamicDescendantFilter;
    private final TestSource testSource;

    public DynamicContainerTestDescriptor(UniqueId uniqueId, int i11, DynamicContainer dynamicContainer2, TestSource testSource2, DynamicDescendantFilter dynamicDescendantFilter2, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, i11, dynamicContainer2, testSource2, jupiterConfiguration);
        this.dynamicContainer = dynamicContainer2;
        this.testSource = testSource2;
        this.dynamicDescendantFilter = dynamicDescendantFilter2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$execute$0(AtomicInteger atomicInteger, DynamicNode dynamicNode) {
        Preconditions.notNull(dynamicNode, "individual dynamic node must not be null");
        return toDynamicDescriptor(atomicInteger.getAndIncrement(), dynamicNode);
    }

    private Optional<JupiterTestDescriptor> toDynamicDescriptor(int i11, DynamicNode dynamicNode) {
        return TestFactoryTestDescriptor.M(this, dynamicNode, i11, this.testSource, this.dynamicDescendantFilter, this.f62416b);
    }

    public TestDescriptor.Type getType() {
        return TestDescriptor.Type.CONTAINER;
    }

    public JupiterEngineExecutionContext execute(JupiterEngineExecutionContext jupiterEngineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) throws Exception {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Stream<? extends DynamicNode> children = this.dynamicContainer.getChildren();
        try {
            Stream<R> map = children.map(new k(this, atomicInteger)).filter(new i0()).map(new j0());
            Objects.requireNonNull(dynamicTestExecutor);
            map.forEachOrdered(new k0(dynamicTestExecutor));
            children.close();
            return jupiterEngineExecutionContext;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
