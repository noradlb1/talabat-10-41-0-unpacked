package org.junit.platform.engine.support.hierarchical;

import java.util.concurrent.Future;
import org.junit.platform.engine.ExecutionRequest;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.support.hierarchical.EngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

class HierarchicalTestExecutor<C extends EngineExecutionContext> {
    private final HierarchicalTestExecutorService executorService;
    private final ExecutionRequest request;
    private final C rootContext;
    private final ThrowableCollector.Factory throwableCollectorFactory;

    public HierarchicalTestExecutor(ExecutionRequest executionRequest, C c11, HierarchicalTestExecutorService hierarchicalTestExecutorService, ThrowableCollector.Factory factory) {
        this.request = executionRequest;
        this.rootContext = c11;
        this.executorService = hierarchicalTestExecutorService;
        this.throwableCollectorFactory = factory;
    }

    public Future<Void> a() {
        TestDescriptor rootTestDescriptor = this.request.getRootTestDescriptor();
        NodeTestTask nodeTestTask = new NodeTestTask(new NodeTestTaskContext(this.request.getEngineExecutionListener(), this.executorService, this.throwableCollectorFactory, new NodeTreeWalker().h(rootTestDescriptor)), rootTestDescriptor);
        nodeTestTask.p(this.rootContext);
        return this.executorService.submit(nodeTestTask);
    }
}
