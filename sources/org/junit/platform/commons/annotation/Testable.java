package org.junit.platform.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.apiguardian.api.API;

@Inherited
@Documented
@API(since = "1.0", status = API.Status.STABLE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Testable {
}
