package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Function;

public final /* synthetic */ class j implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(!"org.junit.platform.engine.support.hierarchical.ExclusiveResource.GLOBAL_KEY".equals((String) obj));
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
