package org.junit.platform.engine.support.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.discovery.UniqueIdSelector;

public final /* synthetic */ class b implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngineDiscoveryRequestResolution f28056a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UniqueIdSelector f28057b;

    public /* synthetic */ b(EngineDiscoveryRequestResolution engineDiscoveryRequestResolution, UniqueIdSelector uniqueIdSelector) {
        this.f28056a = engineDiscoveryRequestResolution;
        this.f28057b = uniqueIdSelector;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28056a.lambda$resolveUniqueId$3(this.f28057b, (SelectorResolver) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
