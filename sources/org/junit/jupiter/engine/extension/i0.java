package org.junit.jupiter.engine.extension;

import j$.util.function.Function;
import org.junit.jupiter.engine.extension.TimeoutExtension;

public final /* synthetic */ class i0 implements TimeoutExtension.TimeoutProvider {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ((TimeoutConfiguration) obj).k();
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
