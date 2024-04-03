package io.reactivex.internal.schedulers;

import i.b;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
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
    private static final String KEY_IO_PRIORITY = "rx2.io-priority";
    private static final String KEY_KEEP_ALIVE_TIME = "rx2.io-keep-alive-time";
    private static final String KEY_SCHEDULED_RELEASE = "rx2.io-scheduled-release";
    private static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler";

    /* renamed from: f  reason: collision with root package name */
    public static final RxThreadFactory f18502f;

    /* renamed from: g  reason: collision with root package name */
    public static final RxThreadFactory f18503g;

    /* renamed from: h  reason: collision with root package name */
    public static final ThreadWorker f18504h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f18505i = Boolean.getBoolean(KEY_SCHEDULED_RELEASE);

    /* renamed from: j  reason: collision with root package name */
    public static final CachedWorkerPool f18506j;

    /* renamed from: d  reason: collision with root package name */
    public final ThreadFactory f18507d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<CachedWorkerPool> f18508e;

    public static final class CachedWorkerPool implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CompositeDisposable f18509b;
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
            this.f18509b = new CompositeDisposable();
            this.threadFactory = threadFactory2;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.f18503g);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j13, j13, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = scheduledFuture;
        }

        public void a() {
            if (!this.expiringWorkerQueue.isEmpty()) {
                long c11 = c();
                Iterator<ThreadWorker> it = this.expiringWorkerQueue.iterator();
                while (it.hasNext()) {
                    ThreadWorker next = it.next();
                    if (next.getExpirationTime() > c11) {
                        return;
                    }
                    if (this.expiringWorkerQueue.remove(next)) {
                        this.f18509b.remove(next);
                    }
                }
            }
        }

        public ThreadWorker b() {
            if (this.f18509b.isDisposed()) {
                return IoScheduler.f18504h;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                ThreadWorker poll = this.expiringWorkerQueue.poll();
                if (poll != null) {
                    return poll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.threadFactory);
            this.f18509b.add(threadWorker);
            return threadWorker;
        }

        public long c() {
            return System.nanoTime();
        }

        public void d(ThreadWorker threadWorker) {
            threadWorker.setExpirationTime(c() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(threadWorker);
        }

        public void e() {
            this.f18509b.dispose();
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
            a();
        }
    }

    public static final class EventLoopWorker extends Scheduler.Worker implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicBoolean f18510b = new AtomicBoolean();
        private final CachedWorkerPool pool;
        private final CompositeDisposable tasks;
        private final ThreadWorker threadWorker;

        public EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.tasks = new CompositeDisposable();
            this.threadWorker = cachedWorkerPool.b();
        }

        public void dispose() {
            if (this.f18510b.compareAndSet(false, true)) {
                this.tasks.dispose();
                if (IoScheduler.f18505i) {
                    this.threadWorker.scheduleActual(this, 0, TimeUnit.NANOSECONDS, (DisposableContainer) null);
                    return;
                }
                this.pool.d(this.threadWorker);
            }
        }

        public boolean isDisposed() {
            return this.f18510b.get();
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
        private long expirationTime = 0;

        public ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public void setExpirationTime(long j11) {
            this.expirationTime = j11;
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f18504h = threadWorker;
        threadWorker.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger(KEY_IO_PRIORITY, 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory(WORKER_THREAD_NAME_PREFIX, max);
        f18502f = rxThreadFactory;
        f18503g = new RxThreadFactory(EVICTOR_THREAD_NAME_PREFIX, max);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0, (TimeUnit) null, rxThreadFactory);
        f18506j = cachedWorkerPool;
        cachedWorkerPool.e();
    }

    public IoScheduler() {
        this(f18502f);
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.f18508e.get());
    }

    public void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        CachedWorkerPool cachedWorkerPool2;
        do {
            cachedWorkerPool = this.f18508e.get();
            cachedWorkerPool2 = f18506j;
            if (cachedWorkerPool == cachedWorkerPool2) {
                return;
            }
        } while (!b.a(this.f18508e, cachedWorkerPool, cachedWorkerPool2));
        cachedWorkerPool.e();
    }

    public int size() {
        return this.f18508e.get().f18509b.size();
    }

    public void start() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT, this.f18507d);
        if (!b.a(this.f18508e, f18506j, cachedWorkerPool)) {
            cachedWorkerPool.e();
        }
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f18507d = threadFactory;
        this.f18508e = new AtomicReference<>(f18506j);
        start();
    }
}
