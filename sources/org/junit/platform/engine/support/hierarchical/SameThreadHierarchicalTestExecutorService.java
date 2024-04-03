package org.junit.platform.engine.support.hierarchical;

import j$.lang.Iterable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.apiguardian.api.API;
import org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutorService;
import r30.p;

@API(since = "1.3", status = API.Status.EXPERIMENTAL)
public class SameThreadHierarchicalTestExecutorService implements HierarchicalTestExecutorService {
    public void close() {
    }

    public void invokeAll(List<? extends HierarchicalTestExecutorService.TestTask> list) {
        Iterable.EL.forEach(list, new p());
    }

    public Future<Void> submit(HierarchicalTestExecutorService.TestTask testTask) {
        testTask.execute();
        return CompletableFuture.completedFuture((Object) null);
    }
}
