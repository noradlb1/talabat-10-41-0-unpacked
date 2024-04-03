package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;

public final class SingleDoOnEvent<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22830b;

    /* renamed from: c  reason: collision with root package name */
    public final BiConsumer<? super T, ? super Throwable> f22831c;

    public final class DoOnEvent implements SingleObserver<T> {
        private final SingleObserver<? super T> downstream;

        public DoOnEvent(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        public void onError(Throwable th2) {
            try {
                SingleDoOnEvent.this.f22831c.accept(null, th2);
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
            try {
                SingleDoOnEvent.this.f22831c.accept(t11, null);
                this.downstream.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public SingleDoOnEvent(SingleSource<T> singleSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.f22830b = singleSource;
        this.f22831c = biConsumer;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22830b.subscribe(new DoOnEvent(singleObserver));
    }
}
