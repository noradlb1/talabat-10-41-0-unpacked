package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableAutoConnect;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt;
import io.reactivex.internal.operators.flowable.FlowablePublishClassic;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableFlowable<T> extends Flowable<T> {
    private ConnectableFlowable<T> onRefCount() {
        if (!(this instanceof FlowablePublishClassic)) {
            return this;
        }
        FlowablePublishClassic flowablePublishClassic = (FlowablePublishClassic) this;
        return RxJavaPlugins.onAssembly(new FlowablePublishAlt(flowablePublishClassic.publishSource(), flowablePublishClassic.publishBufferSize()));
    }

    @NonNull
    public Flowable<T> autoConnect() {
        return autoConnect(1);
    }

    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @NonNull
    @SchedulerSupport("none")
    public Flowable<T> refCount() {
        return RxJavaPlugins.onAssembly(new FlowableRefCount(onRefCount()));
    }

    @NonNull
    public Flowable<T> autoConnect(int i11) {
        return autoConnect(i11, Functions.emptyConsumer());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final Flowable<T> refCount(int i11) {
        return refCount(i11, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    @NonNull
    public Flowable<T> autoConnect(int i11, @NonNull Consumer<? super Disposable> consumer) {
        if (i11 > 0) {
            return RxJavaPlugins.onAssembly(new FlowableAutoConnect(this, i11, consumer));
        }
        connect(consumer);
        return RxJavaPlugins.onAssembly(this);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> refCount(long j11, TimeUnit timeUnit) {
        return refCount(1, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public final Flowable<T> refCount(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return refCount(1, j11, timeUnit, scheduler);
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    public final Flowable<T> refCount(int i11, long j11, TimeUnit timeUnit) {
        return refCount(i11, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    public final Flowable<T> refCount(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i11, "subscriberCount");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new FlowableRefCount(onRefCount(), i11, j11, timeUnit, scheduler));
    }
}
