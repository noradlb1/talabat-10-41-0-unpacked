package org.junit.jupiter.engine.extension;

import j$.time.Duration;
import j$.util.function.Supplier;
import org.junit.jupiter.api.Assertions;

public final /* synthetic */ class e implements Assertions.TimeoutFailureFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SeparateThreadTimeoutInvocation f62591a;

    public /* synthetic */ e(SeparateThreadTimeoutInvocation separateThreadTimeoutInvocation) {
        this.f62591a = separateThreadTimeoutInvocation;
    }

    public final Throwable createTimeoutFailure(Duration duration, Supplier supplier, Throwable th2) {
        return this.f62591a.lambda$proceed$0(duration, supplier, th2);
    }
}
