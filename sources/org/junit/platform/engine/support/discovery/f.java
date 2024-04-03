package org.junit.platform.engine.support.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.DiscoverySelector;

public final /* synthetic */ class f implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngineDiscoveryRequestResolution f28063a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoverySelector f28064b;

    public /* synthetic */ f(EngineDiscoveryRequestResolution engineDiscoveryRequestResolution, DiscoverySelector discoverySelector) {
        this.f28063a = engineDiscoveryRequestResolution;
        this.f28064b = discoverySelector;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28063a.lambda$resolve$2(this.f28064b, (SelectorResolver) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
