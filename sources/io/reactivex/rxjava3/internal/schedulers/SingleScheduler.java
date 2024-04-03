package io.reactivex.rxjava3.internal.schedulers;

import i.b;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler extends Scheduler {
    private static final String KEY_SINGLE_PRIORITY = "rx3.single-priority";
    private static final String THREAD_NAME_PREFIX = "RxSingleScheduler";

    /* renamed from: f  reason: collision with root package name */
    public static final RxThreadFactory f23087f = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_SINGLE_PRIORITY, 5).intValue())), true);

    /* renamed from: g  reason: collision with root package name */
    public static final ScheduledExecutorService f23088g;

    /* renamed from: d  reason: collision with root package name */
    public final ThreadFactory f23089d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService> f23090e;

    public static final class ScheduledWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public final ScheduledExecutorService f23091b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f23092c = new CompositeDisposable();

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f23093d;

        public ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.f23091b = scheduledExecutorService;
        }

        public void dispose() {
            if (!this.f23093d) {
                this.f23093d = true;
                this.f23092c.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f23093d;
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            Future future;
            if (this.f23093d) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), this.f23092c);
            this.f23092c.add(scheduledRunnable);
            if (j11 <= 0) {
                try {
                    future = this.f23091b.submit(scheduledRunnable);
                } catch (RejectedExecutionException e11) {
                    dispose();
                    RxJavaPlugins.onError(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f23091b.schedule(scheduledRunnable, j11, timeUnit);
            }
            scheduledRunnable.setFuture(future);
            return scheduledRunnable;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f23088g = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public SingleScheduler() {
        this(f23087f);
    }

    public static ScheduledExecutorService c(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.create(threadFactory);
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.f23090e.get());
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j11, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable), true);
        if (j11 <= 0) {
            try {
                future = this.f23090e.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e11) {
                RxJavaPlugins.onError(e11);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f23090e.get().schedule(scheduledDirectTask, j11, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Future future;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (j12 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f23090e.get();
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(onSchedule, scheduledExecutorService);
            if (j11 <= 0) {
                try {
                    future = scheduledExecutorService.submit(instantPeriodicTask);
                } catch (RejectedExecutionException e11) {
                    RxJavaPlugins.onError(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(instantPeriodicTask, j11, timeUnit);
            }
            instantPeriodicTask.a(future);
            return instantPeriodicTask;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(onSchedule, true);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f23090e.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e12) {
            RxJavaPlugins.onError(e12);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void shutdown() {
        AtomicReference<ScheduledExecutorService> atomicReference = this.f23090e;
        ScheduledExecutorService scheduledExecutorService = f23088g;
        ScheduledExecutorService andSet = atomicReference.getAndSet(scheduledExecutorService);
        if (andSet != scheduledExecutorService) {
            andSet.shutdownNow();
        }
    }

    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.f23090e.get();
            if (scheduledExecutorService != f23088g) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = c(this.f23089d);
            }
        } while (!b.a(this.f23090e, scheduledExecutorService, scheduledExecutorService2));
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f23090e = atomicReference;
        this.f23089d = threadFactory;
        atomicReference.lazySet(c(threadFactory));
    }
}
