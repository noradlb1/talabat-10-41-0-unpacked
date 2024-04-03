package io.reactivex.rxjava3.observables;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.operators.observable.ObservableAutoConnect;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRefCount;
import io.reactivex.rxjava3.internal.util.ConnectConsumer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class ConnectableObservable<T> extends Observable<T> {
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Observable<T> autoConnect() {
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

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Observable<T> refCount() {
        return RxJavaPlugins.onAssembly(new ObservableRefCount(this));
    }

    @SchedulerSupport("none")
    public abstract void reset();

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Observable<T> autoConnect(int i11) {
        return autoConnect(i11, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> refCount(int i11) {
        return refCount(i11, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public Observable<T> autoConnect(int i11, @NonNull Consumer<? super Disposable> consumer) {
        Objects.requireNonNull(consumer, "connection is null");
        if (i11 > 0) {
            return RxJavaPlugins.onAssembly(new ObservableAutoConnect(this, i11, consumer));
        }
        connect(consumer);
        return RxJavaPlugins.onAssembly(this);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> refCount(long j11, @NonNull TimeUnit timeUnit) {
        return refCount(1, j11, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> refCount(long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return refCount(1, j11, timeUnit, scheduler);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> refCount(int i11, long j11, @NonNull TimeUnit timeUnit) {
        return refCount(i11, j11, timeUnit, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> refCount(int i11, long j11, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.verifyPositive(i11, "observerCount");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableRefCount(this, i11, j11, timeUnit, scheduler));
    }
}
