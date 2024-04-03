package io.reactivex.rxjava3.flowables;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableAutoConnect;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRefCount;
import io.reactivex.rxjava3.internal.util.ConnectConsumer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableFlowable<T> extends Flowable<T> {
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Flowable<T> autoConnect() {
        return autoConnect(1);
    }

    @NonNull
    @SchedulerSupport("none")
    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    @SchedulerSupport("none")
    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Flowable<T> refCount() {
        return RxJavaPlugins.onAssembly(new FlowableRefCount(this));
    }

    @SchedulerSupport("none")
    public abstract void reset();

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Flowable<T> autoConnect(int i11) {
        return autoConnect(i11, Functions.emptyConsumer());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> refCount(int i11) {
        return refCount(i11, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Flowable<T> autoConnect(int i11, @NonNull Consumer<? super Disposable> consumer) {
        Objects.requireNonNull(consumer, "connection is null");
        if (i11 > 0) {
            return RxJavaPlugins.onAssembly(new FlowableAutoConnect(this, i11, consumer));
        }
        connect(consumer);
        return RxJavaPlugins.onAssembly(this);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> refCount(long j11, @NonNull TimeUnit timeUnit) {
        return refCount(1, j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> refCount(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return refCount(1, j11, timeUnit, scheduler);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> refCount(int i11, long j11, @NonNull TimeUnit timeUnit) {
        return refCount(i11, j11, timeUnit, Schedulers.computation());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> refCount(int i11, long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.verifyPositive(i11, "subscriberCount");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableRefCount(this, i11, j11, timeUnit, scheduler));
    }
}
