package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;

public final /* synthetic */ class y implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f62621a;

    public /* synthetic */ y(long j11) {
        this.f62621a = j11;
    }

    public final Object get() {
        return TimeoutDuration.lambda$new$0(this.f62621a);
    }
}
