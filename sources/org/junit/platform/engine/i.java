package org.junit.platform.engine;

import j$.util.function.Function;

public final /* synthetic */ class i implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return UniqueIdFormat.encode(((Character) obj).charValue());
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
