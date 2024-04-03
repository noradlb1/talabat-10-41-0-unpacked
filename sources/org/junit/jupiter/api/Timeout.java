package org.junit.jupiter.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;
import org.apiguardian.api.API;

@Inherited
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@API(since = "5.7", status = API.Status.STABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Timeout {
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_AFTER_ALL_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.afterall.method.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_AFTER_EACH_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.aftereach.method.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_BEFORE_ALL_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.beforeall.method.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_BEFORE_EACH_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.beforeeach.method.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_LIFECYCLE_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.lifecycle.method.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_TESTABLE_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.testable.method.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_TEST_FACTORY_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.testfactory.method.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_TEST_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.test.method.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_TEST_TEMPLATE_METHOD_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.testtemplate.method.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String DEFAULT_TIMEOUT_PROPERTY_NAME = "junit.jupiter.execution.timeout.default";
    @API(since = "5.9", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_TIMEOUT_THREAD_MODE_PROPERTY_NAME = "junit.jupiter.execution.timeout.thread.mode.default";
    @API(since = "5.9", status = API.Status.STABLE)
    public static final String TIMEOUT_MODE_PROPERTY_NAME = "junit.jupiter.execution.timeout.mode";

    @API(since = "5.9", status = API.Status.EXPERIMENTAL)
    public enum ThreadMode {
        INFERRED,
        SAME_THREAD,
        SEPARATE_THREAD
    }

    @API(since = "5.9", status = API.Status.EXPERIMENTAL)
    ThreadMode threadMode() default ThreadMode.INFERRED;

    TimeUnit unit() default TimeUnit.SECONDS;

    long value();
}
