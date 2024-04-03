package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class IgnoreObservable<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21867b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f21868c;

        public IgnoreObservable(Observer<? super T> observer) {
            this.f21867b = observer;
        }

        public void dispose() {
            this.f21868c.dispose();
        }

        public boolean isDisposed() {
            return this.f21868c.isDisposed();
        }

        public void onComplete() {
            this.f21867b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21867b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Disposable disposable) {
            this.f21868c = disposable;
            this.f21867b.onSubscribe(this);
        }
    }

    public ObservableIgnoreElements(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new IgnoreObservable(observer));
    }
}
