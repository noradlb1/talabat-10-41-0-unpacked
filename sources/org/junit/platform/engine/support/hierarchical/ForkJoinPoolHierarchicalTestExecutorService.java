package org.junit.platform.engine.support.hierarchical;

import java.lang.Thread;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.function.Try;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.ExceptionUtils;
import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutorService;
import org.junit.platform.engine.support.hierarchical.Node;
import r30.d;
import r30.e;
import r30.f;
import r30.g;

@API(since = "1.3", status = API.Status.EXPERIMENTAL)
public class ForkJoinPoolHierarchicalTestExecutorService implements HierarchicalTestExecutorService {
    private final ForkJoinPool forkJoinPool;
    private final int parallelism;

    public static class ExclusiveTask extends RecursiveAction {
        private final HierarchicalTestExecutorService.TestTask testTask;

        public ExclusiveTask(HierarchicalTestExecutorService.TestTask testTask2) {
            this.testTask = testTask2;
        }

        public void compute() {
            ResourceLock acquire;
            try {
                acquire = this.testTask.getResourceLock().acquire();
                this.testTask.execute();
                if (acquire != null) {
                    acquire.close();
                    return;
                }
                return;
            } catch (InterruptedException e11) {
                ExceptionUtils.throwAsUncheckedException(e11);
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static class WorkerThread extends ForkJoinWorkerThread {
        public WorkerThread(ForkJoinPool forkJoinPool, ClassLoader classLoader) {
            super(forkJoinPool);
            setContextClassLoader(classLoader);
        }
    }

    public static class WorkerThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {
        private final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        public ForkJoinWorkerThread newThread(ForkJoinPool forkJoinPool) {
            return new WorkerThread(forkJoinPool, this.contextClassLoader);
        }
    }

    public ForkJoinPoolHierarchicalTestExecutorService(ConfigurationParameters configurationParameters) {
        this(createConfiguration(configurationParameters));
    }

    private static ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters) {
        return DefaultParallelExecutionConfigurationStrategy.a(configurationParameters).createConfiguration(configurationParameters);
    }

    private ForkJoinPool createForkJoinPool(ParallelExecutionConfiguration parallelExecutionConfiguration) {
        WorkerThreadFactory workerThreadFactory = new WorkerThreadFactory();
        return (ForkJoinPool) Try.call(new e(parallelExecutionConfiguration, workerThreadFactory)).orElseTry(new f(parallelExecutionConfiguration, workerThreadFactory)).getOrThrow(new g());
    }

    private void executeNonConcurrentTasks(Deque<ExclusiveTask> deque) {
        for (ExclusiveTask compute : deque) {
            compute.compute();
        }
    }

    private void forkConcurrentTasks(List<? extends HierarchicalTestExecutorService.TestTask> list, Deque<ExclusiveTask> deque, Deque<ExclusiveTask> deque2) {
        for (HierarchicalTestExecutorService.TestTask testTask : list) {
            ExclusiveTask exclusiveTask = new ExclusiveTask(testTask);
            if (testTask.getExecutionMode() == Node.ExecutionMode.CONCURRENT) {
                exclusiveTask.fork();
                deque2.addFirst(exclusiveTask);
            } else {
                deque.add(exclusiveTask);
            }
        }
    }

    private boolean isAlreadyRunningInForkJoinPool() {
        return ForkJoinTask.getPool() == this.forkJoinPool;
    }

    private void joinConcurrentTasksInReverseOrderToEnableWorkStealing(Deque<ExclusiveTask> deque) {
        for (ExclusiveTask join : deque) {
            join.join();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ForkJoinPool lambda$createForkJoinPool$2(ParallelExecutionConfiguration parallelExecutionConfiguration, ForkJoinPool.ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory) throws Exception {
        return new ForkJoinPool(parallelExecutionConfiguration.getParallelism(), forkJoinWorkerThreadFactory, (Thread.UncaughtExceptionHandler) null, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JUnitException lambda$createForkJoinPool$3(Exception exc) {
        return new JUnitException("Failed to create ForkJoinPool", exc);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$new$0() {
        return "Using ForkJoinPool with parallelism of " + this.parallelism;
    }

    public void close() {
        this.forkJoinPool.shutdownNow();
    }

    public void invokeAll(List<? extends HierarchicalTestExecutorService.TestTask> list) {
        if (list.size() == 1) {
            new ExclusiveTask((HierarchicalTestExecutorService.TestTask) list.get(0)).compute();
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        forkConcurrentTasks(list, linkedList, linkedList2);
        executeNonConcurrentTasks(linkedList);
        joinConcurrentTasksInReverseOrderToEnableWorkStealing(linkedList2);
    }

    public Future<Void> submit(HierarchicalTestExecutorService.TestTask testTask) {
        ExclusiveTask exclusiveTask = new ExclusiveTask(testTask);
        if (!isAlreadyRunningInForkJoinPool()) {
            return this.forkJoinPool.submit(exclusiveTask);
        }
        if (testTask.getExecutionMode() == Node.ExecutionMode.CONCURRENT && ForkJoinTask.getSurplusQueuedTaskCount() < this.parallelism) {
            return exclusiveTask.fork();
        }
        exclusiveTask.compute();
        return CompletableFuture.completedFuture((Object) null);
    }

    @API(since = "1.7", status = API.Status.EXPERIMENTAL)
    public ForkJoinPoolHierarchicalTestExecutorService(ParallelExecutionConfiguration parallelExecutionConfiguration) {
        ForkJoinPool createForkJoinPool = createForkJoinPool(parallelExecutionConfiguration);
        this.forkJoinPool = createForkJoinPool;
        this.parallelism = createForkJoinPool.getParallelism();
        LoggerFactory.getLogger(getClass()).config(new d(this));
    }
}
