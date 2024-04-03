package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;

public final class SingleDoOnSuccess<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22845b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f22846c;

    public final class DoOnSuccess implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22847b;

        public DoOnSuccess(SingleObserver<? super T> singleObserver) {
            this.f22847b = singleObserver;
        }

        public void onError(Throwable th2) {
            this.f22847b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22847b.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            try {
                SingleDoOnSuccess.this.f22846c.accept(t11);
                this.f22847b.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22847b.onError(th2);
            }
        }
    }

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f22845b = singleSource;
        this.f22846c = consumer;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22845b.subscribe(new DoOnSuccess(singleObserver));
    }
}
