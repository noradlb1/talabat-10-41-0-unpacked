package org.junit.platform.engine.support.discovery;

import j$.util.function.Consumer;
import org.junit.platform.engine.support.discovery.SelectorResolver;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EngineDiscoveryRequestResolution f28055b;

    public /* synthetic */ a(EngineDiscoveryRequestResolution engineDiscoveryRequestResolution) {
        this.f28055b = engineDiscoveryRequestResolution;
    }

    public final void accept(Object obj) {
        this.f28055b.lambda$enqueueAdditionalSelectors$1((SelectorResolver.Match) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
