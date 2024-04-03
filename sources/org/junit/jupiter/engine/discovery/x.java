package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class x implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62566a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62567b;

    public /* synthetic */ x(ClassSelectorResolver classSelectorResolver, Class cls) {
        this.f62566a = classSelectorResolver;
        this.f62567b = cls;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62566a.lambda$resolve$5(this.f62567b, (TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
