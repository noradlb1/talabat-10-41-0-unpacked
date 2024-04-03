package org.mockito.internal.junit;

import j$.util.function.Function;
import org.mockito.invocation.Invocation;

public final /* synthetic */ class d implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return StubbingArgMismatches.lambda$add$0((Invocation) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
