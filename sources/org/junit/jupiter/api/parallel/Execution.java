package org.junit.jupiter.api.parallel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@API(since = "5.3", status = API.Status.EXPERIMENTAL)
@Retention(RetentionPolicy.RUNTIME)
public @interface Execution {
    @API(since = "5.9", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_CLASSES_EXECUTION_MODE_PROPERTY_NAME = "junit.jupiter.execution.parallel.mode.classes.default";
    @API(since = "5.9", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_EXECUTION_MODE_PROPERTY_NAME = "junit.jupiter.execution.parallel.mode.default";

    ExecutionMode value();
}
