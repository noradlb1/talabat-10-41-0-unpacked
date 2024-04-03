package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;

public final /* synthetic */ class d implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((AbstractAnnotatedDescriptorWrapper) obj).b();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
