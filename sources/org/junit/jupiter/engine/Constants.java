package org.junit.jupiter.engine;

import org.apiguardian.api.API;

@API(since = "5.0", status = API.Status.STABLE)
public final class Constants {
    public static final String DEACTIVATE_ALL_CONDITIONS_PATTERN = "*";
    public static final String DEACTIVATE_CONDITIONS_PATTERN_PROPERTY_NAME = "junit.jupiter.conditions.deactivate";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_AFTER_ALL_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.afterall.method.default";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_AFTER_EACH_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.aftereach.method.default";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_BEFORE_ALL_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.beforeall.method.default";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_BEFORE_EACH_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.beforeeach.method.default";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_CLASSES_EXECUTION_MODE_PROPERTY_NAME = "junit.jupiter.execution.parallel.mode.classes.default";
    public static final String DEFAULT_DISPLAY_NAME_GENERATOR_PROPERTY_NAME = "junit.jupiter.displayname.generator.default";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_LIFECYCLE_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.lifecycle.method.default";
    @API(since = "5.4", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_PARALLEL_EXECUTION_MODE = "junit.jupiter.execution.parallel.mode.default";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_TESTABLE_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.testable.method.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_TEST_CLASS_ORDER_PROPERTY_NAME = "junit.jupiter.testclass.order.default";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_TEST_FACTORY_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.testfactory.method.default";
    public static final String DEFAULT_TEST_INSTANCE_LIFECYCLE_PROPERTY_NAME = "junit.jupiter.testinstance.lifecycle.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_TEST_METHOD_ORDER_PROPERTY_NAME = "junit.jupiter.testmethod.order.default";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_TEST_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.test.method.default";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_TEST_TEMPLATE_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.testtemplate.method.default";
    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.default";
    @API(since = "5.9", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_TIMEOUT_THREAD_MODE_PROPERTY_NAME = "junit.jupiter.execution.timeout.thread.mode.default";
    public static final String EXTENSIONS_AUTODETECTION_ENABLED_PROPERTY_NAME = "junit.jupiter.extensions.autodetection.enabled";
    @API(since = "5.3", status = API.Status.EXPERIMENTAL)
    public static final String PARALLEL_CONFIG_CUSTOM_CLASS_PROPERTY_NAME = "junit.jupiter.execution.parallel.config.custom.class";
    @API(since = "5.3", status = API.Status.EXPERIMENTAL)
    public static final String PARALLEL_CONFIG_DYNAMIC_FACTOR_PROPERTY_NAME = "junit.jupiter.execution.parallel.config.dynamic.factor";
    @API(since = "5.3", status = API.Status.EXPERIMENTAL)
    public static final String PARALLEL_CONFIG_FIXED_PARALLELISM_PROPERTY_NAME = "junit.jupiter.execution.parallel.config.fixed.parallelism";
    @API(since = "5.3", status = API.Status.EXPERIMENTAL)
    public static final String PARALLEL_CONFIG_STRATEGY_PROPERTY_NAME = "junit.jupiter.execution.parallel.config.strategy";
    @API(since = "5.3", status = API.Status.EXPERIMENTAL)
    public static final String PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME = "junit.jupiter.execution.parallel.enabled";
    @Deprecated
    @API(since = "5.8", status = API.Status.DEPRECATED)
    public static final String TEMP_DIR_SCOPE_PROPERTY_NAME = "junit.jupiter.tempdir.scope";
    @API(since = "5.6", status = API.Status.EXPERIMENTAL)
    public static final String TIMEOUT_MODE_PROPERTY_NAME = "junit.jupiter.execution.timeout.mode";

    private Constants() {
    }
}
