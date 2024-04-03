package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@DoNotMock("Use FakeTimeLimiter")
public interface TimeLimiter {
    @CanIgnoreReturnValue
    @ParametricNullness
    <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j11, TimeUnit timeUnit) throws TimeoutException, ExecutionException;

    @CanIgnoreReturnValue
    @ParametricNullness
    <T> T callWithTimeout(Callable<T> callable, long j11, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException;

    <T> T newProxy(T t11, Class<T> cls, long j11, TimeUnit timeUnit);

    void runUninterruptiblyWithTimeout(Runnable runnable, long j11, TimeUnit timeUnit) throws TimeoutException;

    void runWithTimeout(Runnable runnable, long j11, TimeUnit timeUnit) throws TimeoutException, InterruptedException;
}
