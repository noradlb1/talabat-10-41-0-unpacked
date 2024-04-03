package org.junit.jupiter.api.condition;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({EnabledIfEnvironmentVariableCondition.class})
@Repeatable(EnabledIfEnvironmentVariables.class)
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@API(since = "5.1", status = API.Status.STABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnabledIfEnvironmentVariable {
    @API(since = "5.7", status = API.Status.STABLE)
    String disabledReason() default "";

    String matches();

    String named();
}
