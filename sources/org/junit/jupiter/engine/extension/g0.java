package org.junit.jupiter.engine.extension;

import j$.util.function.Function;
import org.junit.jupiter.api.Timeout;

public final /* synthetic */ class g0 implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return TimeoutDuration.b((Timeout) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
