package org.junit.platform.engine;

import j$.util.function.Predicate;
import org.junit.platform.engine.CompositeFilter;

public final /* synthetic */ class d implements Predicate {
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
        return CompositeFilter.AnonymousClass1.lambda$toPredicate$0(obj);
    }
}
