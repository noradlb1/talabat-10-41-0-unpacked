package org.junit.jupiter.engine.execution;

import j$.util.function.Function;
import org.junit.jupiter.engine.execution.ExtensionValuesStore;

public final /* synthetic */ class c implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ExtensionValuesStore.lambda$closeAllStoredCloseableValues$2((ExtensionValuesStore.StoredValue) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
