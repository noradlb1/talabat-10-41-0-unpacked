package org.junit.jupiter.engine.discovery;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class o0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSelectorResolver f62528a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BiFunction f62529b;

    public /* synthetic */ o0(MethodSelectorResolver methodSelectorResolver, BiFunction biFunction) {
        this.f62528a = methodSelectorResolver;
        this.f62529b = biFunction;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62528a.lambda$resolve$1(this.f62529b, (TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
