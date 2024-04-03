package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Function;

public final /* synthetic */ class g implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return LockManager.lambda$toLock$2((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
