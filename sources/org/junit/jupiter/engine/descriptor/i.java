package org.junit.jupiter.engine.descriptor;

import j$.util.function.Function;

public final /* synthetic */ class i implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DisplayNameUtils.lambda$getDisplayNameGenerator$4((Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
