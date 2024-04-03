package org.junit.jupiter.engine;

import b30.a;
import j$.util.Optional;
import org.apiguardian.api.API;
import org.junit.jupiter.engine.config.CachingJupiterConfiguration;
import org.junit.jupiter.engine.config.DefaultJupiterConfiguration;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.descriptor.JupiterEngineDescriptor;
import org.junit.jupiter.engine.discovery.DiscoverySelectorResolver;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.ExecutionRequest;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.config.PrefixedConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ForkJoinPoolHierarchicalTestExecutorService;
import org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine;
import org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutorService;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

@API(since = "5.0", status = API.Status.INTERNAL)
public final class JupiterTestEngine extends HierarchicalTestEngine<JupiterEngineExecutionContext> {
    private JupiterConfiguration getJupiterConfiguration(ExecutionRequest executionRequest) {
        return ((JupiterEngineDescriptor) executionRequest.getRootTestDescriptor()).getConfiguration();
    }

    public HierarchicalTestExecutorService b(ExecutionRequest executionRequest) {
        if (getJupiterConfiguration(executionRequest).isParallelExecutionEnabled()) {
            return new ForkJoinPoolHierarchicalTestExecutorService((ConfigurationParameters) new PrefixedConfigurationParameters(executionRequest.getConfigurationParameters(), "junit.jupiter.execution.parallel.config."));
        }
        return super.b(executionRequest);
    }

    public ThrowableCollector.Factory c(ExecutionRequest executionRequest) {
        return new a();
    }

    /* renamed from: d */
    public JupiterEngineExecutionContext a(ExecutionRequest executionRequest) {
        return new JupiterEngineExecutionContext(executionRequest.getEngineExecutionListener(), getJupiterConfiguration(executionRequest));
    }

    public TestDescriptor discover(EngineDiscoveryRequest engineDiscoveryRequest, UniqueId uniqueId) {
        JupiterEngineDescriptor jupiterEngineDescriptor = new JupiterEngineDescriptor(uniqueId, new CachingJupiterConfiguration(new DefaultJupiterConfiguration(engineDiscoveryRequest.getConfigurationParameters())));
        new DiscoverySelectorResolver().resolveSelectors(engineDiscoveryRequest, jupiterEngineDescriptor);
        return jupiterEngineDescriptor;
    }

    public Optional<String> getArtifactId() {
        return Optional.of("junit-jupiter-engine");
    }

    public Optional<String> getGroupId() {
        return Optional.of("org.junit.jupiter");
    }

    public String getId() {
        return JupiterEngineDescriptor.ENGINE_ID;
    }
}
