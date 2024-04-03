package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.Objects;

public final class ObservableReduceWithSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f22046b;

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<R> f22047c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f22048d;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        this.f22046b = observableSource;
        this.f22047c = supplier;
        this.f22048d = biFunction;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            R r11 = this.f22047c.get();
            Objects.requireNonNull(r11, "The seedSupplier returned a null value");
            this.f22046b.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f22048d, r11));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
