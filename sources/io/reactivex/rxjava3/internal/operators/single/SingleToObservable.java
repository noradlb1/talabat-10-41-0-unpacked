package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;

public final class SingleToObservable<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22989b;

    public static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 3786543492451018833L;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22990d;

        public SingleToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        public void dispose() {
            super.dispose();
            this.f22990d.dispose();
        }

        public void onError(Throwable th2) {
            error(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22990d, disposable)) {
                this.f22990d = disposable;
                this.f19028b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            complete(t11);
        }
    }

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.f22989b = singleSource;
    }

    public static <T> SingleObserver<T> create(Observer<? super T> observer) {
        return new SingleToObservableObserver(observer);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f22989b.subscribe(create(observer));
    }
}
