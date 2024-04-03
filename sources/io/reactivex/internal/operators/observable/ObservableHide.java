package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableHide<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class HideDisposable<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17332b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17333c;

        public HideDisposable(Observer<? super T> observer) {
            this.f17332b = observer;
        }

        public void dispose() {
            this.f17333c.dispose();
        }

        public boolean isDisposed() {
            return this.f17333c.isDisposed();
        }

        public void onComplete() {
            this.f17332b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17332b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17332b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17333c, disposable)) {
                this.f17333c = disposable;
                this.f17332b.onSubscribe(this);
            }
        }
    }

    public ObservableHide(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new HideDisposable(observer));
    }
}
