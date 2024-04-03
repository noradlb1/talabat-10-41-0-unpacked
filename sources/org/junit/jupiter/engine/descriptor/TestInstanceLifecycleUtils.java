package org.junit.jupiter.engine.descriptor;

import d30.m1;
import d30.n1;
import j$.util.Optional;
import java.lang.reflect.AnnotatedElement;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;

@API(since = "5.0", status = API.Status.INTERNAL)
public final class TestInstanceLifecycleUtils {
    private TestInstanceLifecycleUtils() {
    }

    public static TestInstance.Lifecycle a(Class<?> cls, JupiterConfiguration jupiterConfiguration) {
        Preconditions.notNull(cls, "testClass must not be null");
        Preconditions.notNull(jupiterConfiguration, "configuration must not be null");
        Optional<U> map = AnnotationUtils.findAnnotation((AnnotatedElement) cls, TestInstance.class).map(new m1());
        Objects.requireNonNull(jupiterConfiguration);
        return (TestInstance.Lifecycle) map.orElseGet(new n1(jupiterConfiguration));
    }
}
