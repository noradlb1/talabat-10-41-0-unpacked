package org.junit.platform.engine.support.hierarchical;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.platform.engine.support.hierarchical.NodeTestTask;

public final /* synthetic */ class c0 {
    static {
        NodeTestTask.DynamicTaskState dynamicTaskState = NodeTestTask.DynamicTaskState.UNSCHEDULED;
    }

    public static /* synthetic */ void a() throws CancellationException, ExecutionException, InterruptedException {
    }

    public static NodeTestTask.DynamicTaskState b(Future<Void> future) {
        Objects.requireNonNull(future);
        return new b0(future);
    }

    public static NodeTestTask.DynamicTaskState c() {
        return NodeTestTask.DynamicTaskState.UNSCHEDULED;
    }
}
