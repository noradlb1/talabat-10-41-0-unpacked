package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Function;
import java.util.List;

public final /* synthetic */ class h implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return LockManager.lambda$getDistinctSortedLocks$1((List) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
