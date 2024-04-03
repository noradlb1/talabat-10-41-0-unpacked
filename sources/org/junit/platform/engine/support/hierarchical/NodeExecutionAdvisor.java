package org.junit.platform.engine.support.hierarchical;

import j$.util.Map;
import j$.util.Optional;
import java.util.HashMap;
import java.util.Map;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.support.hierarchical.Node;

class NodeExecutionAdvisor {
    private final Map<TestDescriptor, Node.ExecutionMode> forcedDescendantExecutionModeByTestDescriptor = new HashMap();
    private final Map<TestDescriptor, ResourceLock> resourceLocksByTestDescriptor = new HashMap();

    /* access modifiers changed from: private */
    public Optional<Node.ExecutionMode> lookupExecutionModeForcedByAncestor(TestDescriptor testDescriptor) {
        Node.ExecutionMode executionMode = this.forcedDescendantExecutionModeByTestDescriptor.get(testDescriptor);
        if (executionMode != null) {
            return Optional.of(executionMode);
        }
        return testDescriptor.getParent().flatMap(new k(this));
    }

    public void b(TestDescriptor testDescriptor, Node.ExecutionMode executionMode) {
        this.forcedDescendantExecutionModeByTestDescriptor.put(testDescriptor, executionMode);
    }

    public Optional<Node.ExecutionMode> c(TestDescriptor testDescriptor) {
        return testDescriptor.getParent().flatMap(new k(this));
    }

    public ResourceLock d(TestDescriptor testDescriptor) {
        return (ResourceLock) Map.EL.getOrDefault(this.resourceLocksByTestDescriptor, testDescriptor, NopLock.f28072b);
    }

    public void e(TestDescriptor testDescriptor, ResourceLock resourceLock) {
        this.resourceLocksByTestDescriptor.put(testDescriptor, resourceLock);
    }
}
