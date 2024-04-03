package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeoutException;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import z20.f;

class SameThreadTimeoutInvocation<T> implements InvocationInterceptor.Invocation<T> {
    private final InvocationInterceptor.Invocation<T> delegate;
    private final Supplier<String> descriptionSupplier;
    private final ScheduledExecutorService executor;
    private final TimeoutDuration timeout;

    public static class InterruptTask implements Runnable {
        /* access modifiers changed from: private */
        public volatile boolean executed;
        private final Thread thread;

        public InterruptTask(Thread thread2) {
            this.thread = thread2;
        }

        public void run() {
            this.executed = true;
            this.thread.interrupt();
        }
    }

    public SameThreadTimeoutInvocation(InvocationInterceptor.Invocation<T> invocation, TimeoutDuration timeoutDuration, ScheduledExecutorService scheduledExecutorService, Supplier<String> supplier) {
        this.delegate = invocation;
        this.timeout = timeoutDuration;
        this.executor = scheduledExecutorService;
        this.descriptionSupplier = supplier;
    }

    public T proceed() throws Throwable {
        T t11;
        TimeoutException timeoutException;
        InterruptTask interruptTask = new InterruptTask(Thread.currentThread());
        ScheduledFuture<?> schedule = this.executor.schedule(interruptTask, this.timeout.getValue(), this.timeout.getUnit());
        TimeoutException timeoutException2 = null;
        try {
            t11 = this.delegate.proceed();
            if (!schedule.cancel(false)) {
                schedule.get();
            }
            if (interruptTask.executed) {
                Thread.interrupted();
                timeoutException2 = TimeoutExceptionFactory.a(this.descriptionSupplier.get(), this.timeout, (Throwable) null);
            }
        } catch (Throwable th2) {
            if (!schedule.cancel(false)) {
                schedule.get();
            }
            if (interruptTask.executed) {
                Thread.interrupted();
                TimeoutExceptionFactory.a(this.descriptionSupplier.get(), this.timeout, (Throwable) null);
            }
            throw th2;
        }
        if (timeoutException2 == null) {
            return t11;
        }
        throw timeoutException2;
    }

    public /* synthetic */ void skip() {
        f.a(this);
    }
}
