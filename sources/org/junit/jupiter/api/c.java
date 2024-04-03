package org.junit.jupiter.api;

import j$.util.function.Consumer;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f57108b;

    public /* synthetic */ c(AtomicInteger atomicInteger) {
        this.f57108b = atomicInteger;
    }

    public final void accept(Object obj) {
        this.f57108b.incrementAndGet();
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
