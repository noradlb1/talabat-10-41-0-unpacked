package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;

public final class ImmediateThinScheduler extends Scheduler {
    public static final Scheduler INSTANCE = new ImmediateThinScheduler();

    /* renamed from: d  reason: collision with root package name */
    public static final Scheduler.Worker f18494d = new ImmediateThinWorker();

    /* renamed from: e  reason: collision with root package name */
    public static final Disposable f18495e;

    static {
        Disposable empty = Disposables.empty();
        f18495e = empty;
        empty.dispose();
    }

    private ImmediateThinScheduler() {
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return f18494d;
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        runnable.run();
        return f18495e;
    }

    @NonNull
    public Disposable schedulePeriodicallyDirect(@NonNull Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    public static final class ImmediateThinWorker extends Scheduler.Worker {
        public void dispose() {
        }

        public boolean isDisposed() {
            return false;
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable) {
            runnable.run();
            return ImmediateThinScheduler.f18495e;
        }

        @NonNull
        public Disposable schedulePeriodically(@NonNull Runnable runnable, long j11, long j12, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }

        @NonNull
        public Disposable schedule(@NonNull Runnable runnable, long j11, @NonNull TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable, long j11, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }
}
