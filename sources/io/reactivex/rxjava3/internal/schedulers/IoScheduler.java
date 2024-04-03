package io.reactivex.rxjava3.internal.schedulers;

import i.b;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class IoScheduler extends Scheduler {
    private static final String EVICTOR_THREAD_NAME_PREFIX = "RxCachedWorkerPoolEvictor";
    private static final long KEEP_ALIVE_TIME = Long.getLong(KEY_KEEP_ALIVE_TIME, 60).longValue();
    public static final long KEEP_ALIVE_TIME_DEFAULT = 60;
    private static final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    private static final String KEY_IO_PRIORITY = "rx3.io-priority";
    private static final String KEY_KEEP_ALIVE_TIME = "rx3.io-keep-alive-time";
    private static final String KEY_SCHEDULED_RELEASE = "rx3.io-scheduled-release";
    private static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler";

    /* renamed from: f  reason: collision with root package name */
    public static final RxThreadFactory f23060f;

    /* renamed from: g  reason: collision with root package name */
    public static final RxThreadFactory f23061g;

    /* renamed from: h  reason: collision with root package name */
    public static final ThreadWorker f23062h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f23063i = Boolean.getBoolean(KEY_SCHEDULED_RELEASE);

    /* renamed from: j  reason: collision with root package name */
    public static final CachedWorkerPool f23064j;

    /* renamed from: d  reason: collision with root package name */
    public final ThreadFactory f23065d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<CachedWorkerPool> f23066e;

    public static final class CachedWorkerPool implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CompositeDisposable f23067b;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        public CachedWorkerPool(long j11, TimeUnit timeUnit, ThreadFactory threadFactory2) {
            long j12;
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            if (timeUnit != null) {
                j12 = timeUnit.toNanos(j11);
            } else {
                j12 = 0;
            }
            long j13 = j12;
            this.keepAliveTime = j13;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.f23067b = new CompositeDisposable();
            this.threadFactory = threadFactory2;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f23061g);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j13, j13, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = scheduledFuture;
        }

        public static void a(ConcurrentLinkedQueue<ThreadWorker> concurrentLinkedQueue, CompositeDisposable compositeDisposable) {
            if (!concurrentLinkedQueue.isEmpty()) {
                long c11 = c();
                Iterator<ThreadWorker> it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ThreadWorker next = it.next();
                    if (next.getExpirationTime() > c11) {
                        return;
                    }
                    if (concurrentLinkedQueue.remove(next)) {
                        compositeDisposable.remove(next);
                    }
                }
            }
        }

        public static long c() {
            return System.nanoTime();
        }

        public ThreadWorker b() {
            if (this.f23067b.isDisposed()) {
                return IoScheduler.f23062h;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                ThreadWorker poll = this.expiringWorkerQueue.poll();
                if (poll != null) {
                    return poll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.threadFactory);
            this.f23067b.add(threadWorker);
            return threadWorker;
        }

        public void d(ThreadWorker threadWorker) {
            threadWorker.setExpirationTime(c() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(threadWorker);
        }

        public void e() {
            this.f23067b.dispose();
            Future<?> future = this.evictorTask;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.evictorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        public void run() {
            a(this.expiringWorkerQueue, this.f23067b);
        }
    }

    public static final class EventLoopWorker extends Scheduler.Worker implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f23068b = new AtomicBoolean();
        private final CachedWorkerPool pool;
        private final CompositeDisposable tasks;
        private final ThreadWorker threadWorker;

        public EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.tasks = new CompositeDisposable();
            this.threadWorker = cachedWorkerPool.b();
        }

        public void dispose() {
            if (this.f23068b.compareAndSet(false, true)) {
                this.tasks.dispose();
                if (IoScheduler.f23063i) {
                    this.threadWorker.scheduleActual(this, 0, TimeUnit.NANOSECONDS, (DisposableContainer) null);
                    return;
                }
                this.pool.d(this.threadWorker);
            }
        }

        public boolean isDisposed() {
            return this.f23068b.get();
        }

        public void run() {
            this.pool.d(this.threadWorker);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            if (this.tasks.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.threadWorker.scheduleActual(runnable, j11, timeUnit, this.tasks);
        }
    }

    public static final class ThreadWorker extends NewThreadWorker {

        /* renamed from: c  reason: collision with root package name */
        public long f23069c = 0;

        public ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long getExpirationTime() {
            return this.f23069c;
        }

        public void setExpirationTime(long j11) {
            this.f23069c = j11;
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f23062h = threadWorker;
        threadWorker.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger(KEY_IO_PRIORITY, 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory(WORKER_THREAD_NAME_PREFIX, max);
        f23060f = rxThreadFactory;
        f23061g = new RxThreadFactory(EVICTOR_THREAD_NAME_PREFIX, max);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0, (TimeUnit) null, rxThreadFactory);
        f23064j = cachedWorkerPool;
        cachedWorkerPool.e();
    }

    public IoScheduler() {
        this(f23060f);
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.f23066e.get());
    }

    public void shutdown() {
        AtomicReference<CachedWorkerPool> atomicReference = this.f23066e;
        CachedWorkerPool cachedWorkerPool = f23064j;
        CachedWorkerPool andSet = atomicReference.getAndSet(cachedWorkerPool);
        if (andSet != cachedWorkerPool) {
            andSet.e();
        }
    }

    public int size() {
        return this.f23066e.get().f23067b.size();
    }

    public void start() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT, this.f23065d);
        if (!b.a(this.f23066e, f23064j, cachedWorkerPool)) {
            cachedWorkerPool.e();
        }
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f23065d = threadFactory;
        this.f23066e = new AtomicReference<>(f23064j);
        start();
    }
}
