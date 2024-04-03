package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;

public final class SingleDoOnTerminate<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18308b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f18309c;

    public final class DoOnTerminate implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18310b;

        public DoOnTerminate(SingleObserver<? super T> singleObserver) {
            this.f18310b = singleObserver;
        }

        public void onError(Throwable th2) {
            try {
                SingleDoOnTerminate.this.f18309c.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f18310b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f18310b.onSubscribe(disposable);
        }

        public void onSuccess(T t11) {
            try {
                SingleDoOnTerminate.this.f18309c.run();
                this.f18310b.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18310b.onError(th2);
            }
        }
    }

    public SingleDoOnTerminate(SingleSource<T> singleSource, Action action) {
        this.f18308b = singleSource;
        this.f18309c = action;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18308b.subscribe(new DoOnTerminate(singleObserver));
    }
}
