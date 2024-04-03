package org.junit.jupiter.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;
import org.junit.jupiter.api.DisplayNameGenerator;

@Inherited
@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@API(since = "5.7", status = API.Status.EXPERIMENTAL)
@Retention(RetentionPolicy.RUNTIME)
public @interface IndicativeSentencesGeneration {
    public static final Class<? extends DisplayNameGenerator> DEFAULT_GENERATOR = DisplayNameGenerator.Standard.class;
    public static final String DEFAULT_SEPARATOR = ", ";

    Class<? extends DisplayNameGenerator> generator() default DisplayNameGenerator.Standard.class;

    String separator() default ", ";
}
