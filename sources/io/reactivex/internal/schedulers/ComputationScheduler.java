package io.reactivex.internal.schedulers;

import i.b;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {
    private static final String KEY_COMPUTATION_PRIORITY = "rx2.computation-priority";
    private static final String THREAD_NAME_PREFIX = "RxComputationThreadPool";

    /* renamed from: f  reason: collision with root package name */
    public static final FixedSchedulerPool f18465f;

    /* renamed from: g  reason: collision with root package name */
    public static final RxThreadFactory f18466g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f18467h = b(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: i  reason: collision with root package name */
    public static final PoolWorker f18468i;

    /* renamed from: d  reason: collision with root package name */
    public final ThreadFactory f18469d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<FixedSchedulerPool> f18470e;

    public static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {

        /* renamed from: b  reason: collision with root package name */
        public final int f18472b;

        /* renamed from: c  reason: collision with root package name */
        public final PoolWorker[] f18473c;

        /* renamed from: d  reason: collision with root package name */
        public long f18474d;

        public FixedSchedulerPool(int i11, ThreadFactory threadFactory) {
            this.f18472b = i11;
            this.f18473c = new PoolWorker[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                this.f18473c[i12] = new PoolWorker(threadFactory);
            }
        }

        public void createWorkers(int i11, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i12 = this.f18472b;
            if (i12 == 0) {
                for (int i13 = 0; i13 < i11; i13++) {
                    workerCallback.onWorker(i13, ComputationScheduler.f18468i);
                }
                return;
            }
            int i14 = ((int) this.f18474d) % i12;
            for (int i15 = 0; i15 < i11; i15++) {
                workerCallback.onWorker(i15, new EventLoopWorker(this.f18473c[i14]));
                i14++;
                if (i14 == i12) {
                    i14 = 0;
                }
            }
            this.f18474d = (long) i14;
        }

        public PoolWorker getEventLoop() {
            int i11 = this.f18472b;
            if (i11 == 0) {
                return ComputationScheduler.f18468i;
            }
            PoolWorker[] poolWorkerArr = this.f18473c;
            long j11 = this.f18474d;
            this.f18474d = 1 + j11;
            return poolWorkerArr[(int) (j11 % ((long) i11))];
        }

        public void shutdown() {
            for (PoolWorker dispose : this.f18473c) {
                dispose.dispose();
            }
        }
    }

    public static final class PoolWorker extends NewThreadWorker {
        public PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        f18468i = poolWorker;
        poolWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_COMPUTATION_PRIORITY, 5).intValue())), true);
        f18466g = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        f18465f = fixedSchedulerPool;
        fixedSchedulerPool.shutdown();
    }

    public ComputationScheduler() {
        this(f18466g);
    }

    public static int b(int i11, int i12) {
        return (i12 <= 0 || i12 > i11) ? i11 : i12;
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.f18470e.get().getEventLoop());
    }

    public void createWorkers(int i11, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.verifyPositive(i11, "number > 0 required");
        this.f18470e.get().createWorkers(i11, workerCallback);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j11, TimeUnit timeUnit) {
        return this.f18470e.get().getEventLoop().scheduleDirect(runnable, j11, timeUnit);
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        return this.f18470e.get().getEventLoop().schedulePeriodicallyDirect(runnable, j11, j12, timeUnit);
    }

    public void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        FixedSchedulerPool fixedSchedulerPool2;
        do {
            fixedSchedulerPool = this.f18470e.get();
            fixedSchedulerPool2 = f18465f;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
        } while (!b.a(this.f18470e, fixedSchedulerPool, fixedSchedulerPool2));
        fixedSchedulerPool.shutdown();
    }

    public void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(f18467h, this.f18469d);
        if (!b.a(this.f18470e, f18465f, fixedSchedulerPool)) {
            fixedSchedulerPool.shutdown();
        }
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f18469d = threadFactory;
        this.f18470e = new AtomicReference<>(f18465f);
        start();
    }

    public static final class EventLoopWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f18471b;
        private final ListCompositeDisposable both;
        private final PoolWorker poolWorker;
        private final ListCompositeDisposable serial;
        private final CompositeDisposable timed;

        public EventLoopWorker(PoolWorker poolWorker2) {
            this.poolWorker = poolWorker2;
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.serial = listCompositeDisposable;
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            this.timed = compositeDisposable;
            ListCompositeDisposable listCompositeDisposable2 = new ListCompositeDisposable();
            this.both = listCompositeDisposable2;
            listCompositeDisposable2.add(listCompositeDisposable);
            listCompositeDisposable2.add(compositeDisposable);
        }

        public void dispose() {
            if (!this.f18471b) {
                this.f18471b = true;
                this.both.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f18471b;
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            if (this.f18471b) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, 0, TimeUnit.MILLISECONDS, this.serial);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            if (this.f18471b) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, j11, timeUnit, this.timed);
        }
    }
}
