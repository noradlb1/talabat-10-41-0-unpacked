package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.concurrent.Callable;

public final class ObservableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17507b;

    /* renamed from: c  reason: collision with root package name */
    public final Callable<R> f17508c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f17509d;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f17507b = observableSource;
        this.f17508c = callable;
        this.f17509d = biFunction;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f17507b.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f17509d, ObjectHelper.requireNonNull(this.f17508c.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
