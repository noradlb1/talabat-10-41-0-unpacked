package org.junit.jupiter.engine.extension;

import g30.h;
import j$.time.Duration;
import j$.util.function.Supplier;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import z20.f;

class SeparateThreadTimeoutInvocation<T> implements InvocationInterceptor.Invocation<T> {
    private final InvocationInterceptor.Invocation<T> delegate;
    private final Supplier<String> descriptionSupplier;
    private final TimeoutDuration timeout;

    public SeparateThreadTimeoutInvocation(InvocationInterceptor.Invocation<T> invocation, TimeoutDuration timeoutDuration, Supplier<String> supplier) {
        this.delegate = invocation;
        this.timeout = timeoutDuration;
        this.descriptionSupplier = supplier;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ TimeoutException lambda$proceed$0(Duration duration, Supplier supplier, Throwable th2) {
        TimeoutException a11 = TimeoutExceptionFactory.a((String) supplier.get(), this.timeout, (Throwable) null);
        a11.initCause(th2);
        return a11;
    }

    public T proceed() throws Throwable {
        Duration duration = this.timeout.toDuration();
        InvocationInterceptor.Invocation<T> invocation = this.delegate;
        Objects.requireNonNull(invocation);
        return Assertions.assertTimeoutPreemptively(duration, new h(invocation), this.descriptionSupplier, new e(this));
    }

    public /* synthetic */ void skip() {
        f.a(this);
    }
}
