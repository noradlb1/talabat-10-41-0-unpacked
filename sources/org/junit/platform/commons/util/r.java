package org.junit.platform.commons.util;

import j$.util.function.Function;
import java.nio.file.FileSystem;

public final /* synthetic */ class r implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return CloseablePath.lambda$create$2((FileSystem) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
