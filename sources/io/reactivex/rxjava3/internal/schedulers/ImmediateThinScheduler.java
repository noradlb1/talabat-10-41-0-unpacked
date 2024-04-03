package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import java.util.concurrent.TimeUnit;

public final class ImmediateThinScheduler extends Scheduler {
    public static final Scheduler INSTANCE = new ImmediateThinScheduler();

    /* renamed from: d  reason: collision with root package name */
    public static final Scheduler.Worker f23052d = new ImmediateThinWorker();

    /* renamed from: e  reason: collision with root package name */
    public static final Disposable f23053e;

    static {
        Disposable b11 = a.b();
        f23053e = b11;
        b11.dispose();
    }

    private ImmediateThinScheduler() {
    }

    @NonNull
    public Scheduler.Worker createWorker() {
        return f23052d;
    }

    @NonNull
    public Disposable scheduleDirect(@NonNull Runnable runnable) {
        runnable.run();
        return f23053e;
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
            return ImmediateThinScheduler.f23053e;
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
