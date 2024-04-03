package org.junit.jupiter.api.condition;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtendWith;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@API(since = "5.6", status = API.Status.STABLE)
@ExtendWith({EnabledForJreRangeCondition.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnabledForJreRange {
    @API(since = "5.7", status = API.Status.STABLE)
    String disabledReason() default "";

    JRE max() default JRE.OTHER;

    JRE min() default JRE.JAVA_8;
}
