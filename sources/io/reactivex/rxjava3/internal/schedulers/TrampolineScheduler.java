package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
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
            if (!this.worker.f23100d) {
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
                if (!this.worker.f23100d) {
                    this.run.run();
                }
            }
        }
    }

    public static final class TimedRunnable implements Comparable<TimedRunnable> {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f23094b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23095c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23096d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f23097e;

        public TimedRunnable(Runnable runnable, Long l11, int i11) {
            this.f23094b = runnable;
            this.f23095c = l11.longValue();
            this.f23096d = i11;
        }

        public int compareTo(TimedRunnable timedRunnable) {
            int compare = Long.compare(this.f23095c, timedRunnable.f23095c);
            return compare == 0 ? Integer.compare(this.f23096d, timedRunnable.f23096d) : compare;
        }
    }

    public static final class TrampolineWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public final PriorityBlockingQueue<TimedRunnable> f23098b = new PriorityBlockingQueue<>();

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f23099c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f23100d;
        private final AtomicInteger wip = new AtomicInteger();

        public final class AppendToQueueTask implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final TimedRunnable f23101b;

            public AppendToQueueTask(TimedRunnable timedRunnable) {
                this.f23101b = timedRunnable;
            }

            public void run() {
                this.f23101b.f23097e = true;
                TrampolineWorker.this.f23098b.remove(this.f23101b);
            }
        }

        public Disposable a(Runnable runnable, long j11) {
            if (this.f23100d) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j11), this.f23099c.incrementAndGet());
            this.f23098b.add(timedRunnable);
            if (this.wip.getAndIncrement() != 0) {
                return a.g(new AppendToQueueTask(timedRunnable));
            }
            int i11 = 1;
            while (!this.f23100d) {
                TimedRunnable poll = this.f23098b.poll();
                if (poll == null) {
                    i11 = this.wip.addAndGet(-i11);
                    if (i11 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.f23097e) {
                    poll.f23094b.run();
                }
            }
            this.f23098b.clear();
            return EmptyDisposable.INSTANCE;
        }

        public void dispose() {
            this.f23100d = true;
        }

        public boolean isDisposed() {
            return this.f23100d;
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
