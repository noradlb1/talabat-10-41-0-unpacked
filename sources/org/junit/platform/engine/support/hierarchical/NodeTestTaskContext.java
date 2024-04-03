package org.junit.platform.engine.support.hierarchical;

import org.junit.platform.engine.EngineExecutionListener;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

class NodeTestTaskContext {
    private final NodeExecutionAdvisor executionAdvisor;
    private final HierarchicalTestExecutorService executorService;
    private final EngineExecutionListener listener;
    private final ThrowableCollector.Factory throwableCollectorFactory;

    public NodeTestTaskContext(EngineExecutionListener engineExecutionListener, HierarchicalTestExecutorService hierarchicalTestExecutorService, ThrowableCollector.Factory factory, NodeExecutionAdvisor nodeExecutionAdvisor) {
        this.listener = engineExecutionListener;
        this.executorService = hierarchicalTestExecutorService;
        this.throwableCollectorFactory = factory;
        this.executionAdvisor = nodeExecutionAdvisor;
    }

    public NodeExecutionAdvisor a() {
        return this.executionAdvisor;
    }

    public HierarchicalTestExecutorService b() {
        return this.executorService;
    }

    public EngineExecutionListener c() {
        return this.listener;
    }

    public ThrowableCollector.Factory d() {
        return this.throwableCollectorFactory;
    }

    public NodeTestTaskContext e(EngineExecutionListener engineExecutionListener) {
        if (this.listener == engineExecutionListener) {
            return this;
        }
        return new NodeTestTaskContext(engineExecutionListener, this.executorService, this.throwableCollectorFactory, this.executionAdvisor);
    }
}
