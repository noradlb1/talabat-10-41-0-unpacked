package org.junit.jupiter.api.function;

import org.apiguardian.api.API;

@FunctionalInterface
@API(since = "5.0", status = API.Status.STABLE)
public interface ThrowingSupplier<T> {
    T get() throws Throwable;
}
