package org.junit.jupiter.api;

import j$.util.function.Function;
import org.junit.jupiter.api.function.Executable;

public final /* synthetic */ class a implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return AssertAll.lambda$assertAll$0((Executable) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
