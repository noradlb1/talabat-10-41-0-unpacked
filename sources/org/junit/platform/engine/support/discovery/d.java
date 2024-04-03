package org.junit.platform.engine.support.discovery;

import j$.util.function.Consumer;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolution;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EngineDiscoveryRequestResolution f28060b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EngineDiscoveryRequestResolution.DefaultContext f28061c;

    public /* synthetic */ d(EngineDiscoveryRequestResolution engineDiscoveryRequestResolution, EngineDiscoveryRequestResolution.DefaultContext defaultContext) {
        this.f28060b = engineDiscoveryRequestResolution;
        this.f28061c = defaultContext;
    }

    public final void accept(Object obj) {
        this.f28060b.lambda$enqueueAdditionalSelectors$0(this.f28061c, (DiscoverySelector) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
