package org.junit.platform.commons.util;

import j$.util.function.Function;
import j$.util.function.Predicate;
import l30.i0;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class FunctionUtils {
    private FunctionUtils() {
    }

    public static <T, V> Predicate<T> where(Function<T, V> function, Predicate<? super V> predicate) {
        Preconditions.notNull(function, "function must not be null");
        Preconditions.notNull(predicate, "predicate must not be null");
        return new i0(predicate, function);
    }
}
