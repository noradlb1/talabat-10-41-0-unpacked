package org.junit.jupiter.api.parallel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Inherited
@Target({ElementType.TYPE})
@API(since = "5.7", status = API.Status.EXPERIMENTAL)
@ResourceLock("org.junit.platform.engine.support.hierarchical.ExclusiveResource.GLOBAL_KEY")
@Retention(RetentionPolicy.RUNTIME)
public @interface Isolated {
    String value() default "";
}
