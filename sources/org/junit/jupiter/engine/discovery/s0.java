package org.junit.jupiter.engine.discovery;

import j$.util.function.Supplier;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.discovery.DiscoverySelectors;

public final /* synthetic */ class s0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UniqueId f62543a;

    public /* synthetic */ s0(UniqueId uniqueId) {
        this.f62543a = uniqueId;
    }

    public final Object get() {
        return DiscoverySelectors.selectUniqueId(this.f62543a.removeLastSegment());
    }
}
