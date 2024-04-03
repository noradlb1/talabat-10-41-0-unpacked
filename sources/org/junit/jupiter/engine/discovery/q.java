package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class q implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62533a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62534b;

    public /* synthetic */ q(ClassSelectorResolver classSelectorResolver, Class cls) {
        this.f62533a = classSelectorResolver;
        this.f62534b = cls;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62533a.lambda$resolve$2(this.f62534b, (TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
