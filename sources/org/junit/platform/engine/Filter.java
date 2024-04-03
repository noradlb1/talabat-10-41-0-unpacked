package org.junit.platform.engine;

import j$.util.function.Predicate;
import org.apiguardian.api.API;

@FunctionalInterface
@API(since = "1.0", status = API.Status.STABLE)
public interface Filter<T> {
    FilterResult apply(T t11);

    Predicate<T> toPredicate();
}
