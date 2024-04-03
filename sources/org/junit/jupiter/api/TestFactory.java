package org.junit.jupiter.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;
import org.junit.platform.commons.annotation.Testable;

@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Testable
@API(since = "5.3", status = API.Status.MAINTAINED)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestFactory {
}
