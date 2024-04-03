package org.junit.platform.commons.util;

import j$.util.function.Function;
import java.net.URI;

public final /* synthetic */ class f implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return ClasspathScanner.removeTrailingClasspathResourcePathSeparator((URI) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
