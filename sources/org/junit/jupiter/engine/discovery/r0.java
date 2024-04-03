package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;

public final /* synthetic */ class r0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSelectorResolver f62539a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UniqueId f62540b;

    public /* synthetic */ r0(MethodSelectorResolver methodSelectorResolver, UniqueId uniqueId) {
        this.f62539a = methodSelectorResolver;
        this.f62540b = uniqueId;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62539a.lambda$resolve$5(this.f62540b, (TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
