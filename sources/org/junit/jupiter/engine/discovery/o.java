package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class o implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62526a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62527b;

    public /* synthetic */ o(ClassSelectorResolver classSelectorResolver, Class cls) {
        this.f62526a = classSelectorResolver;
        this.f62527b = cls;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62526a.lambda$resolve$0(this.f62527b, (TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
