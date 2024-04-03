package org.junit.platform.commons.util;

import j$.util.function.Predicate;

public final /* synthetic */ class c implements Predicate {
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
        return ClasspathScanner.lambda$determineFullyQualifiedClassName$5((String) obj);
    }
}
