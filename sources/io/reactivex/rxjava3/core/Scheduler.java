package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.schedulers.NewThreadWorker;
import io.reactivex.rxjava3.internal.schedulers.SchedulerWhen;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f18767b = Boolean.getBoolean("rx3.scheduler.use-nanotime");

    /* renamed from: c  reason: collision with root package name */
    public static final long f18768c = a(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    public static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f18769b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final Worker f18770c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public Thread f18771d;

        public DisposeTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.f18769b = runnable;
            this.f18770c = worker;
        }

        public void dispose() {
            if (this.f18771d == Thread.currentThread()) {
                Worker worker = this.f18770c;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).shutdown();
                    return;
                }
            }
            this.f18770c.dispose();
        }

        public Runnable getWrappedRunnable() {
            return this.f18769b;
        }

        public boolean isDisposed() {
            return this.f18770c.isDisposed();
        }

        public void run() {
            this.f18771d = Thread.currentThread();
            try {
                this.f18769b.run();
                dispose();
                this.f18771d = null;
            } catch (Throwable th2) {
                dispose();
                this.f18771d = null;
                throw th2;
            }
        }
    }

    public static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f18772b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final Worker f18773c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f18774d;

        public PeriodicDirectTask(@NonNull Runnable runnable, @NonNull Worker worker) {
            this.f18772b = runnable;
            this.f18773c = worker;
        }

        public void dispose() {
            this.f18774d = true;
            this.f18773c.dispose();
        }

        public Runnable getWrappedRunnable() {
            return this.f18772b;
        }

        public boolean isDisposed() {
            return this.f18774d;
        }

        public void run() {
            if (!this.f18774d) {
                try {
                    this.f18772b.run();
                } catch (Throwable th2) {
                    dispose();
                    RxJavaPlugins.onError(th2);
                    throw th2;
                }
            }
        }
    }

    public static abstract class Worker implements Disposable {

        public final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {
            @NonNull

            /* renamed from: b  reason: collision with root package name */
            public final Runnable f18775b;
            @NonNull

            /* renamed from: c  reason: collision with root package name */
            public final SequentialDisposable f18776c;

            /* renamed from: d  reason: collision with root package name */
            public final long f18777d;

            /* renamed from: e  reason: collision with root package name */
            public long f18778e;

            /* renamed from: f  reason: collision with root package name */
            public long f18779f;

            /* renamed from: g  reason: collision with root package name */
            public long f18780g;

            public PeriodicTask(long j11, @NonNull Runnable runnable, long j12, @NonNull SequentialDisposable sequentialDisposable, long j13) {
                this.f18775b = runnable;
                this.f18776c = sequentialDisposable;
                this.f18777d = j13;
                this.f18779f = j12;
                this.f18780g = j11;
            }

            public Runnable getWrappedRunnable() {
                return this.f18775b;
            }

            public void run() {
                long j11;
                this.f18775b.run();
                if (!this.f18776c.isDisposed()) {
                    Worker worker = Worker.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long now = worker.now(timeUnit);
                    long j12 = Scheduler.f18768c;
                    long j13 = this.f18779f;
                    if (now + j12 >= j13) {
                        long j14 = this.f18777d;
                        if (now < j13 + j14 + j12) {
                            long j15 = this.f18780g;
                            long j16 = this.f18778e + 1;
                            this.f18778e = j16;
                            j11 = j15 + (j16 * j14);
                            this.f18779f = now;
                            this.f18776c.replace(Worker.this.schedule(this, j11 - now, timeUnit));
                        }
                    }
                    long j17 = this.f18777d;
                    long j18 = now + j17;
                    long j19 = this.f18778e + 1;
                    this.f18778e = j19;
                    this.f18780g = j18 - (j17 * j19);
                    j11 = j18;
                    this.f18779f = now;
                    this.f18776c.replace(Worker.this.schedule(this, j11 - now, timeUnit));
                }
            }
        }

        public long now(@NonNull TimeUnit timeUnit) {
            return Scheduler.b(timeUnit);
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

    public static long a(long j11, String str) {
        if ("seconds".equalsIgnoreCase(str)) {
            return TimeUnit.SECONDS.toNanos(j11);
        }
        if ("milliseconds".equalsIgnoreCase(str)) {
            return TimeUnit.MILLISECONDS.toNanos(j11);
        }
        return TimeUnit.MINUTES.toNanos(j11);
    }

    public static long b(TimeUnit timeUnit) {
        if (!f18767b) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
        return timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public static long clockDriftTolerance() {
        return f18768c;
    }

    @NonNull
    public abstract Worker createWorker();

    public long now(@NonNull TimeUnit timeUnit) {
        return b(timeUnit);
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
        Objects.requireNonNull(function, "combine is null");
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
