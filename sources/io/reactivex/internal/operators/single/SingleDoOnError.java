package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class SingleDoOnError<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18293b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f18294c;

    public final class DoOnError implements SingleObserver<T> {
        private final SingleObserver<? super T> downstream;

        public DoOnError(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        public void onError(Throwable th2) {
            try {
                SingleDoOnError.this.f18294c.accept(th2);
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
        this.f18293b = singleSource;
        this.f18294c = consumer;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18293b.subscribe(new DoOnError(singleObserver));
    }
}
