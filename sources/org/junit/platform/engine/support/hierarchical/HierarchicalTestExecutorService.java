package org.junit.platform.engine.support.hierarchical;

import java.util.List;
import java.util.concurrent.Future;
import org.apiguardian.api.API;
import org.junit.platform.engine.support.hierarchical.Node;

@API(since = "1.3", status = API.Status.EXPERIMENTAL)
public interface HierarchicalTestExecutorService extends AutoCloseable {

    public interface TestTask {
        void execute();

        Node.ExecutionMode getExecutionMode();

        ResourceLock getResourceLock();
    }

    void close();

    void invokeAll(List<? extends TestTask> list);

    Future<Void> submit(TestTask testTask);
}
