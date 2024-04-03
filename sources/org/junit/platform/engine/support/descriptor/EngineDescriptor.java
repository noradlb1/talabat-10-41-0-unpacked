package org.junit.platform.engine.support.descriptor;

import org.apiguardian.api.API;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;

@API(since = "1.0", status = API.Status.STABLE)
public class EngineDescriptor extends AbstractTestDescriptor {
    public EngineDescriptor(UniqueId uniqueId, String str) {
        super(uniqueId, str);
    }

    public TestDescriptor.Type getType() {
        return TestDescriptor.Type.CONTAINER;
    }
}
