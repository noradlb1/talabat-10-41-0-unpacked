package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class TestScheduler extends Scheduler {

    /* renamed from: d  reason: collision with root package name */
    public final Queue<TimedRunnable> f23368d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f23369e;

    /* renamed from: f  reason: collision with root package name */
    public long f23370f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f23371g;

    public static final class TimedRunnable implements Comparable<TimedRunnable> {

        /* renamed from: b  reason: collision with root package name */
        public final long f23375b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f23376c;

        /* renamed from: d  reason: collision with root package name */
        public final TestWorker f23377d;

        /* renamed from: e  reason: collision with root package name */
        public final long f23378e;

        public TimedRunnable(TestWorker testWorker, long j11, Runnable runnable, long j12) {
            this.f23375b = j11;
            this.f23376c = runnable;
            this.f23377d = testWorker;
            this.f23378e = j12;
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", new Object[]{Long.valueOf(this.f23375b), this.f23376c.toString()});
        }

        public int compareTo(TimedRunnable timedRunnable) {
            long j11 = this.f23375b;
            long j12 = timedRunnable.f23375b;
            if (j11 == j12) {
                return Long.compare(this.f23378e, timedRunnable.f23378e);
            }
            return Long.compare(j11, j12);
        }
    }

    public TestScheduler() {
        this(false);
    }

    public void advanceTimeBy(long j11, TimeUnit timeUnit) {
        advanceTimeTo(this.f23371g + timeUnit.toNanos(j11), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j11, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j11));
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return new TestWorker();
    }

    public long now(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.f23371g, TimeUnit.NANOSECONDS);
    }

    public void triggerActions() {
        triggerActions(this.f23371g);
    }

    public TestScheduler(boolean z11) {
        this.f23368d = new PriorityBlockingQueue(11);
        this.f23369e = z11;
    }

    private void triggerActions(long j11) {
        while (true) {
            TimedRunnable peek = this.f23368d.peek();
            if (peek == null) {
                break;
            }
            long j12 = peek.f23375b;
            if (j12 > j11) {
                break;
            }
            if (j12 == 0) {
                j12 = this.f23371g;
            }
            this.f23371g = j12;
            this.f23368d.remove(peek);
            if (!peek.f23377d.f23372b) {
                peek.f23376c.run();
            }
        }
        this.f23371g = j11;
    }

    public TestScheduler(long j11, TimeUnit timeUnit) {
        this(j11, timeUnit, false);
    }

    public TestScheduler(long j11, TimeUnit timeUnit, boolean z11) {
        this.f23368d = new PriorityBlockingQueue(11);
        this.f23371g = timeUnit.toNanos(j11);
        this.f23369e = z11;
    }

    public final class TestWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public volatile boolean f23372b;

        public final class QueueRemove extends AtomicReference<TimedRunnable> implements Disposable {
            private static final long serialVersionUID = -7874968252110604360L;

            public QueueRemove(TimedRunnable timedRunnable) {
                lazySet(timedRunnable);
            }

            public void dispose() {
                TimedRunnable timedRunnable = (TimedRunnable) getAndSet((Object) null);
                if (timedRunnable != null) {
                    TestScheduler.this.f23368d.remove(timedRunnable);
                }
            }

            public boolean isDisposed() {
                return get() == null;
            }
        }

        public TestWorker() {
        }

        public void dispose() {
            this.f23372b = true;
        }

        public boolean isDisposed() {
            return this.f23372b;
        }

        public long now(@NonNull TimeUnit timeUnit) {
            return TestScheduler.this.now(timeUnit);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            if (this.f23372b) {
                return EmptyDisposable.INSTANCE;
            }
            if (TestScheduler.this.f23369e) {
                runnable = RxJavaPlugins.onSchedule(runnable);
            }
            long nanos = TestScheduler.this.f23371g + timeUnit.toNanos(j11);
            TestScheduler testScheduler = TestScheduler.this;
            long j12 = testScheduler.f23370f;
            testScheduler.f23370f = 1 + j12;
            TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j12);
            TestScheduler.this.f23368d.add(timedRunnable);
            return new QueueRemove(timedRunnable);
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            if (this.f23372b) {
                return EmptyDisposable.INSTANCE;
            }
            if (TestScheduler.this.f23369e) {
                runnable = RxJavaPlugins.onSchedule(runnable);
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j11 = testScheduler.f23370f;
            testScheduler.f23370f = 1 + j11;
            TimedRunnable timedRunnable = new TimedRunnable(this, 0, runnable, j11);
            TestScheduler.this.f23368d.add(timedRunnable);
            return new QueueRemove(timedRunnable);
        }
    }
}
