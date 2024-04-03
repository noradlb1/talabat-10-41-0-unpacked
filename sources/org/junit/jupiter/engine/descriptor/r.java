package org.junit.jupiter.engine.descriptor;

import j$.util.function.Function;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;

public final /* synthetic */ class r implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ExtensionUtils.streamExtensionTypes((List<ExtendWith>) (List) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
