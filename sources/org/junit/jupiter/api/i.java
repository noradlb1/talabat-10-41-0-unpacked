package org.junit.jupiter.api;

import j$.time.Duration;
import j$.util.function.Supplier;
import org.junit.jupiter.api.Assertions;

public final /* synthetic */ class i implements Assertions.TimeoutFailureFactory {
    public final Throwable createTimeoutFailure(Duration duration, Supplier supplier, Throwable th2) {
        return AssertTimeoutPreemptively.createAssertionFailure(duration, supplier, th2);
    }
}
