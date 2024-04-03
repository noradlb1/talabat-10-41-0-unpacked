package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class FakeTimeLimiter implements TimeLimiter {
    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j11, TimeUnit timeUnit) throws ExecutionException {
        return callWithTimeout(callable, j11, timeUnit);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T callWithTimeout(Callable<T> callable, long j11, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        try {
            return callable.call();
        } catch (RuntimeException e11) {
            throw new UncheckedExecutionException((Throwable) e11);
        } catch (Exception e12) {
            Platform.restoreInterruptIfIsInterruptedException(e12);
            throw new ExecutionException(e12);
        } catch (Error e13) {
            throw new ExecutionError(e13);
        }
    }

    @CanIgnoreReturnValue
    public <T> T newProxy(T t11, Class<T> cls, long j11, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t11);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        return t11;
    }

    public void runUninterruptiblyWithTimeout(Runnable runnable, long j11, TimeUnit timeUnit) {
        runWithTimeout(runnable, j11, timeUnit);
    }

    public void runWithTimeout(Runnable runnable, long j11, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        try {
            runnable.run();
        } catch (RuntimeException e11) {
            throw new UncheckedExecutionException((Throwable) e11);
        } catch (Error e12) {
            throw new ExecutionError(e12);
        }
    }
}
