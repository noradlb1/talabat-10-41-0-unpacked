package org.junit.jupiter.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Inherited
@Documented
@Target({ElementType.TYPE})
@API(since = "5.8", status = API.Status.EXPERIMENTAL)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestClassOrder {
    Class<? extends ClassOrderer> value();
}
