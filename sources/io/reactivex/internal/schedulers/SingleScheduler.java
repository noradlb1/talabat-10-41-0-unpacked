package io.reactivex.internal.schedulers;

import i.b;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleScheduler extends Scheduler {
    private static final String KEY_SINGLE_PRIORITY = "rx2.single-priority";
    private static final String THREAD_NAME_PREFIX = "RxSingleScheduler";

    /* renamed from: f  reason: collision with root package name */
    public static final RxThreadFactory f18530f = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_SINGLE_PRIORITY, 5).intValue())), true);

    /* renamed from: g  reason: collision with root package name */
    public static final ScheduledExecutorService f18531g;

    /* renamed from: d  reason: collision with root package name */
    public final ThreadFactory f18532d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService> f18533e;

    public static final class ScheduledWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public final ScheduledExecutorService f18534b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f18535c = new CompositeDisposable();

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f18536d;

        public ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.f18534b = scheduledExecutorService;
        }

        public void dispose() {
            if (!this.f18536d) {
                this.f18536d = true;
                this.f18535c.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f18536d;
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            Future future;
            if (this.f18536d) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), this.f18535c);
            this.f18535c.add(scheduledRunnable);
            if (j11 <= 0) {
                try {
                    future = this.f18534b.submit(scheduledRunnable);
                } catch (RejectedExecutionException e11) {
                    dispose();
                    RxJavaPlugins.onError(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.f18534b.schedule(scheduledRunnable, j11, timeUnit);
            }
            scheduledRunnable.setFuture(future);
            return scheduledRunnable;
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f18531g = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public SingleScheduler() {
        this(f18530f);
    }

    public static ScheduledExecutorService b(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.create(threadFactory);
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.f18533e.get());
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j11, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable));
        if (j11 <= 0) {
            try {
                future = this.f18533e.get().submit(scheduledDirectTask);
            } catch (RejectedExecutionException e11) {
                RxJavaPlugins.onError(e11);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.f18533e.get().schedule(scheduledDirectTask, j11, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Future future;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (j12 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f18533e.get();
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
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(onSchedule);
        try {
            scheduledDirectPeriodicTask.setFuture(this.f18533e.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e12) {
            RxJavaPlugins.onError(e12);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void shutdown() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.f18533e.get();
        ScheduledExecutorService scheduledExecutorService2 = f18531g;
        if (scheduledExecutorService != scheduledExecutorService2 && (andSet = this.f18533e.getAndSet(scheduledExecutorService2)) != scheduledExecutorService2) {
            andSet.shutdownNow();
        }
    }

    public void start() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.f18533e.get();
            if (scheduledExecutorService != f18531g) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = b(this.f18532d);
            }
        } while (!b.a(this.f18533e, scheduledExecutorService, scheduledExecutorService2));
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f18533e = atomicReference;
        this.f18532d = threadFactory;
        atomicReference.lazySet(b(threadFactory));
    }
}
