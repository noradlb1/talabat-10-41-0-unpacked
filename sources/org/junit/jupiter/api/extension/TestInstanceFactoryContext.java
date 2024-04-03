package org.junit.jupiter.api.extension;

import j$.util.Optional;
import org.apiguardian.api.API;

@API(since = "5.7", status = API.Status.STABLE)
public interface TestInstanceFactoryContext {
    Optional<Object> getOuterInstance();

    Class<?> getTestClass();
}
