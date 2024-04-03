package org.junit.jupiter.api;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.function.ThrowingSupplier;

public final /* synthetic */ class j implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f57150b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ThrowingSupplier f57151c;

    public /* synthetic */ j(AtomicReference atomicReference, ThrowingSupplier throwingSupplier) {
        this.f57150b = atomicReference;
        this.f57151c = throwingSupplier;
    }

    public final Object call() {
        return AssertTimeoutPreemptively.lambda$submitTask$3(this.f57150b, this.f57151c);
    }
}
