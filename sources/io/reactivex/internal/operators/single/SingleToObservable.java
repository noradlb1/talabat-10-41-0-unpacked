package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class SingleToObservable<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18420b;

    public static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 3786543492451018833L;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18421d;

        public SingleToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        public void dispose() {
            super.dispose();
            this.f18421d.dispose();
        }

        public void onError(Throwable th2) {
            error(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18421d, disposable)) {
                this.f18421d = disposable;
                this.f14549b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            complete(t11);
        }
    }

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.f18420b = singleSource;
    }

    public static <T> SingleObserver<T> create(Observer<? super T> observer) {
        return new SingleToObservableObserver(observer);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f18420b.subscribe(create(observer));
    }
}
