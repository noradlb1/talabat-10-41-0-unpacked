package io.reactivex.rxjava3.internal.schedulers;

import i.b;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {
    private static final String KEY_COMPUTATION_PRIORITY = "rx3.computation-priority";
    private static final String THREAD_NAME_PREFIX = "RxComputationThreadPool";

    /* renamed from: f  reason: collision with root package name */
    public static final FixedSchedulerPool f23021f;

    /* renamed from: g  reason: collision with root package name */
    public static final RxThreadFactory f23022g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f23023h = c(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx3.computation-threads", 0).intValue());

    /* renamed from: i  reason: collision with root package name */
    public static final PoolWorker f23024i;

    /* renamed from: d  reason: collision with root package name */
    public final ThreadFactory f23025d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<FixedSchedulerPool> f23026e;

    public static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {

        /* renamed from: b  reason: collision with root package name */
        public final int f23028b;

        /* renamed from: c  reason: collision with root package name */
        public final PoolWorker[] f23029c;

        /* renamed from: d  reason: collision with root package name */
        public long f23030d;

        public FixedSchedulerPool(int i11, ThreadFactory threadFactory) {
            this.f23028b = i11;
            this.f23029c = new PoolWorker[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                this.f23029c[i12] = new PoolWorker(threadFactory);
            }
        }

        public void createWorkers(int i11, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i12 = this.f23028b;
            if (i12 == 0) {
                for (int i13 = 0; i13 < i11; i13++) {
                    workerCallback.onWorker(i13, ComputationScheduler.f23024i);
                }
                return;
            }
            int i14 = ((int) this.f23030d) % i12;
            for (int i15 = 0; i15 < i11; i15++) {
                workerCallback.onWorker(i15, new EventLoopWorker(this.f23029c[i14]));
                i14++;
                if (i14 == i12) {
                    i14 = 0;
                }
            }
            this.f23030d = (long) i14;
        }

        public PoolWorker getEventLoop() {
            int i11 = this.f23028b;
            if (i11 == 0) {
                return ComputationScheduler.f23024i;
            }
            PoolWorker[] poolWorkerArr = this.f23029c;
            long j11 = this.f23030d;
            this.f23030d = 1 + j11;
            return poolWorkerArr[(int) (j11 % ((long) i11))];
        }

        public void shutdown() {
            for (PoolWorker dispose : this.f23029c) {
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
        f23024i = poolWorker;
        poolWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory(THREAD_NAME_PREFIX, Math.max(1, Math.min(10, Integer.getInteger(KEY_COMPUTATION_PRIORITY, 5).intValue())), true);
        f23022g = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        f23021f = fixedSchedulerPool;
        fixedSchedulerPool.shutdown();
    }

    public ComputationScheduler() {
        this(f23022g);
    }

    public static int c(int i11, int i12) {
        return (i12 <= 0 || i12 > i11) ? i11 : i12;
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.f23026e.get().getEventLoop());
    }

    public void createWorkers(int i11, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.verifyPositive(i11, "number > 0 required");
        this.f23026e.get().createWorkers(i11, workerCallback);
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j11, TimeUnit timeUnit) {
        return this.f23026e.get().getEventLoop().scheduleDirect(runnable, j11, timeUnit);
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        return this.f23026e.get().getEventLoop().schedulePeriodicallyDirect(runnable, j11, j12, timeUnit);
    }

    public void shutdown() {
        AtomicReference<FixedSchedulerPool> atomicReference = this.f23026e;
        FixedSchedulerPool fixedSchedulerPool = f23021f;
        FixedSchedulerPool andSet = atomicReference.getAndSet(fixedSchedulerPool);
        if (andSet != fixedSchedulerPool) {
            andSet.shutdown();
        }
    }

    public void start() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(f23023h, this.f23025d);
        if (!b.a(this.f23026e, f23021f, fixedSchedulerPool)) {
            fixedSchedulerPool.shutdown();
        }
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f23025d = threadFactory;
        this.f23026e = new AtomicReference<>(f23021f);
        start();
    }

    public static final class EventLoopWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f23027b;
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
            if (!this.f23027b) {
                this.f23027b = true;
                this.both.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f23027b;
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            if (this.f23027b) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, 0, TimeUnit.MILLISECONDS, this.serial);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            if (this.f23027b) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, j11, timeUnit, this.timed);
        }
    }
}
