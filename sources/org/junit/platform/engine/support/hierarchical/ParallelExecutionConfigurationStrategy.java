package org.junit.platform.engine.support.hierarchical;

import org.apiguardian.api.API;
import org.junit.platform.engine.ConfigurationParameters;

@API(since = "1.3", status = API.Status.EXPERIMENTAL)
public interface ParallelExecutionConfigurationStrategy {
    ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters);
}
