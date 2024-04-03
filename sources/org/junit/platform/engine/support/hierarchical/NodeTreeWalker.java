package org.junit.platform.engine.support.hierarchical;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import java.util.HashSet;
import java.util.Set;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.support.hierarchical.ExclusiveResource;
import org.junit.platform.engine.support.hierarchical.Node;

class NodeTreeWalker {
    private final ResourceLock globalReadLock;
    private final ResourceLock globalReadWriteLock;
    private final LockManager lockManager;

    public NodeTreeWalker() {
        this(new LockManager());
    }

    private void doForChildrenRecursively(TestDescriptor testDescriptor, Consumer<TestDescriptor> consumer) {
        Iterable.EL.forEach(testDescriptor.getChildren(), new j0(this, consumer));
    }

    private void forceDescendantExecutionModeRecursively(NodeExecutionAdvisor nodeExecutionAdvisor, TestDescriptor testDescriptor) {
        nodeExecutionAdvisor.b(testDescriptor, Node.ExecutionMode.SAME_THREAD);
        doForChildrenRecursively(testDescriptor, new i0(nodeExecutionAdvisor));
    }

    private Set<ExclusiveResource> getExclusiveResources(TestDescriptor testDescriptor) {
        return NodeUtils.a(testDescriptor).getExclusiveResources();
    }

    private boolean isReadOnly(Set<ExclusiveResource> set) {
        return Collection.EL.stream(set).allMatch(new d0());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doForChildrenRecursively$6(Consumer consumer, TestDescriptor testDescriptor) {
        consumer.accept(testDescriptor);
        doForChildrenRecursively(testDescriptor, consumer);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isReadOnly$5(ExclusiveResource exclusiveResource) {
        return exclusiveResource.getLockMode() == ExclusiveResource.LockMode.READ;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$walk$0(NodeExecutionAdvisor nodeExecutionAdvisor, TestDescriptor testDescriptor) {
        lambda$walk$1(testDescriptor, testDescriptor, nodeExecutionAdvisor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$walk$2(Set set, TestDescriptor testDescriptor) {
        set.addAll(getExclusiveResources(testDescriptor));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$walk$3(Set set, NodeExecutionAdvisor nodeExecutionAdvisor, TestDescriptor testDescriptor) {
        set.addAll(getExclusiveResources(testDescriptor));
        nodeExecutionAdvisor.b(testDescriptor, Node.ExecutionMode.SAME_THREAD);
    }

    /* access modifiers changed from: private */
    /* renamed from: walk */
    public void lambda$walk$1(TestDescriptor testDescriptor, TestDescriptor testDescriptor2, NodeExecutionAdvisor nodeExecutionAdvisor) {
        Set<ExclusiveResource> exclusiveResources = getExclusiveResources(testDescriptor2);
        if (exclusiveResources.isEmpty()) {
            nodeExecutionAdvisor.e(testDescriptor2, this.globalReadLock);
            Iterable.EL.forEach(testDescriptor2.getChildren(), new e0(this, testDescriptor, nodeExecutionAdvisor));
            return;
        }
        HashSet hashSet = new HashSet(exclusiveResources);
        if (isReadOnly(hashSet)) {
            doForChildrenRecursively(testDescriptor2, new f0(this, hashSet));
            if (!isReadOnly(hashSet)) {
                forceDescendantExecutionModeRecursively(nodeExecutionAdvisor, testDescriptor2);
            }
        } else {
            nodeExecutionAdvisor.b(testDescriptor2, Node.ExecutionMode.SAME_THREAD);
            doForChildrenRecursively(testDescriptor2, new g0(this, hashSet, nodeExecutionAdvisor));
        }
        if (!testDescriptor.equals(testDescriptor2) && hashSet.contains(ExclusiveResource.f28070b)) {
            forceDescendantExecutionModeRecursively(nodeExecutionAdvisor, testDescriptor);
            nodeExecutionAdvisor.e(testDescriptor, this.globalReadWriteLock);
        }
        if (testDescriptor.equals(testDescriptor2) && !hashSet.contains(ExclusiveResource.f28070b)) {
            hashSet.add(ExclusiveResource.f28069a);
        }
        nodeExecutionAdvisor.e(testDescriptor2, this.lockManager.f(hashSet));
    }

    public NodeExecutionAdvisor h(TestDescriptor testDescriptor) {
        Preconditions.condition(getExclusiveResources(testDescriptor).isEmpty(), "Engine descriptor must not declare exclusive resources");
        NodeExecutionAdvisor nodeExecutionAdvisor = new NodeExecutionAdvisor();
        Iterable.EL.forEach(testDescriptor.getChildren(), new h0(this, nodeExecutionAdvisor));
        return nodeExecutionAdvisor;
    }

    public NodeTreeWalker(LockManager lockManager2) {
        this.lockManager = lockManager2;
        this.globalReadLock = lockManager2.e(ExclusiveResource.f28069a);
        this.globalReadWriteLock = lockManager2.e(ExclusiveResource.f28070b);
    }
}
