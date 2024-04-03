package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;

public final /* synthetic */ class w implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimeoutConfiguration f62619a;

    public /* synthetic */ w(TimeoutConfiguration timeoutConfiguration) {
        this.f62619a = timeoutConfiguration;
    }

    public final Object get() {
        return this.f62619a.getDefaultTestableMethodTimeout();
    }
}
