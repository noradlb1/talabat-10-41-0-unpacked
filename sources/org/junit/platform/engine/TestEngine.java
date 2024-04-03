package org.junit.platform.engine;

import j$.util.Optional;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.STABLE)
public interface TestEngine {
    TestDescriptor discover(EngineDiscoveryRequest engineDiscoveryRequest, UniqueId uniqueId);

    void execute(ExecutionRequest executionRequest);

    Optional<String> getArtifactId();

    Optional<String> getGroupId();

    String getId();

    Optional<String> getVersion();
}
