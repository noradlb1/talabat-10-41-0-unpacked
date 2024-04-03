package org.junit.platform.engine;

import java.util.List;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.STABLE)
public interface EngineDiscoveryRequest {
    ConfigurationParameters getConfigurationParameters();

    @API(since = "1.6", status = API.Status.EXPERIMENTAL)
    EngineDiscoveryListener getDiscoveryListener();

    <T extends DiscoveryFilter<?>> List<T> getFiltersByType(Class<T> cls);

    <T extends DiscoverySelector> List<T> getSelectorsByType(Class<T> cls);
}
