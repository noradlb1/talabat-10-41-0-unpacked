package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TrampolineScheduler extends Scheduler {
    private static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    public static final class SleepingRunnable implements Runnable {
        private final long execTime;
        private final Runnable run;
        private final TrampolineWorker worker;

        public SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j11) {
            this.run = runnable;
            this.worker = trampolineWorker;
            this.execTime = j11;
        }

        public void run() {
            if (!this.worker.f18543d) {
                long now = this.worker.now(TimeUnit.MILLISECONDS);
                long j11 = this.execTime;
                if (j11 > now) {
                    try {
                        Thread.sleep(j11 - now);
                    } catch (InterruptedException e11) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.onError(e11);
                        return;
                    }
                }
                if (!this.worker.f18543d) {
                    this.run.run();
                }
            }
        }
    }

    public static final class TimedRunnable implements Comparable<TimedRunnable> {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f18537b;

        /* renamed from: c  reason: collision with root package name */
        public final long f18538c;

        /* renamed from: d  reason: collision with root package name */
        public final int f18539d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f18540e;

        public TimedRunnable(Runnable runnable, Long l11, int i11) {
            this.f18537b = runnable;
            this.f18538c = l11.longValue();
            this.f18539d = i11;
        }

        public int compareTo(TimedRunnable timedRunnable) {
            int compare = ObjectHelper.compare(this.f18538c, timedRunnable.f18538c);
            return compare == 0 ? ObjectHelper.compare(this.f18539d, timedRunnable.f18539d) : compare;
        }
    }

    public static final class TrampolineWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public final PriorityBlockingQueue<TimedRunnable> f18541b = new PriorityBlockingQueue<>();

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f18542c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f18543d;
        private final AtomicInteger wip = new AtomicInteger();

        public final class AppendToQueueTask implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final TimedRunnable f18544b;

            public AppendToQueueTask(TimedRunnable timedRunnable) {
                this.f18544b = timedRunnable;
            }

            public void run() {
                this.f18544b.f18540e = true;
                TrampolineWorker.this.f18541b.remove(this.f18544b);
            }
        }

        public Disposable a(Runnable runnable, long j11) {
            if (this.f18543d) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j11), this.f18542c.incrementAndGet());
            this.f18541b.add(timedRunnable);
            if (this.wip.getAndIncrement() != 0) {
                return Disposables.fromRunnable(new AppendToQueueTask(timedRunnable));
            }
            int i11 = 1;
            while (!this.f18543d) {
                TimedRunnable poll = this.f18541b.poll();
                if (poll == null) {
                    i11 = this.wip.addAndGet(-i11);
                    if (i11 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.f18540e) {
                    poll.f18537b.run();
                }
            }
            this.f18541b.clear();
            return EmptyDisposable.INSTANCE;
        }

        public void dispose() {
            this.f18543d = true;
        }

        public boolean isDisposed() {
            return this.f18543d;
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            return a(runnable, now(TimeUnit.MILLISECONDS));
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            long now = now(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j11);
            return a(new SleepingRunnable(runnable, this, now), now);
        }
    }

    public static TrampolineScheduler instance() {
        return INSTANCE;
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new TrampolineWorker();
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        RxJavaPlugins.onSchedule(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j11, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j11);
            RxJavaPlugins.onSchedule(runnable).run();
        } catch (InterruptedException e11) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.onError(e11);
        }
        return EmptyDisposable.INSTANCE;
    }
}
