package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import i9.b;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class AbstractIdleService implements Service {
    private final Service delegate = new DelegateService();
    /* access modifiers changed from: private */
    public final Supplier<String> threadNameSupplier = new ThreadNameSupplier();

    public final class DelegateService extends AbstractService {
        private DelegateService() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$doStart$0() {
            try {
                AbstractIdleService.this.startUp();
                notifyStarted();
            } catch (Throwable th2) {
                Platform.restoreInterruptIfIsInterruptedException(th2);
                notifyFailed(th2);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$doStop$1() {
            try {
                AbstractIdleService.this.shutDown();
                notifyStopped();
            } catch (Throwable th2) {
                Platform.restoreInterruptIfIsInterruptedException(th2);
                notifyFailed(th2);
            }
        }

        public final void doStart() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), (Supplier<String>) AbstractIdleService.this.threadNameSupplier).execute(new d(this));
        }

        public final void doStop() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), (Supplier<String>) AbstractIdleService.this.threadNameSupplier).execute(new c(this));
        }

        public String toString() {
            return AbstractIdleService.this.toString();
        }
    }

    public final class ThreadNameSupplier implements Supplier<String> {
        private ThreadNameSupplier() {
        }

        public String get() {
            return AbstractIdleService.this.serviceName() + " " + AbstractIdleService.this.state();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$executor$0(Runnable runnable) {
        MoreExecutors.newThread(this.threadNameSupplier.get(), runnable).start();
    }

    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public Executor executor() {
        return new b(this);
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public abstract void shutDown() throws Exception;

    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public abstract void startUp() throws Exception;

    public final Service.State state() {
        return this.delegate.state();
    }

    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    public final void awaitRunning(long j11, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(j11, timeUnit);
    }

    public final void awaitTerminated(long j11, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(j11, timeUnit);
    }
}
