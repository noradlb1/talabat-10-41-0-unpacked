package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f14479b = Boolean.getBoolean("rx2.scheduler.use-nanotime");

    /* renamed from: c  reason: collision with root package name */
    public static final long f14480c = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f14481b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final Worker f14482c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public Thread f14483d;

        public DisposeTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.f14481b = runnable;
            this.f14482c = worker;
        }

        public void dispose() {
            if (this.f14483d == Thread.currentThread()) {
                Worker worker = this.f14482c;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).shutdown();
                    return;
                }
            }
            this.f14482c.dispose();
        }

        public Runnable getWrappedRunnable() {
            return this.f14481b;
        }

        public boolean isDisposed() {
            return this.f14482c.isDisposed();
        }

        public void run() {
            this.f14483d = Thread.currentThread();
            try {
                this.f14481b.run();
            } finally {
                dispose();
                this.f14483d = null;
            }
        }
    }

    public static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f14484b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final Worker f14485c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f14486d;

        public PeriodicDirectTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.f14484b = runnable;
            this.f14485c = worker;
        }

        public void dispose() {
            this.f14486d = true;
            this.f14485c.dispose();
        }

        public Runnable getWrappedRunnable() {
            return this.f14484b;
        }

        public boolean isDisposed() {
            return this.f14486d;
        }

        public void run() {
            if (!this.f14486d) {
                try {
                    this.f14484b.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14485c.dispose();
                    throw ExceptionHelper.wrapOrThrow(th2);
                }
            }
        }
    }

    public static abstract class Worker implements Disposable {

        public final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            @NonNull

            /* renamed from: b  reason: collision with root package name */
            public final Runnable f14487b;
            @NonNull

            /* renamed from: c  reason: collision with root package name */
            public final SequentialDisposable f14488c;

            /* renamed from: d  reason: collision with root package name */
            public final long f14489d;

            /* renamed from: e  reason: collision with root package name */
            public long f14490e;

            /* renamed from: f  reason: collision with root package name */
            public long f14491f;

            /* renamed from: g  reason: collision with root package name */
            public long f14492g;

            public PeriodicTask(long j11, @NonNull Runnable runnable, long j12, @NonNull SequentialDisposable sequentialDisposable, long j13) {
                this.f14487b = runnable;
                this.f14488c = sequentialDisposable;
                this.f14489d = j13;
                this.f14491f = j12;
                this.f14492g = j11;
            }

            public Runnable getWrappedRunnable() {
                return this.f14487b;
            }

            public void run() {
                long j11;
                this.f14487b.run();
                if (!this.f14488c.isDisposed()) {
                    Worker worker = Worker.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long now = worker.now(timeUnit);
                    long j12 = Scheduler.f14480c;
                    long j13 = this.f14491f;
                    if (now + j12 >= j13) {
                        long j14 = this.f14489d;
                        if (now < j13 + j14 + j12) {
                            long j15 = this.f14492g;
                            long j16 = this.f14490e + 1;
                            this.f14490e = j16;
                            j11 = j15 + (j16 * j14);
                            this.f14491f = now;
                            this.f14488c.replace(Worker.this.schedule(this, j11 - now, timeUnit));
                        }
                    }
                    long j17 = this.f14489d;
                    long j18 = now + j17;
                    long j19 = this.f14490e + 1;
                    this.f14490e = j19;
                    this.f14492g = j18 - (j17 * j19);
                    j11 = j18;
                    this.f14491f = now;
                    this.f14488c.replace(Worker.this.schedule(this, j11 - now, timeUnit));
                }
            }
        }

        public long now(@NonNull TimeUnit timeUnit) {
            return Scheduler.a(timeUnit);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            return schedule(runnable, 0, TimeUnit.NANOSECONDS);
        }

        @NonNull
        public abstract Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit);

        @NonNull
        public Disposable schedulePeriodically(@NonNull Runnable runnable, long j11, long j12, @NonNull TimeUnit timeUnit) {
            long j13 = j11;
            TimeUnit timeUnit2 = timeUnit;
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            long nanos = timeUnit2.toNanos(j12);
            long now = now(TimeUnit.NANOSECONDS);
            SequentialDisposable sequentialDisposable3 = sequentialDisposable;
            PeriodicTask periodicTask = r0;
            PeriodicTask periodicTask2 = new PeriodicTask(now + timeUnit2.toNanos(j13), onSchedule, now, sequentialDisposable2, nanos);
            Disposable schedule = schedule(periodicTask, j13, timeUnit2);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            sequentialDisposable3.replace(schedule);
            return sequentialDisposable2;
        }
    }

    public static long a(TimeUnit timeUnit) {
        if (!f14479b) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
        return timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public static long clockDriftTolerance() {
        return f14480c;
    }

    @NonNull
    public abstract Worker createWorker();

    public long now(@NonNull TimeUnit timeUnit) {
        return a(timeUnit);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        return scheduleDirect(runnable, 0, TimeUnit.NANOSECONDS);
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j11, long j12, @NonNull TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(periodicDirectTask, j11, j12, timeUnit);
        if (schedulePeriodically == EmptyDisposable.INSTANCE) {
            return schedulePeriodically;
        }
        return periodicDirectTask;
    }

    public void shutdown() {
    }

    public void start() {
    }

    @NonNull
    public <S extends Scheduler & Disposable> S when(@NonNull Function<Flowable<Flowable<Completable>>, Completable> function) {
        return new SchedulerWhen(function, this);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.onSchedule(runnable), createWorker);
        createWorker.schedule(disposeTask, j11, timeUnit);
        return disposeTask;
    }
}
