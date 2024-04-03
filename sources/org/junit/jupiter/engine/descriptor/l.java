package org.junit.jupiter.engine.descriptor;

import j$.util.function.Supplier;

public final /* synthetic */ class l implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DynamicNodeTestDescriptor f62454a;

    public /* synthetic */ l(DynamicNodeTestDescriptor dynamicNodeTestDescriptor) {
        this.f62454a = dynamicNodeTestDescriptor;
    }

    public final Object get() {
        return this.f62454a.getDisplayName();
    }
}
