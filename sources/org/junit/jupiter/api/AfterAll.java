package org.junit.jupiter.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@API(since = "5.0", status = API.Status.STABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AfterAll {
}
