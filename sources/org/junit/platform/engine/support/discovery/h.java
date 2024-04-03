package org.junit.platform.engine.support.discovery;

import j$.util.function.Function;
import java.util.Set;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolution;

public final /* synthetic */ class h implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverySelector f28067a;

    public /* synthetic */ h(DiscoverySelector discoverySelector) {
        this.f28067a = discoverySelector;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return EngineDiscoveryRequestResolution.DefaultContext.lambda$resolve$1(this.f28067a, (Set) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
