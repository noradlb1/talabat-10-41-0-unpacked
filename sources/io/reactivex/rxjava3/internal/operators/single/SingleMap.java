package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;

public final class SingleMap<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22931b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends R> f22932c;

    public static final class MapSingleObserver<T, R> implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f22933b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f22934c;

        public MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.f22933b = singleObserver;
            this.f22934c = function;
        }

        public void onError(Throwable th2) {
            this.f22933b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22933b.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f22934c.apply(t11);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                this.f22933b.onSuccess(apply);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.f22931b = singleSource;
        this.f22932c = function;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f22931b.subscribe(new MapSingleObserver(singleObserver, this.f22932c));
    }
}
