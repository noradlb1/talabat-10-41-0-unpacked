package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class SingleDoOnSuccess<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18304b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f18305c;

    public final class DoOnSuccess implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18306b;

        public DoOnSuccess(SingleObserver<? super T> singleObserver) {
            this.f18306b = singleObserver;
        }

        public void onError(Throwable th2) {
            this.f18306b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f18306b.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            try {
                SingleDoOnSuccess.this.f18305c.accept(t11);
                this.f18306b.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18306b.onError(th2);
            }
        }
    }

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f18304b = singleSource;
        this.f18305c = consumer;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18304b.subscribe(new DoOnSuccess(singleObserver));
    }
}
