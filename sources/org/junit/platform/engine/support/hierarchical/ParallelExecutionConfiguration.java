package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Predicate;
import java.util.concurrent.ForkJoinPool;
import org.apiguardian.api.API;

@API(since = "1.3", status = API.Status.EXPERIMENTAL)
public interface ParallelExecutionConfiguration {
    int getCorePoolSize();

    int getKeepAliveSeconds();

    int getMaxPoolSize();

    int getMinimumRunnable();

    int getParallelism();

    @API(since = "1.9", status = API.Status.EXPERIMENTAL)
    Predicate<? super ForkJoinPool> getSaturatePredicate();
}
