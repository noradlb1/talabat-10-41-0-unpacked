package org.junit.platform.engine;

import m30.f;
import org.apiguardian.api.API;

@API(since = "1.6", status = API.Status.EXPERIMENTAL)
public interface EngineDiscoveryListener {
    public static final EngineDiscoveryListener NOOP = new EngineDiscoveryListener() {
        public /* synthetic */ void selectorProcessed(UniqueId uniqueId, DiscoverySelector discoverySelector, SelectorResolutionResult selectorResolutionResult) {
            f.a(this, uniqueId, discoverySelector, selectorResolutionResult);
        }
    };

    void selectorProcessed(UniqueId uniqueId, DiscoverySelector discoverySelector, SelectorResolutionResult selectorResolutionResult);
}
