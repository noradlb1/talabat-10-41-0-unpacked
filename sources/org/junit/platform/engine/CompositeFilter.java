package org.junit.platform.engine;

import j$.util.Collection;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import m30.a;
import m30.b;
import m30.c;
import org.junit.platform.commons.util.Preconditions;

class CompositeFilter<T> implements Filter<T> {
    private static final Filter ALWAYS_INCLUDED_FILTER = new Filter() {
        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$toPredicate$0(Object obj) {
            return true;
        }

        public FilterResult apply(Object obj) {
            return CompositeFilter.ALWAYS_INCLUDED_RESULT;
        }

        public Predicate toPredicate() {
            return new d();
        }
    };
    /* access modifiers changed from: private */
    public static final FilterResult ALWAYS_INCLUDED_RESULT = FilterResult.included("Always included");
    private static final FilterResult INCLUDED_BY_ALL_FILTERS = FilterResult.included("Element was included by all filters.");
    private final Collection<Filter<T>> filters;

    public CompositeFilter(Collection<? extends Filter<T>> collection) {
        this.filters = new ArrayList(Preconditions.notEmpty(collection, "filters must not be empty"));
    }

    public static <T> Filter<T> e() {
        return ALWAYS_INCLUDED_FILTER;
    }

    public FilterResult apply(T t11) {
        return (FilterResult) Collection.EL.stream(this.filters).map(new c(t11)).filter(new c()).findFirst().orElse(INCLUDED_BY_ALL_FILTERS);
    }

    public Predicate<T> toPredicate() {
        return (Predicate) Collection.EL.stream(this.filters).map(new a()).reduce(new b()).get();
    }

    public String toString() {
        return (String) Collection.EL.stream(this.filters).map(new a()).map(new b()).collect(Collectors.joining(" and "));
    }
}
