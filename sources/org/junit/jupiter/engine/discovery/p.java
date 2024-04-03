package org.junit.jupiter.engine.discovery;

import j$.util.function.Supplier;
import org.junit.platform.engine.discovery.DiscoverySelectors;

public final /* synthetic */ class p implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f62530a;

    public /* synthetic */ p(Class cls) {
        this.f62530a = cls;
    }

    public final Object get() {
        return DiscoverySelectors.selectClass(this.f62530a.getEnclosingClass());
    }
}
