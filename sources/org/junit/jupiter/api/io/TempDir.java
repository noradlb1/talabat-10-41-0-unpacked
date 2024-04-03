package org.junit.jupiter.api.io;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apiguardian.api.API;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@API(since = "5.4", status = API.Status.EXPERIMENTAL)
@Retention(RetentionPolicy.RUNTIME)
public @interface TempDir {
    @API(since = "5.9", status = API.Status.EXPERIMENTAL)
    public static final String DEFAULT_CLEANUP_MODE_PROPERTY_NAME = "junit.jupiter.tempdir.cleanup.mode.default";
    @Deprecated
    @API(since = "5.9", status = API.Status.DEPRECATED)
    public static final String SCOPE_PROPERTY_NAME = "junit.jupiter.tempdir.scope";

    @API(since = "5.9", status = API.Status.EXPERIMENTAL)
    CleanupMode cleanup() default CleanupMode.DEFAULT;
}
