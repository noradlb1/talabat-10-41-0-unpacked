package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;

public final /* synthetic */ class x implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimeoutConfiguration f62620a;

    public /* synthetic */ x(TimeoutConfiguration timeoutConfiguration) {
        this.f62620a = timeoutConfiguration;
    }

    public final Object get() {
        return this.f62620a.getDefaultLifecycleMethodTimeout();
    }
}
