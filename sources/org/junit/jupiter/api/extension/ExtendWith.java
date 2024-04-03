package org.junit.jupiter.api.extension;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Inherited
@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@API(since = "5.0", status = API.Status.STABLE)
@Repeatable(Extensions.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtendWith {
    Class<? extends Extension>[] value();
}
