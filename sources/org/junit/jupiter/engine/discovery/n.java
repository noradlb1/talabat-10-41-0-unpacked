package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class n implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestDescriptor f62520b;

    public /* synthetic */ n(ClassSelectorResolver classSelectorResolver, TestDescriptor testDescriptor) {
        this.f62519a = classSelectorResolver;
        this.f62520b = testDescriptor;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62519a.lambda$resolve$8(this.f62520b, (Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
