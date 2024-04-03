package org.junit.platform.engine.support.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolution;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngineDiscoveryRequestResolution.DefaultContext f28065a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function f28066b;

    public /* synthetic */ g(EngineDiscoveryRequestResolution.DefaultContext defaultContext, Function function) {
        this.f28065a = defaultContext;
        this.f28066b = function;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28065a.lambda$addToParent$0(this.f28066b, (TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
