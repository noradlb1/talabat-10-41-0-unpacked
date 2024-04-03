package org.junit.platform.engine.support.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.support.discovery.SelectorResolver;

public final /* synthetic */ class c implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngineDiscoveryRequestResolution f28058a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoverySelector f28059b;

    public /* synthetic */ c(EngineDiscoveryRequestResolution engineDiscoveryRequestResolution, DiscoverySelector discoverySelector) {
        this.f28058a = engineDiscoveryRequestResolution;
        this.f28059b = discoverySelector;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28058a.lambda$resolve$5(this.f28059b, (SelectorResolver.Resolution) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
