package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Predicate;
import r30.n;

class DefaultParallelExecutionConfiguration implements ParallelExecutionConfiguration {
    private final int corePoolSize;
    private final int keepAliveSeconds;
    private final int maxPoolSize;
    private final int minimumRunnable;
    private final int parallelism;

    public DefaultParallelExecutionConfiguration(int i11, int i12, int i13, int i14, int i15) {
        this.parallelism = i11;
        this.minimumRunnable = i12;
        this.maxPoolSize = i13;
        this.corePoolSize = i14;
        this.keepAliveSeconds = i15;
    }

    public int getCorePoolSize() {
        return this.corePoolSize;
    }

    public int getKeepAliveSeconds() {
        return this.keepAliveSeconds;
    }

    public int getMaxPoolSize() {
        return this.maxPoolSize;
    }

    public int getMinimumRunnable() {
        return this.minimumRunnable;
    }

    public int getParallelism() {
        return this.parallelism;
    }

    public /* synthetic */ Predicate getSaturatePredicate() {
        return n.a(this);
    }
}
