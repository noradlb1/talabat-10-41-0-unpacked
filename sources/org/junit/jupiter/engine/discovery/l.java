package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;

public final /* synthetic */ class l implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ClassOrderingVisitor.lambda$getDescriptorWrapperOrderer$2((Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
