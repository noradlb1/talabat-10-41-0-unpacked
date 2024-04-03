package org.junit.platform.engine.discovery;

import j$.util.function.Predicate;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExcludeClassNameFilter f28031a;

    public /* synthetic */ e(ExcludeClassNameFilter excludeClassNameFilter) {
        this.f28031a = excludeClassNameFilter;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return this.f28031a.lambda$toPredicate$2((String) obj);
    }
}
