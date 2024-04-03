package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Predicate;

public final /* synthetic */ class d0 implements Predicate {
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
        return NodeTreeWalker.lambda$isReadOnly$5((ExclusiveResource) obj);
    }
}
