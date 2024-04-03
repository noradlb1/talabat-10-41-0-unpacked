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
@API(since = "5.0", status = API.Status.STABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestInstance {

    public enum Lifecycle {
        PER_CLASS,
        PER_METHOD;
        
        @API(since = "5.9", status = API.Status.STABLE)
        public static final String DEFAULT_LIFECYCLE_PROPERTY_NAME = "junit.jupiter.testinstance.lifecycle.default";
    }

    Lifecycle value();
}
