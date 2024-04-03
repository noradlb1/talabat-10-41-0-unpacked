package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler extends Scheduler {

    /* renamed from: f  reason: collision with root package name */
    public static final Scheduler f18476f = Schedulers.single();

    /* renamed from: d  reason: collision with root package name */
    public final boolean f18477d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Executor f18478e;

    public final class DelayedDispose implements Runnable {

        /* renamed from: dr  reason: collision with root package name */
        private final DelayedRunnable f18480dr;

        public DelayedDispose(DelayedRunnable delayedRunnable) {
            this.f18480dr = delayedRunnable;
        }

        public void run() {
            DelayedRunnable delayedRunnable = this.f18480dr;
            delayedRunnable.f18482c.replace(ExecutorScheduler.this.scheduleDirect(delayedRunnable));
        }
    }

    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
        private static final long serialVersionUID = -4101336210206799084L;

        /* renamed from: b  reason: collision with root package name */
        public final SequentialDisposable f18481b = new SequentialDisposable();

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f18482c = new SequentialDisposable();

        public DelayedRunnable(Runnable runnable) {
            super(runnable);
        }

        public void dispose() {
            if (getAndSet((Object) null) != null) {
                this.f18481b.dispose();
                this.f18482c.dispose();
            }
        }

        public Runnable getWrappedRunnable() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                return runnable;
            }
            return Functions.EMPTY_RUNNABLE;
        }

        public boolean isDisposed() {
            return get() == null;
        }

        public void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet((Object) null);
                    SequentialDisposable sequentialDisposable = this.f18481b;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.f18482c.lazySet(disposableHelper);
                } catch (Throwable th2) {
                    lazySet((Object) null);
                    this.f18481b.lazySet(DisposableHelper.DISPOSED);
                    this.f18482c.lazySet(DisposableHelper.DISPOSED);
                    throw th2;
                }
            }
        }
    }

    public ExecutorScheduler(@NonNull Executor executor, boolean z11) {
        this.f18478e = executor;
        this.f18477d = z11;
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.f18478e, this.f18477d);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        try {
            if (this.f18478e instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule);
                scheduledDirectTask.setFuture(((ExecutorService) this.f18478e).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.f18477d) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(onSchedule, (DisposableContainer) null);
                this.f18478e.execute(interruptibleRunnable);
                return interruptibleRunnable;
            } else {
                ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(onSchedule);
                this.f18478e.execute(booleanRunnable);
                return booleanRunnable;
            }
        } catch (RejectedExecutionException e11) {
            RxJavaPlugins.onError(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        if (!(this.f18478e instanceof ScheduledExecutorService)) {
            return super.schedulePeriodicallyDirect(runnable, j11, j12, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.onSchedule(runnable));
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.f18478e).scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e11) {
            RxJavaPlugins.onError(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j11, TimeUnit timeUnit) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (this.f18478e instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) this.f18478e).schedule(scheduledDirectTask, j11, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e11) {
                RxJavaPlugins.onError(e11);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            DelayedRunnable delayedRunnable = new DelayedRunnable(onSchedule);
            delayedRunnable.f18481b.replace(f18476f.scheduleDirect(new DelayedDispose(delayedRunnable), j11, timeUnit));
            return delayedRunnable;
        }
    }

    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f18483b;

        /* renamed from: c  reason: collision with root package name */
        public final Executor f18484c;

        /* renamed from: d  reason: collision with root package name */
        public final MpscLinkedQueue<Runnable> f18485d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f18486e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f18487f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        public final CompositeDisposable f18488g = new CompositeDisposable();

        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;

            /* renamed from: b  reason: collision with root package name */
            public final Runnable f18489b;

            public BooleanRunnable(Runnable runnable) {
                this.f18489b = runnable;
            }

            public void dispose() {
                lazySet(true);
            }

            public boolean isDisposed() {
                return get();
            }

            public void run() {
                if (!get()) {
                    try {
                        this.f18489b.run();
                    } finally {
                        lazySet(true);
                    }
                }
            }
        }

        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
            private static final long serialVersionUID = -3603436687413320876L;

            /* renamed from: b  reason: collision with root package name */
            public final Runnable f18490b;

            /* renamed from: c  reason: collision with root package name */
            public final DisposableContainer f18491c;

            /* renamed from: d  reason: collision with root package name */
            public volatile Thread f18492d;

            public InterruptibleRunnable(Runnable runnable, DisposableContainer disposableContainer) {
                this.f18490b = runnable;
                this.f18491c = disposableContainer;
            }

            public void a() {
                DisposableContainer disposableContainer = this.f18491c;
                if (disposableContainer != null) {
                    disposableContainer.delete(this);
                }
            }

            public void dispose() {
                while (true) {
                    int i11 = get();
                    if (i11 < 2) {
                        if (i11 == 0) {
                            if (compareAndSet(0, 4)) {
                                a();
                                return;
                            }
                        } else if (compareAndSet(1, 3)) {
                            Thread thread = this.f18492d;
                            if (thread != null) {
                                thread.interrupt();
                                this.f18492d = null;
                            }
                            set(4);
                            a();
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            public boolean isDisposed() {
                return get() >= 2;
            }

            public void run() {
                if (get() == 0) {
                    this.f18492d = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.f18490b.run();
                            this.f18492d = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            this.f18492d = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                a();
                            }
                            throw th2;
                        }
                    } else {
                        this.f18492d = null;
                    }
                }
            }
        }

        public final class SequentialDispose implements Runnable {
            private final Runnable decoratedRun;
            private final SequentialDisposable mar;

            public SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.mar = sequentialDisposable;
                this.decoratedRun = runnable;
            }

            public void run() {
                this.mar.replace(ExecutorWorker.this.schedule(this.decoratedRun));
            }
        }

        public ExecutorWorker(Executor executor, boolean z11) {
            this.f18484c = executor;
            this.f18485d = new MpscLinkedQueue<>();
            this.f18483b = z11;
        }

        public void dispose() {
            if (!this.f18486e) {
                this.f18486e = true;
                this.f18488g.dispose();
                if (this.f18487f.getAndIncrement() == 0) {
                    this.f18485d.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f18486e;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r1 = r3.f18487f.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r3.f18486e == false) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0.clear();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                io.reactivex.internal.queue.MpscLinkedQueue<java.lang.Runnable> r0 = r3.f18485d
                r1 = 1
            L_0x0003:
                boolean r2 = r3.f18486e
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            L_0x000b:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L_0x0025
                boolean r2 = r3.f18486e
                if (r2 == 0) goto L_0x001b
                r0.clear()
                return
            L_0x001b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.f18487f
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L_0x0003
                return
            L_0x0025:
                r2.run()
                boolean r2 = r3.f18486e
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker.run():void");
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            Disposable disposable;
            if (this.f18486e) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            if (this.f18483b) {
                disposable = new InterruptibleRunnable(onSchedule, this.f18488g);
                this.f18488g.add(disposable);
            } else {
                disposable = new BooleanRunnable(onSchedule);
            }
            this.f18485d.offer(disposable);
            if (this.f18487f.getAndIncrement() == 0) {
                try {
                    this.f18484c.execute(this);
                } catch (RejectedExecutionException e11) {
                    this.f18486e = true;
                    this.f18485d.clear();
                    RxJavaPlugins.onError(e11);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return disposable;
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            if (j11 <= 0) {
                return schedule(runnable);
            }
            if (this.f18486e) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, RxJavaPlugins.onSchedule(runnable)), this.f18488g);
            this.f18488g.add(scheduledRunnable);
            Executor executor = this.f18484c;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule(scheduledRunnable, j11, timeUnit));
                } catch (RejectedExecutionException e11) {
                    this.f18486e = true;
                    RxJavaPlugins.onError(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new DisposeOnCancel(ExecutorScheduler.f18476f.scheduleDirect(scheduledRunnable, j11, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }
    }
}
