package r30;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;

public final /* synthetic */ class e implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ParallelExecutionConfiguration f28172b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ForkJoinPool.ForkJoinWorkerThreadFactory f28173c;

    public /* synthetic */ e(ParallelExecutionConfiguration parallelExecutionConfiguration, ForkJoinPool.ForkJoinWorkerThreadFactory forkJoinWorkerThreadFactory) {
        this.f28172b = parallelExecutionConfiguration;
        this.f28173c = forkJoinWorkerThreadFactory;
    }

    public final Object call() {
        return Integer.TYPE;
    }
}
