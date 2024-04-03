package org.junit.platform.engine;

import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.STABLE)
public class ExecutionRequest {
    private final ConfigurationParameters configurationParameters;
    private final EngineExecutionListener engineExecutionListener;
    private final TestDescriptor rootTestDescriptor;

    @API(since = "1.0", status = API.Status.INTERNAL)
    public ExecutionRequest(TestDescriptor testDescriptor, EngineExecutionListener engineExecutionListener2, ConfigurationParameters configurationParameters2) {
        this.rootTestDescriptor = testDescriptor;
        this.engineExecutionListener = engineExecutionListener2;
        this.configurationParameters = configurationParameters2;
    }

    @API(since = "1.9", status = API.Status.STABLE)
    public static ExecutionRequest create(TestDescriptor testDescriptor, EngineExecutionListener engineExecutionListener2, ConfigurationParameters configurationParameters2) {
        return new ExecutionRequest(testDescriptor, engineExecutionListener2, configurationParameters2);
    }

    public ConfigurationParameters getConfigurationParameters() {
        return this.configurationParameters;
    }

    public EngineExecutionListener getEngineExecutionListener() {
        return this.engineExecutionListener;
    }

    public TestDescriptor getRootTestDescriptor() {
        return this.rootTestDescriptor;
    }
}
