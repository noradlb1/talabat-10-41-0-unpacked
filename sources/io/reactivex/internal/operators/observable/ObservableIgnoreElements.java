package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class IgnoreObservable<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17334b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17335c;

        public IgnoreObservable(Observer<? super T> observer) {
            this.f17334b = observer;
        }

        public void dispose() {
            this.f17335c.dispose();
        }

        public boolean isDisposed() {
            return this.f17335c.isDisposed();
        }

        public void onComplete() {
            this.f17334b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17334b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Disposable disposable) {
            this.f17335c = disposable;
            this.f17334b.onSubscribe(this);
        }
    }

    public ObservableIgnoreElements(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new IgnoreObservable(observer));
    }
}
