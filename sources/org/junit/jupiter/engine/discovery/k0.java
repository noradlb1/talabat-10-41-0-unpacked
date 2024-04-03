package org.junit.jupiter.engine.discovery;

import j$.util.function.Supplier;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class k0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TestDescriptor f62516a;

    public /* synthetic */ k0(TestDescriptor testDescriptor) {
        this.f62516a = testDescriptor;
    }

    public final Object get() {
        return MethodSelectorResolver.lambda$expansionCallback$7(this.f62516a);
    }
}
