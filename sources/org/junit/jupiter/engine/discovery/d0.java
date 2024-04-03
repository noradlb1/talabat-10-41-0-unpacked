package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;

public final /* synthetic */ class d0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return MethodOrderingVisitor.lambda$orderContainedMethods$2((Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
