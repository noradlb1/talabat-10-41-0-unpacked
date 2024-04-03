package org.junit.jupiter.api.parallel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@API(since = "5.3", status = API.Status.EXPERIMENTAL)
@Repeatable(ResourceLocks.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourceLock {
    ResourceAccessMode mode() default ResourceAccessMode.READ_WRITE;

    String value();
}
