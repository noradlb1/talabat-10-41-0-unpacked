package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

public final class SingleMap<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18373b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends R> f18374c;

    public static final class MapSingleObserver<T, R> implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f18375b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f18376c;

        public MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.f18375b = singleObserver;
            this.f18376c = function;
        }

        public void onError(Throwable th2) {
            this.f18375b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f18375b.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            try {
                this.f18375b.onSuccess(ObjectHelper.requireNonNull(this.f18376c.apply(t11), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.f18373b = singleSource;
        this.f18374c = function;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f18373b.subscribe(new MapSingleObserver(singleObserver, this.f18374c));
    }
}
