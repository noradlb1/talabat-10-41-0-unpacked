package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.Preconditions;

class TimeoutInvocationFactory {
    private final ExtensionContext.Store store;

    public static abstract class ExecutorResource implements ExtensionContext.Store.CloseableResource {

        /* renamed from: a  reason: collision with root package name */
        public final ScheduledExecutorService f62583a;

        public ExecutorResource(ScheduledExecutorService scheduledExecutorService) {
            this.f62583a = scheduledExecutorService;
        }

        public ScheduledExecutorService a() {
            return this.f62583a;
        }

        public void close() throws Throwable {
            this.f62583a.shutdown();
            if (!this.f62583a.awaitTermination(5, TimeUnit.SECONDS)) {
                this.f62583a.shutdownNow();
                throw new JUnitException("Scheduled executor could not be stopped in an orderly manner");
            }
        }
    }

    public static class SingleThreadExecutorResource extends ExecutorResource {
        public SingleThreadExecutorResource() {
            super(Executors.newSingleThreadScheduledExecutor(new m0()));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Thread lambda$new$0(Runnable runnable) {
            Thread thread = new Thread(runnable, "junit-jupiter-timeout-watcher");
            thread.setPriority(10);
            return thread;
        }
    }

    public static class TimeoutInvocationParameters<T> {
        private final Supplier<String> descriptionSupplier;
        private final InvocationInterceptor.Invocation<T> invocation;
        private final TimeoutDuration timeout;

        /* JADX WARNING: type inference failed for: r4v0, types: [j$.util.function.Supplier<java.lang.String>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TimeoutInvocationParameters(org.junit.jupiter.api.extension.InvocationInterceptor.Invocation<T> r2, org.junit.jupiter.engine.extension.TimeoutDuration r3, j$.util.function.Supplier<java.lang.String> r4) {
            /*
                r1 = this;
                r1.<init>()
                java.lang.String r0 = "invocation must not be null"
                java.lang.Object r2 = org.junit.platform.commons.util.Preconditions.notNull(r2, (java.lang.String) r0)
                org.junit.jupiter.api.extension.InvocationInterceptor$Invocation r2 = (org.junit.jupiter.api.extension.InvocationInterceptor.Invocation) r2
                r1.invocation = r2
                java.lang.String r2 = "timeout must not be null"
                java.lang.Object r2 = org.junit.platform.commons.util.Preconditions.notNull(r3, (java.lang.String) r2)
                org.junit.jupiter.engine.extension.TimeoutDuration r2 = (org.junit.jupiter.engine.extension.TimeoutDuration) r2
                r1.timeout = r2
                java.lang.String r2 = "description supplier must not be null"
                java.lang.Object r2 = org.junit.platform.commons.util.Preconditions.notNull(r4, (java.lang.String) r2)
                j$.util.function.Supplier r2 = (j$.util.function.Supplier) r2
                r1.descriptionSupplier = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.engine.extension.TimeoutInvocationFactory.TimeoutInvocationParameters.<init>(org.junit.jupiter.api.extension.InvocationInterceptor$Invocation, org.junit.jupiter.engine.extension.TimeoutDuration, j$.util.function.Supplier):void");
        }

        public Supplier<String> getDescriptionSupplier() {
            return this.descriptionSupplier;
        }

        public InvocationInterceptor.Invocation<T> getInvocation() {
            return this.invocation;
        }

        public TimeoutDuration getTimeoutDuration() {
            return this.timeout;
        }
    }

    public TimeoutInvocationFactory(ExtensionContext.Store store2) {
        this.store = (ExtensionContext.Store) Preconditions.notNull(store2, "store must not be null");
    }

    private ScheduledExecutorService getThreadExecutorForSameThreadInvocation() {
        return ((SingleThreadExecutorResource) this.store.getOrComputeIfAbsent(SingleThreadExecutorResource.class)).a();
    }

    public <T> InvocationInterceptor.Invocation<T> a(Timeout.ThreadMode threadMode, TimeoutInvocationParameters<T> timeoutInvocationParameters) {
        boolean z11;
        Preconditions.notNull(threadMode, "thread mode must not be null");
        if (threadMode != Timeout.ThreadMode.INFERRED) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.condition(z11, "thread mode must not be INFERRED");
        Preconditions.notNull(timeoutInvocationParameters, "timeout invocation parameters must not be null");
        if (threadMode == Timeout.ThreadMode.SEPARATE_THREAD) {
            return new SeparateThreadTimeoutInvocation(timeoutInvocationParameters.getInvocation(), timeoutInvocationParameters.getTimeoutDuration(), timeoutInvocationParameters.getDescriptionSupplier());
        }
        return new SameThreadTimeoutInvocation(timeoutInvocationParameters.getInvocation(), timeoutInvocationParameters.getTimeoutDuration(), getThreadExecutorForSameThreadInvocation(), timeoutInvocationParameters.getDescriptionSupplier());
    }
}
