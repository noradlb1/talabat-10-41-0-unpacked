package org.junit.platform.engine.support.hierarchical;

import e30.c;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Map;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.ExceptionUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.junit.platform.engine.EngineExecutionListener;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.hierarchical.EngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutorService;
import org.junit.platform.engine.support.hierarchical.Node;
import r30.m;

class NodeTestTask<C extends EngineExecutionContext> implements HierarchicalTestExecutorService.TestTask {
    private static final Runnable NOOP = new x();
    private static final Logger logger = LoggerFactory.getLogger(NodeTestTask.class);
    /* access modifiers changed from: private */
    public C context;
    private final Runnable finalizer;
    private final Node<C> node;
    private C parentContext;
    private Node.SkipResult skipResult;
    private boolean started;
    /* access modifiers changed from: private */
    public final NodeTestTaskContext taskContext;
    private final TestDescriptor testDescriptor;
    private ThrowableCollector throwableCollector;

    public class DefaultDynamicTestExecutor implements Node.DynamicTestExecutor {
        private final Map<UniqueId, DynamicTaskState> unfinishedTasks;

        private DefaultDynamicTestExecutor() {
            this.unfinishedTasks = new ConcurrentHashMap();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$execute$0(UniqueId uniqueId) {
            this.unfinishedTasks.remove(uniqueId);
        }

        public void awaitFinished() throws InterruptedException {
            for (DynamicTaskState awaitFinished : this.unfinishedTasks.values()) {
                try {
                    awaitFinished.awaitFinished();
                } catch (CancellationException unused) {
                } catch (ExecutionException e11) {
                    ExceptionUtils.throwAsUncheckedException(e11.getCause());
                }
            }
        }

        public void execute(TestDescriptor testDescriptor) {
            execute(testDescriptor, NodeTestTask.this.taskContext.c());
        }

        public Future<?> execute(TestDescriptor testDescriptor, EngineExecutionListener engineExecutionListener) {
            Preconditions.notNull(testDescriptor, "testDescriptor must not be null");
            Preconditions.notNull(engineExecutionListener, "executionListener must not be null");
            engineExecutionListener.dynamicTestRegistered(testDescriptor);
            Set<ExclusiveResource> exclusiveResources = NodeUtils.a(testDescriptor).getExclusiveResources();
            if (!exclusiveResources.isEmpty()) {
                engineExecutionListener.executionStarted(testDescriptor);
                engineExecutionListener.executionFinished(testDescriptor, TestExecutionResult.failed(new JUnitException("Dynamic test descriptors must not declare exclusive resources: " + exclusiveResources)));
                return CompletableFuture.completedFuture((Object) null);
            }
            UniqueId uniqueId = testDescriptor.getUniqueId();
            NodeTestTask nodeTestTask = new NodeTestTask(NodeTestTask.this.taskContext.e(engineExecutionListener), testDescriptor, new y(this, uniqueId));
            nodeTestTask.p(NodeTestTask.this.context);
            this.unfinishedTasks.put(uniqueId, c0.c());
            Future<Void> submit = NodeTestTask.this.taskContext.b().submit(nodeTestTask);
            Map.EL.computeIfPresent(this.unfinishedTasks, uniqueId, new z(submit));
            return submit;
        }
    }

    @FunctionalInterface
    public interface DynamicTaskState {
        public static final DynamicTaskState UNSCHEDULED = new a0();

        void awaitFinished() throws CancellationException, ExecutionException, InterruptedException;
    }

    public NodeTestTask(NodeTestTaskContext nodeTestTaskContext, TestDescriptor testDescriptor2) {
        this(nodeTestTaskContext, testDescriptor2, NOOP);
    }

    private void checkWhetherSkipped() {
        this.throwableCollector.execute(new o(this));
    }

    private void cleanUp() {
        this.throwableCollector.execute(new s(this));
    }

    private void executeRecursively() {
        this.taskContext.c().executionStarted(this.testDescriptor);
        this.started = true;
        this.throwableCollector.execute(new w(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkWhetherSkipped$3() throws Throwable {
        this.skipResult = this.node.shouldBeSkipped(this.context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanUp$10() throws Throwable {
        this.node.cleanUp(this.context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$execute$1() {
        return String.format("Execution of TestDescriptor with display name [%s] and unique ID [%s] failed to clear the 'interrupted status' flag for the current thread. JUnit has cleared the flag, but you may wish to investigate why the flag was not cleared by user code.", new Object[]{this.testDescriptor.getDisplayName(), this.testDescriptor.getUniqueId()});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ NodeTestTask lambda$executeRecursively$4(TestDescriptor testDescriptor2) {
        return new NodeTestTask(this.taskContext, testDescriptor2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$executeRecursively$5(NodeTestTask nodeTestTask) {
        nodeTestTask.p(this.context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$executeRecursively$6() throws Throwable {
        List list = (List) Collection.EL.stream(this.testDescriptor.getChildren()).map(new q(this)).collect(Collectors.toCollection(new c()));
        this.context = this.node.before(this.context);
        DefaultDynamicTestExecutor defaultDynamicTestExecutor = new DefaultDynamicTestExecutor();
        this.context = this.node.execute(this.context, defaultDynamicTestExecutor);
        if (!list.isEmpty()) {
            Iterable.EL.forEach(list, new r(this));
            this.taskContext.b().invokeAll(list);
        }
        this.throwableCollector.execute(new m(defaultDynamicTestExecutor));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$executeRecursively$7() throws Throwable {
        this.node.after(this.context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$executeRecursively$8(EngineExecutionContext engineExecutionContext) throws Exception {
        this.context = engineExecutionContext;
        this.throwableCollector.execute(new m(this));
        this.throwableCollector.execute(new n(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$executeRecursively$9() throws Throwable {
        this.node.around(this.context, new t(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$prepare$2() throws Throwable {
        this.context = this.node.prepare(this.parentContext);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$reportCompletion$11() {
        return String.format("Failed to invoke nodeSkipped() on Node %s", new Object[]{this.testDescriptor.getUniqueId()});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$reportCompletion$12() {
        return String.format("Failed to invoke nodeFinished() on Node %s", new Object[]{this.testDescriptor.getUniqueId()});
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0() {
    }

    private void prepare() {
        this.throwableCollector.execute(new l(this));
        this.parentContext = null;
    }

    private void reportCompletion() {
        if (!this.throwableCollector.isEmpty() || !this.skipResult.isSkipped()) {
            if (!this.started) {
                this.taskContext.c().executionStarted(this.testDescriptor);
            }
            try {
                this.node.nodeFinished(this.context, this.testDescriptor, this.throwableCollector.toTestExecutionResult());
            } catch (Throwable th2) {
                UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
                logger.debug(th2, new v(this));
            }
            this.taskContext.c().executionFinished(this.testDescriptor, this.throwableCollector.toTestExecutionResult());
            this.throwableCollector = null;
            return;
        }
        try {
            this.node.nodeSkipped(this.context, this.testDescriptor, this.skipResult);
        } catch (Throwable th3) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th3);
            logger.debug(th3, new u(this));
        }
        this.taskContext.c().executionSkipped(this.testDescriptor, this.skipResult.getReason().orElse("<unknown>"));
    }

    /* JADX INFO: finally extract failed */
    public void execute() {
        try {
            this.throwableCollector = this.taskContext.d().create();
            prepare();
            if (this.throwableCollector.isEmpty()) {
                checkWhetherSkipped();
            }
            if (this.throwableCollector.isEmpty() && !this.skipResult.isSkipped()) {
                executeRecursively();
            }
            if (this.context != null) {
                cleanUp();
            }
            reportCompletion();
            if (Thread.interrupted()) {
                logger.debug(new p(this));
            }
            this.finalizer.run();
            this.context = null;
        } catch (Throwable th2) {
            if (Thread.interrupted()) {
                logger.debug(new p(this));
            }
            this.finalizer.run();
            throw th2;
        }
    }

    public Node.ExecutionMode getExecutionMode() {
        return this.taskContext.a().c(this.testDescriptor).orElse(this.node.getExecutionMode());
    }

    public ResourceLock getResourceLock() {
        return this.taskContext.a().d(this.testDescriptor);
    }

    public void p(C c11) {
        this.parentContext = c11;
    }

    public NodeTestTask(NodeTestTaskContext nodeTestTaskContext, TestDescriptor testDescriptor2, Runnable runnable) {
        this.taskContext = nodeTestTaskContext;
        this.testDescriptor = testDescriptor2;
        this.node = NodeUtils.a(testDescriptor2);
        this.finalizer = runnable;
    }
}
