package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;

public final class SingleDoOnTerminate<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22849b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f22850c;

    public final class DoOnTerminate implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22851b;

        public DoOnTerminate(SingleObserver<? super T> singleObserver) {
            this.f22851b = singleObserver;
        }

        public void onError(Throwable th2) {
            try {
                SingleDoOnTerminate.this.f22850c.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f22851b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22851b.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            try {
                SingleDoOnTerminate.this.f22850c.run();
                this.f22851b.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22851b.onError(th2);
            }
        }
    }

    public SingleDoOnTerminate(SingleSource<T> singleSource, Action action) {
        this.f22849b = singleSource;
        this.f22850c = action;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22849b.subscribe(new DoOnTerminate(singleObserver));
    }
}
