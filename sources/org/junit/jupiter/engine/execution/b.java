package org.junit.jupiter.engine.execution;

import j$.util.function.Predicate;
import org.junit.jupiter.engine.execution.ExtensionValuesStore;

public final /* synthetic */ class b implements Predicate {
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
        return ExtensionValuesStore.lambda$closeAllStoredCloseableValues$1((ExtensionValuesStore.StoredValue) obj);
    }
}
