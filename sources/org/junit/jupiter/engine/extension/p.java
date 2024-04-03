package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;

public final /* synthetic */ class p implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimeoutConfiguration f62611a;

    public /* synthetic */ p(TimeoutConfiguration timeoutConfiguration) {
        this.f62611a = timeoutConfiguration;
    }

    public final Object get() {
        return this.f62611a.getDefaultTimeout();
    }
}
