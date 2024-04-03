package org.junit.jupiter.api;

import j$.util.Optional;
import java.lang.reflect.Method;
import java.util.Set;
import org.apiguardian.api.API;

@API(since = "5.0", status = API.Status.STABLE)
public interface TestInfo {
    String getDisplayName();

    Set<String> getTags();

    Optional<Class<?>> getTestClass();

    Optional<Method> getTestMethod();
}
