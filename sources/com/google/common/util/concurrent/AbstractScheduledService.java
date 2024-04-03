package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class AbstractScheduledService implements Service {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    /* access modifiers changed from: private */
    public final AbstractService delegate = new ServiceDelegate();

    public interface Cancellable {
        void cancel(boolean z11);

        boolean isCancelled();
    }

    public static abstract class CustomScheduler extends Scheduler {

        public final class ReschedulableCallable implements Callable<Void> {
            @CheckForNull
            @GuardedBy("lock")
            private SupplantableFuture cancellationDelegate;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock = new ReentrantLock();

            /* renamed from: service  reason: collision with root package name */
            private final AbstractService f44700service;
            private final Runnable wrappedRunnable;

            public ReschedulableCallable(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.wrappedRunnable = runnable;
                this.executor = scheduledExecutorService;
                this.f44700service = abstractService;
            }

            @GuardedBy("lock")
            private Cancellable initializeOrUpdateCancellationDelegate(Schedule schedule) {
                SupplantableFuture supplantableFuture = this.cancellationDelegate;
                if (supplantableFuture == null) {
                    SupplantableFuture supplantableFuture2 = new SupplantableFuture(this.lock, submitToExecutor(schedule));
                    this.cancellationDelegate = supplantableFuture2;
                    return supplantableFuture2;
                }
                if (!supplantableFuture.currentFuture.isCancelled()) {
                    Future unused = this.cancellationDelegate.currentFuture = submitToExecutor(schedule);
                }
                return this.cancellationDelegate;
            }

            private ScheduledFuture<Void> submitToExecutor(Schedule schedule) {
                return this.executor.schedule(this, schedule.delay, schedule.unit);
            }

            @CanIgnoreReturnValue
            public Cancellable reschedule() {
                Throwable th2;
                Cancellable cancellable;
                try {
                    Schedule nextSchedule = CustomScheduler.this.getNextSchedule();
                    this.lock.lock();
                    try {
                        cancellable = initializeOrUpdateCancellationDelegate(nextSchedule);
                        this.lock.unlock();
                        th2 = null;
                    } catch (Error | RuntimeException e11) {
                        th2 = e11;
                        cancellable = new FutureAsCancellable(Futures.immediateCancelledFuture());
                        this.lock.unlock();
                    } catch (Throwable th3) {
                        this.lock.unlock();
                        throw th3;
                    }
                    if (th2 != null) {
                        this.f44700service.notifyFailed(th2);
                    }
                    return cancellable;
                } catch (Throwable th4) {
                    Platform.restoreInterruptIfIsInterruptedException(th4);
                    this.f44700service.notifyFailed(th4);
                    return new FutureAsCancellable(Futures.immediateCancelledFuture());
                }
            }

            @CheckForNull
            public Void call() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }
        }

        public static final class Schedule {
            /* access modifiers changed from: private */
            public final long delay;
            /* access modifiers changed from: private */
            public final TimeUnit unit;

            public Schedule(long j11, TimeUnit timeUnit) {
                this.delay = j11;
                this.unit = (TimeUnit) Preconditions.checkNotNull(timeUnit);
            }
        }

        public static final class SupplantableFuture implements Cancellable {
            /* access modifiers changed from: private */
            @GuardedBy("lock")
            public Future<Void> currentFuture;
            private final ReentrantLock lock;

            public SupplantableFuture(ReentrantLock reentrantLock, Future<Void> future) {
                this.lock = reentrantLock;
                this.currentFuture = future;
            }

            public void cancel(boolean z11) {
                this.lock.lock();
                try {
                    this.currentFuture.cancel(z11);
                } finally {
                    this.lock.unlock();
                }
            }

            public boolean isCancelled() {
                this.lock.lock();
                try {
                    return this.currentFuture.isCancelled();
                } finally {
                    this.lock.unlock();
                }
            }
        }

        public CustomScheduler() {
            super();
        }

        public abstract Schedule getNextSchedule() throws Exception;

        public final Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            return new ReschedulableCallable(abstractService, scheduledExecutorService, runnable).reschedule();
        }
    }

    public static final class FutureAsCancellable implements Cancellable {
        private final Future<?> delegate;

        public FutureAsCancellable(Future<?> future) {
            this.delegate = future;
        }

        public void cancel(boolean z11) {
            this.delegate.cancel(z11);
        }

        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }
    }

    public static abstract class Scheduler {
        private Scheduler() {
        }

        public static Scheduler newFixedDelaySchedule(long j11, long j12, TimeUnit timeUnit) {
            boolean z11;
            Preconditions.checkNotNull(timeUnit);
            if (j12 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "delay must be > 0, found %s", j12);
            final long j13 = j11;
            final long j14 = j12;
            final TimeUnit timeUnit2 = timeUnit;
            return new Scheduler() {
                public Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return new FutureAsCancellable(scheduledExecutorService.scheduleWithFixedDelay(runnable, j13, j14, timeUnit2));
                }
            };
        }

        public static Scheduler newFixedRateSchedule(long j11, long j12, TimeUnit timeUnit) {
            boolean z11;
            Preconditions.checkNotNull(timeUnit);
            if (j12 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "period must be > 0, found %s", j12);
            final long j13 = j11;
            final long j14 = j12;
            final TimeUnit timeUnit2 = timeUnit;
            return new Scheduler() {
                public Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return new FutureAsCancellable(scheduledExecutorService.scheduleAtFixedRate(runnable, j13, j14, timeUnit2));
                }
            };
        }

        public abstract Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);
    }

    public final class ServiceDelegate extends AbstractService {
        @CheckForNull
        private volatile ScheduledExecutorService executorService;
        /* access modifiers changed from: private */
        public final ReentrantLock lock;
        /* access modifiers changed from: private */
        @CheckForNull
        public volatile Cancellable runningTask;
        private final Runnable task;

        public class Task implements Runnable {
            public Task() {
            }

            public void run() {
                ServiceDelegate.this.lock.lock();
                try {
                    Cancellable access$300 = ServiceDelegate.this.runningTask;
                    Objects.requireNonNull(access$300);
                    if (access$300.isCancelled()) {
                        ServiceDelegate.this.lock.unlock();
                        return;
                    }
                    AbstractScheduledService.this.runOneIteration();
                    ServiceDelegate.this.lock.unlock();
                } catch (Throwable th2) {
                    ServiceDelegate.this.lock.unlock();
                    throw th2;
                }
            }
        }

        private ServiceDelegate() {
            this.lock = new ReentrantLock();
            this.task = new Task();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String lambda$doStart$0() {
            return AbstractScheduledService.this.serviceName() + " " + state();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$doStart$1() {
            this.lock.lock();
            try {
                AbstractScheduledService.this.startUp();
                Objects.requireNonNull(this.executorService);
                this.runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, this.executorService, this.task);
                notifyStarted();
            } catch (Throwable th2) {
                this.lock.unlock();
                throw th2;
            }
            this.lock.unlock();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$doStop$2() {
            try {
                this.lock.lock();
                if (state() != Service.State.STOPPING) {
                    this.lock.unlock();
                    return;
                }
                AbstractScheduledService.this.shutDown();
                this.lock.unlock();
                notifyStopped();
            } catch (Throwable th2) {
                Platform.restoreInterruptIfIsInterruptedException(th2);
                notifyFailed(th2);
            }
        }

        public final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), (Supplier<String>) new f(this));
            this.executorService.execute(new g(this));
        }

        public final void doStop() {
            Objects.requireNonNull(this.runningTask);
            Objects.requireNonNull(this.executorService);
            this.runningTask.cancel(false);
            this.executorService.execute(new e(this));
        }

        public String toString() {
            return AbstractScheduledService.this.toString();
        }
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

    public ScheduledExecutorService executor() {
        final ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
            }
        });
        addListener(new Service.Listener(this) {
            public void failed(Service.State state, Throwable th2) {
                newSingleThreadScheduledExecutor.shutdown();
            }

            public void terminated(Service.State state) {
                newSingleThreadScheduledExecutor.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return newSingleThreadScheduledExecutor;
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public abstract void runOneIteration() throws Exception;

    public abstract Scheduler scheduler();

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public void shutDown() throws Exception {
    }

    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public void startUp() throws Exception {
    }

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
