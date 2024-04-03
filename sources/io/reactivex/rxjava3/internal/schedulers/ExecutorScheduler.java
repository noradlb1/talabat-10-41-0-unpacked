package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutorScheduler extends Scheduler {

    /* renamed from: d  reason: collision with root package name */
    public final boolean f23032d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f23033e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Executor f23034f;

    public final class DelayedDispose implements Runnable {

        /* renamed from: dr  reason: collision with root package name */
        private final DelayedRunnable f23036dr;

        public DelayedDispose(DelayedRunnable delayedRunnable) {
            this.f23036dr = delayedRunnable;
        }

        public void run() {
            DelayedRunnable delayedRunnable = this.f23036dr;
            delayedRunnable.f23038c.replace(ExecutorScheduler.this.scheduleDirect(delayedRunnable));
        }
    }

    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
        private static final long serialVersionUID = -4101336210206799084L;

        /* renamed from: b  reason: collision with root package name */
        public final SequentialDisposable f23037b = new SequentialDisposable();

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f23038c = new SequentialDisposable();

        public DelayedRunnable(Runnable runnable) {
            super(runnable);
        }

        public void dispose() {
            if (getAndSet((Object) null) != null) {
                this.f23037b.dispose();
                this.f23038c.dispose();
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
                    SequentialDisposable sequentialDisposable = this.f23037b;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.f23038c.lazySet(disposableHelper);
                } catch (Throwable th2) {
                    RxJavaPlugins.onError(th2);
                    throw th2;
                }
            }
        }
    }

    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f23051a = Schedulers.single();
    }

    public ExecutorScheduler(@NonNull Executor executor, boolean z11, boolean z12) {
        this.f23034f = executor;
        this.f23032d = z11;
        this.f23033e = z12;
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.f23034f, this.f23032d, this.f23033e);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        try {
            if (this.f23034f instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule, this.f23032d);
                scheduledDirectTask.setFuture(((ExecutorService) this.f23034f).submit(scheduledDirectTask));
                return scheduledDirectTask;
            } else if (this.f23032d) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(onSchedule, (DisposableContainer) null);
                this.f23034f.execute(interruptibleRunnable);
                return interruptibleRunnable;
            } else {
                ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(onSchedule);
                this.f23034f.execute(booleanRunnable);
                return booleanRunnable;
            }
        } catch (RejectedExecutionException e11) {
            RxJavaPlugins.onError(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        if (!(this.f23034f instanceof ScheduledExecutorService)) {
            return super.schedulePeriodicallyDirect(runnable, j11, j12, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.onSchedule(runnable), this.f23032d);
            scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) this.f23034f).scheduleAtFixedRate(scheduledDirectPeriodicTask, j11, j12, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e11) {
            RxJavaPlugins.onError(e11);
            return EmptyDisposable.INSTANCE;
        }
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j11, TimeUnit timeUnit) {
        Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
        if (this.f23034f instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(onSchedule, this.f23032d);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) this.f23034f).schedule(scheduledDirectTask, j11, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e11) {
                RxJavaPlugins.onError(e11);
                return EmptyDisposable.INSTANCE;
            }
        } else {
            DelayedRunnable delayedRunnable = new DelayedRunnable(onSchedule);
            delayedRunnable.f23037b.replace(SingleHolder.f23051a.scheduleDirect(new DelayedDispose(delayedRunnable), j11, timeUnit));
            return delayedRunnable;
        }
    }

    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f23039b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f23040c;

        /* renamed from: d  reason: collision with root package name */
        public final Executor f23041d;

        /* renamed from: e  reason: collision with root package name */
        public final MpscLinkedQueue<Runnable> f23042e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f23043f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f23044g = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        public final CompositeDisposable f23045h = new CompositeDisposable();

        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;

            /* renamed from: b  reason: collision with root package name */
            public final Runnable f23046b;

            public BooleanRunnable(Runnable runnable) {
                this.f23046b = runnable;
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
                        this.f23046b.run();
                        lazySet(true);
                    } catch (Throwable th2) {
                        lazySet(true);
                        throw th2;
                    }
                }
            }
        }

        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
            private static final long serialVersionUID = -3603436687413320876L;

            /* renamed from: b  reason: collision with root package name */
            public final Runnable f23047b;

            /* renamed from: c  reason: collision with root package name */
            public final DisposableContainer f23048c;

            /* renamed from: d  reason: collision with root package name */
            public volatile Thread f23049d;

            public InterruptibleRunnable(Runnable runnable, DisposableContainer disposableContainer) {
                this.f23047b = runnable;
                this.f23048c = disposableContainer;
            }

            public void a() {
                DisposableContainer disposableContainer = this.f23048c;
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
                            Thread thread = this.f23049d;
                            if (thread != null) {
                                thread.interrupt();
                                this.f23049d = null;
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
                    this.f23049d = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.f23047b.run();
                            this.f23049d = null;
                            if (compareAndSet(1, 2)) {
                                a();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            this.f23049d = null;
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
                        this.f23049d = null;
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

        public ExecutorWorker(Executor executor, boolean z11, boolean z12) {
            this.f23041d = executor;
            this.f23042e = new MpscLinkedQueue<>();
            this.f23039b = z11;
            this.f23040c = z12;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r1 = r3.f23044g.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r3.f23043f == false) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0.clear();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r3 = this;
                io.reactivex.rxjava3.internal.queue.MpscLinkedQueue<java.lang.Runnable> r0 = r3.f23042e
                r1 = 1
            L_0x0003:
                boolean r2 = r3.f23043f
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            L_0x000b:
                java.lang.Object r2 = r0.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 != 0) goto L_0x0025
                boolean r2 = r3.f23043f
                if (r2 == 0) goto L_0x001b
                r0.clear()
                return
            L_0x001b:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.f23044g
                int r1 = -r1
                int r1 = r2.addAndGet(r1)
                if (r1 != 0) goto L_0x0003
                return
            L_0x0025:
                r2.run()
                boolean r2 = r3.f23043f
                if (r2 == 0) goto L_0x000b
                r0.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler.ExecutorWorker.a():void");
        }

        public void b() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.f23042e;
            if (this.f23043f) {
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.poll().run();
            if (this.f23043f) {
                mpscLinkedQueue.clear();
            } else if (this.f23044g.decrementAndGet() != 0) {
                this.f23041d.execute(this);
            }
        }

        public void dispose() {
            if (!this.f23043f) {
                this.f23043f = true;
                this.f23045h.dispose();
                if (this.f23044g.getAndIncrement() == 0) {
                    this.f23042e.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f23043f;
        }

        public void run() {
            if (this.f23040c) {
                b();
            } else {
                a();
            }
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            Disposable disposable;
            if (this.f23043f) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable onSchedule = RxJavaPlugins.onSchedule(runnable);
            if (this.f23039b) {
                disposable = new InterruptibleRunnable(onSchedule, this.f23045h);
                this.f23045h.add(disposable);
            } else {
                disposable = new BooleanRunnable(onSchedule);
            }
            this.f23042e.offer(disposable);
            if (this.f23044g.getAndIncrement() == 0) {
                try {
                    this.f23041d.execute(this);
                } catch (RejectedExecutionException e11) {
                    this.f23043f = true;
                    this.f23042e.clear();
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
            if (this.f23043f) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, RxJavaPlugins.onSchedule(runnable)), this.f23045h);
            this.f23045h.add(scheduledRunnable);
            Executor executor = this.f23041d;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule(scheduledRunnable, j11, timeUnit));
                } catch (RejectedExecutionException e11) {
                    this.f23043f = true;
                    RxJavaPlugins.onError(e11);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new DisposeOnCancel(SingleHolder.f23051a.scheduleDirect(scheduledRunnable, j11, timeUnit)));
            }
            sequentialDisposable.replace(scheduledRunnable);
            return sequentialDisposable2;
        }
    }
}
