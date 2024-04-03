package org.junit.jupiter.engine.config;

import c30.k;
import j$.util.Optional;
import j$.util.function.Function;
import j$.util.function.Predicate;
import org.apiguardian.api.API;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.commons.util.ClassNamePatternFilterUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.ConfigurationParameters;

@API(since = "5.4", status = API.Status.INTERNAL)
public class DefaultJupiterConfiguration implements JupiterConfiguration {
    private static final InstantiatingConfigurationParameterConverter<ClassOrderer> classOrdererConverter = new InstantiatingConfigurationParameterConverter<>(ClassOrderer.class, "class orderer");
    private static final EnumConfigurationParameterConverter<CleanupMode> cleanupModeConverter = new EnumConfigurationParameterConverter<>(CleanupMode.class, "cleanup mode");
    private static final InstantiatingConfigurationParameterConverter<DisplayNameGenerator> displayNameGeneratorConverter = new InstantiatingConfigurationParameterConverter<>(DisplayNameGenerator.class, "display name generator");
    private static final EnumConfigurationParameterConverter<ExecutionMode> executionModeConverter = new EnumConfigurationParameterConverter<>(ExecutionMode.class, "parallel execution mode");
    private static final EnumConfigurationParameterConverter<TestInstance.Lifecycle> lifecycleConverter = new EnumConfigurationParameterConverter<>(TestInstance.Lifecycle.class, "test instance lifecycle mode");
    private static final InstantiatingConfigurationParameterConverter<MethodOrderer> methodOrdererConverter = new InstantiatingConfigurationParameterConverter<>(MethodOrderer.class, "method orderer");
    private final ConfigurationParameters configurationParameters;

    public DefaultJupiterConfiguration(ConfigurationParameters configurationParameters2) {
        this.configurationParameters = (ConfigurationParameters) Preconditions.notNull(configurationParameters2, "ConfigurationParameters must not be null");
    }

    public ExecutionMode getDefaultClassesExecutionMode() {
        return executionModeConverter.c(this.configurationParameters, "junit.jupiter.execution.parallel.mode.classes.default", getDefaultExecutionMode());
    }

    public DisplayNameGenerator getDefaultDisplayNameGenerator() {
        return displayNameGeneratorConverter.h(this.configurationParameters, "junit.jupiter.displayname.generator.default").orElseGet(new k());
    }

    public ExecutionMode getDefaultExecutionMode() {
        return executionModeConverter.c(this.configurationParameters, "junit.jupiter.execution.parallel.mode.default", ExecutionMode.SAME_THREAD);
    }

    public CleanupMode getDefaultTempDirCleanupMode() {
        return cleanupModeConverter.c(this.configurationParameters, TempDir.DEFAULT_CLEANUP_MODE_PROPERTY_NAME, CleanupMode.ALWAYS);
    }

    public Optional<ClassOrderer> getDefaultTestClassOrderer() {
        return classOrdererConverter.h(this.configurationParameters, "junit.jupiter.testclass.order.default");
    }

    public TestInstance.Lifecycle getDefaultTestInstanceLifecycle() {
        return lifecycleConverter.c(this.configurationParameters, "junit.jupiter.testinstance.lifecycle.default", TestInstance.Lifecycle.PER_METHOD);
    }

    public Optional<MethodOrderer> getDefaultTestMethodOrderer() {
        return methodOrdererConverter.h(this.configurationParameters, "junit.jupiter.testmethod.order.default");
    }

    public Predicate<ExecutionCondition> getExecutionConditionFilter() {
        return ClassNamePatternFilterUtils.excludeMatchingClasses(this.configurationParameters.get("junit.jupiter.conditions.deactivate").orElse(null));
    }

    public Optional<String> getRawConfigurationParameter(String str) {
        return this.configurationParameters.get(str);
    }

    public boolean isExtensionAutoDetectionEnabled() {
        return this.configurationParameters.getBoolean("junit.jupiter.extensions.autodetection.enabled").orElse(Boolean.FALSE).booleanValue();
    }

    public boolean isParallelExecutionEnabled() {
        return this.configurationParameters.getBoolean("junit.jupiter.execution.parallel.enabled").orElse(Boolean.FALSE).booleanValue();
    }

    public <T> Optional<T> getRawConfigurationParameter(String str, Function<String, T> function) {
        return this.configurationParameters.get(str, function);
    }
}
