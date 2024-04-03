package r30;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import org.junit.platform.engine.support.hierarchical.ForkJoinPoolHierarchicalTestExecutorService;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;

public final /* synthetic */ class f implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ParallelExecutionConfiguration f28174b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ForkJoinPool.ForkJoinWorkerThreadFactory f28175c;

    public /* synthetic */ f(ParallelExecutionConfiguration parallelExecutionConfiguration, ForkJoinPool.ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory) {
        this.f28174b = parallelExecutionConfiguration;
        this.f28175c = forkJoinWorkerThreadFactory;
    }

    public final Object call() {
        return ForkJoinPoolHierarchicalTestExecutorService.lambda$createForkJoinPool$2(this.f28174b, this.f28175c);
    }
}
