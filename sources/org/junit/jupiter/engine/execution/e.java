package org.junit.jupiter.engine.execution;

import j$.util.function.Function;
import org.junit.jupiter.api.extension.InvocationInterceptor;

public final /* synthetic */ class e implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((InvocationInterceptor) obj).getClass();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
