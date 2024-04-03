package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;

public final /* synthetic */ class r implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62538a;

    public /* synthetic */ r(ClassSelectorResolver classSelectorResolver) {
        this.f62538a = classSelectorResolver;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62538a.lambda$toResolution$13((ClassBasedTestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
