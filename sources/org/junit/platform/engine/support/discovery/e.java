package org.junit.platform.engine.support.discovery;

import j$.util.function.Consumer;
import org.junit.platform.engine.support.discovery.SelectorResolver;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EngineDiscoveryRequestResolution f28062b;

    public /* synthetic */ e(EngineDiscoveryRequestResolution engineDiscoveryRequestResolution) {
        this.f28062b = engineDiscoveryRequestResolution;
    }

    public final void accept(Object obj) {
        this.f28062b.lambda$resolve$4((SelectorResolver.Match) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
