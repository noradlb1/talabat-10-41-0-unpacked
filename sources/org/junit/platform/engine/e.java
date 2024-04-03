package org.junit.platform.engine;

import j$.util.function.Function;
import j$.util.function.Predicate;
import java.util.Arrays;
import java.util.Collection;
import m30.i;
import m30.j;
import org.junit.platform.commons.util.CollectionUtils;
import org.junit.platform.commons.util.Preconditions;

public final /* synthetic */ class e<T> {
    public static Predicate a(Filter filter) {
        return new i(filter);
    }

    public static <T, V> Filter<T> c(Filter<V> filter, Function<T, V> function) {
        return new j(filter, function);
    }

    public static <T> Filter<T> d(Collection<? extends Filter<T>> collection) {
        Preconditions.notNull(collection, "Filters must not be null");
        if (collection.isEmpty()) {
            return CompositeFilter.e();
        }
        if (collection.size() == 1) {
            return (Filter) CollectionUtils.getOnlyElement(collection);
        }
        return new CompositeFilter(collection);
    }

    @SafeVarargs
    public static <T> Filter<T> e(Filter<T>... filterArr) {
        Preconditions.notNull(filterArr, "filters array must not be null");
        Preconditions.containsNoNullElements((T[]) filterArr, "individual filters must not be null");
        if (filterArr.length == 0) {
            return CompositeFilter.e();
        }
        if (filterArr.length == 1) {
            return filterArr[0];
        }
        return new CompositeFilter(Arrays.asList(filterArr));
    }
}
