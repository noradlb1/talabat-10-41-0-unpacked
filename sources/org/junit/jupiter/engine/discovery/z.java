package org.junit.jupiter.engine.discovery;

import j$.util.function.Supplier;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.discovery.DiscoverySelectors;

public final /* synthetic */ class z implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UniqueId f62570a;

    public /* synthetic */ z(UniqueId uniqueId) {
        this.f62570a = uniqueId;
    }

    public final Object get() {
        return DiscoverySelectors.selectUniqueId(this.f62570a.removeLastSegment());
    }
}
