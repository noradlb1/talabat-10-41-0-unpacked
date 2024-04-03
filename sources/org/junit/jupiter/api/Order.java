package org.junit.jupiter.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@API(since = "5.9", status = API.Status.STABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
    public static final int DEFAULT = 1073741823;

    int value();
}
