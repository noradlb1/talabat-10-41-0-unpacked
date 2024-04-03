package org.junit.jupiter.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@TestTemplate
@API(since = "5.0", status = API.Status.STABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatedTest {
    public static final String CURRENT_REPETITION_PLACEHOLDER = "{currentRepetition}";
    public static final String DISPLAY_NAME_PLACEHOLDER = "{displayName}";
    public static final String LONG_DISPLAY_NAME = "{displayName} :: repetition {currentRepetition} of {totalRepetitions}";
    public static final String SHORT_DISPLAY_NAME = "repetition {currentRepetition} of {totalRepetitions}";
    public static final String TOTAL_REPETITIONS_PLACEHOLDER = "{totalRepetitions}";

    String name() default "repetition {currentRepetition} of {totalRepetitions}";

    int value();
}
