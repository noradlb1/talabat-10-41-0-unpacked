package org.junit.platform.engine.support.hierarchical;

import org.apiguardian.api.API;

@API(since = "1.3", status = API.Status.EXPERIMENTAL)
public interface ResourceLock extends AutoCloseable {
    ResourceLock acquire() throws InterruptedException;

    void close();

    void release();
}
