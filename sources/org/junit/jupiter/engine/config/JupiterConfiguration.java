package org.junit.jupiter.engine.config;

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
import org.junit.jupiter.api.parallel.ExecutionMode;

@API(since = "5.4", status = API.Status.INTERNAL)
public interface JupiterConfiguration {
    public static final String DEACTIVATE_CONDITIONS_PATTERN_PROPERTY_NAME = "junit.jupiter.conditions.deactivate";
    public static final String DEFAULT_CLASSES_EXECUTION_MODE_PROPERTY_NAME = "junit.jupiter.execution.parallel.mode.classes.default";
    public static final String DEFAULT_DISPLAY_NAME_GENERATOR_PROPERTY_NAME = "junit.jupiter.displayname.generator.default";
    public static final String DEFAULT_EXECUTION_MODE_PROPERTY_NAME = "junit.jupiter.execution.parallel.mode.default";
    public static final String DEFAULT_TEST_CLASS_ORDER_PROPERTY_NAME = "junit.jupiter.testclass.order.default";
    public static final String DEFAULT_TEST_INSTANCE_LIFECYCLE_PROPERTY_NAME = "junit.jupiter.testinstance.lifecycle.default";
    public static final String DEFAULT_TEST_METHOD_ORDER_PROPERTY_NAME = "junit.jupiter.testmethod.order.default";
    public static final String EXTENSIONS_AUTODETECTION_ENABLED_PROPERTY_NAME = "junit.jupiter.extensions.autodetection.enabled";
    public static final String PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME = "junit.jupiter.execution.parallel.enabled";

    ExecutionMode getDefaultClassesExecutionMode();

    DisplayNameGenerator getDefaultDisplayNameGenerator();

    ExecutionMode getDefaultExecutionMode();

    CleanupMode getDefaultTempDirCleanupMode();

    Optional<ClassOrderer> getDefaultTestClassOrderer();

    TestInstance.Lifecycle getDefaultTestInstanceLifecycle();

    Optional<MethodOrderer> getDefaultTestMethodOrderer();

    Predicate<ExecutionCondition> getExecutionConditionFilter();

    Optional<String> getRawConfigurationParameter(String str);

    <T> Optional<T> getRawConfigurationParameter(String str, Function<String, T> function);

    boolean isExtensionAutoDetectionEnabled();

    boolean isParallelExecutionEnabled();
}
