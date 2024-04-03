package org.junit.jupiter.api.function;

import org.apiguardian.api.API;

@FunctionalInterface
@API(since = "5.0", status = API.Status.STABLE)
public interface ThrowingConsumer<T> {
    void accept(T t11) throws Throwable;
}
