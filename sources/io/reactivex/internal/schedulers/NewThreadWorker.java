package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class NewThreadWorker extends Scheduler.Worker {

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f18512b;
    private final ScheduledExecutorService executor;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.executor = SchedulerPoolFactory.create(threadFactory);
    }

    public void dispose() {
        if (!this.f18512b) {
            this.f18512b = true;
            this.executor.shutdownNow();
        }
    }

    public boolean isDisposed() {
        return this.f18512b;
    }

    @NonNull
    public Disposable schedule(@NonNull Runnable runnable) {
        return schedule(runnable, 0, (TimeUnit) null);
    }

    @NonNull
    public ScheduledRunnable scheduleActual(Runnable runnable, long j11, @NonNull TimeUnit timeUnit, @Nullable DisposableContainer disposableContainer) {
        Future future;
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.onSchedule(runnable), disposableContainer);
        if (disposableContainer != null && !disposableContainer.add(scheduledRunnable)) {
            return scheduledRunnable;
        }
        if (j11 <= 0) {
            try {
                future = this.executor.submit(scheduledRunnable);
            } catch (RejectedExecutionException e11) {
                if (disposableContainer != null) {
                    disposableContainer.remove(scheduledRunnable);
                }
                RxJavaPlugins.onError(e11);
            }
        } else {
            future = this.executor.schedule(scheduledRunnable, j11, timeUnit);
        }
        scheduledRunnable.setFuture(future);
        return scheduledRunnable;
    }

    public Disposable scheduleDirect(Runnable runnable, long j11, TimeUnit timeUnit) {
        Future future;
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.onSchedule(runnable));
        if (j11 <= 0) {
            try {
                future = this.executor.submit(scheduledDirectTask);
            } catch (RejectedExecutionException e11) {
                RxJavaPlugins.onError(e11);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            future = this.executor.schedule(scheduledDirectTask, j11, timeUnit);
        }
        scheduledDirectTask.setFuture(future);
        return scheduledDirectTask;
    }

    public Disposable schedulePeriodicallyDirect(Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        Future future;
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (j12 <= 0) {
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(onSchedule, this.executor);
            if (j11 <= 0) {
                try {
                    future = this.executor.submit(instantPeriodicTask);
                } catch (RejectedExecutionException e11) {
                    RxJavaPlugins.onError(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                future = this.executor.schedule(instantPeriodicTask, j11, timeUnit);
            }
            instantPeriodicTask.a(future);
            return instantPeriodicTask;
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(onSchedule);
        try {
            scheduledDirectPeriodicTask.setFuture(this.executor.scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e12) {
            RxJavaPlugins.onError(e12);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void shutdown() {
        if (!this.f18512b) {
            this.f18512b = true;
            this.executor.shutdown();
        }
    }

    @NonNull
    public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
        if (this.f18512b) {
            return EmptyDisposable.INSTANCE;
        }
        return scheduleActual(runnable, j11, timeUnit, (DisposableContainer) null);
    }
}
