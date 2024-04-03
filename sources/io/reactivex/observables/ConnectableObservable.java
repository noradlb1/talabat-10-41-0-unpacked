package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableAutoConnect;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservablePublishClassic;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableObservable<T> extends Observable<T> {
    private ConnectableObservable<T> onRefCount() {
        if (this instanceof ObservablePublishClassic) {
            return RxJavaPlugins.onAssembly(new ObservablePublishAlt(((ObservablePublishClassic) this).publishSource()));
        }
        return this;
    }

    @NonNull
    public Observable<T> autoConnect() {
        return autoConnect(1);
    }

    public final Disposable connect() {
        ConnectConsumer connectConsumer = new ConnectConsumer();
        connect(connectConsumer);
        return connectConsumer.disposable;
    }

    public abstract void connect(@NonNull Consumer<? super Disposable> consumer);

    @CheckReturnValue
    @NonNull
    @SchedulerSupport("none")
    public Observable<T> refCount() {
        return RxJavaPlugins.onAssembly(new ObservableRefCount(onRefCount()));
    }

    @NonNull
    public Observable<T> autoConnect(int i11) {
        return autoConnect(i11, Functions.emptyConsumer());
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final Observable<T> refCount(int i11) {
        return refCount(i11, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    @NonNull
    public Observable<T> autoConnect(int i11, @NonNull Consumer<? super Disposable> consumer) {
        if (i11 > 0) {
            return RxJavaPlugins.onAssembly(new ObservableAutoConnect(this, i11, consumer));
        }
        connect(consumer);
        return RxJavaPlugins.onAssembly(this);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> refCount(long j11, TimeUnit timeUnit) {
        return refCount(1, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> refCount(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return refCount(1, j11, timeUnit, scheduler);
    }

    @CheckReturnValue
    @SchedulerSupport("io.reactivex:computation")
    public final Observable<T> refCount(int i11, long j11, TimeUnit timeUnit) {
        return refCount(i11, j11, timeUnit, Schedulers.computation());
    }

    @CheckReturnValue
    @SchedulerSupport("custom")
    public final Observable<T> refCount(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.verifyPositive(i11, "subscriberCount");
        ObjectHelper.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableRefCount(onRefCount(), i11, j11, timeUnit, scheduler));
    }
}
