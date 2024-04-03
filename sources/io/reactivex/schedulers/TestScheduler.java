package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class TestScheduler extends Scheduler {

    /* renamed from: d  reason: collision with root package name */
    public final Queue<TimedRunnable> f23563d = new PriorityBlockingQueue(11);

    /* renamed from: e  reason: collision with root package name */
    public long f23564e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f23565f;

    public static final class TimedRunnable implements Comparable<TimedRunnable> {

        /* renamed from: b  reason: collision with root package name */
        public final long f23570b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f23571c;

        /* renamed from: d  reason: collision with root package name */
        public final TestWorker f23572d;

        /* renamed from: e  reason: collision with root package name */
        public final long f23573e;

        public TimedRunnable(TestWorker testWorker, long j11, Runnable runnable, long j12) {
            this.f23570b = j11;
            this.f23571c = runnable;
            this.f23572d = testWorker;
            this.f23573e = j12;
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", new Object[]{Long.valueOf(this.f23570b), this.f23571c.toString()});
        }

        public int compareTo(TimedRunnable timedRunnable) {
            long j11 = this.f23570b;
            long j12 = timedRunnable.f23570b;
            if (j11 == j12) {
                return ObjectHelper.compare(this.f23573e, timedRunnable.f23573e);
            }
            return ObjectHelper.compare(j11, j12);
        }
    }

    public TestScheduler() {
    }

    public void advanceTimeBy(long j11, TimeUnit timeUnit) {
        advanceTimeTo(this.f23565f + timeUnit.toNanos(j11), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j11, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j11));
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new TestWorker();
    }

    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.f23565f, TimeUnit.NANOSECONDS);
    }

    public void triggerActions() {
        triggerActions(this.f23565f);
    }

    private void triggerActions(long j11) {
        while (true) {
            TimedRunnable peek = this.f23563d.peek();
            if (peek == null) {
                break;
            }
            long j12 = peek.f23570b;
            if (j12 > j11) {
                break;
            }
            if (j12 == 0) {
                j12 = this.f23565f;
            }
            this.f23565f = j12;
            this.f23563d.remove(peek);
            if (!peek.f23572d.f23566b) {
                peek.f23571c.run();
            }
        }
        this.f23565f = j11;
    }

    public TestScheduler(long j11, TimeUnit timeUnit) {
        this.f23565f = timeUnit.toNanos(j11);
    }

    public final class TestWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f23566b;

        public final class QueueRemove implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final TimedRunnable f23568b;

            public QueueRemove(TimedRunnable timedRunnable) {
                this.f23568b = timedRunnable;
            }

            public void run() {
                TestScheduler.this.f23563d.remove(this.f23568b);
            }
        }

        public TestWorker() {
        }

        public void dispose() {
            this.f23566b = true;
        }

        public boolean isDisposed() {
            return this.f23566b;
        }

        public long now(@NonNull TimeUnit timeUnit) {
            return TestScheduler.this.now(timeUnit);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            if (this.f23566b) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = TestScheduler.this.f23565f + timeUnit.toNanos(j11);
            TestScheduler testScheduler = TestScheduler.this;
            long j12 = testScheduler.f23564e;
            testScheduler.f23564e = 1 + j12;
            TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j12);
            TestScheduler.this.f23563d.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            if (this.f23566b) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j11 = testScheduler.f23564e;
            testScheduler.f23564e = 1 + j11;
            TimedRunnable timedRunnable = new TimedRunnable(this, 0, runnable, j11);
            TestScheduler.this.f23563d.add(timedRunnable);
            return Disposables.fromRunnable(new QueueRemove(timedRunnable));
        }
    }
}
