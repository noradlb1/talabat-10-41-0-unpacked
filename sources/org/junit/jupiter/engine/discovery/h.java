package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;

public final /* synthetic */ class h implements Function {
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return new DefaultClassDescriptor((ClassBasedTestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
