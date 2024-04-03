package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;

public final class SingleDoOnError<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22827b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f22828c;

    public final class DoOnError implements SingleObserver<T> {
        private final SingleObserver<? super T> downstream;

        public DoOnError(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        public void onError(Throwable th2) {
            try {
                SingleDoOnError.this.f22828c.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.downstream.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            this.downstream.onSuccess(t11);
        }
    }

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.f22827b = singleSource;
        this.f22828c = consumer;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22827b.subscribe(new DoOnError(singleObserver));
    }
}
