package org.junit.jupiter.api;

import j$.util.function.Consumer;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f57107b;

    public /* synthetic */ b(AtomicInteger atomicInteger) {
        this.f57107b = atomicInteger;
    }

    public final void accept(Object obj) {
        this.f57107b.incrementAndGet();
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
