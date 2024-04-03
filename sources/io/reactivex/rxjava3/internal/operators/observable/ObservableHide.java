package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableHide<T> extends AbstractObservableWithUpstream<T, T> {

    public static final class HideDisposable<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21865b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f21866c;

        public HideDisposable(Observer<? super T> observer) {
            this.f21865b = observer;
        }

        public void dispose() {
            this.f21866c.dispose();
        }

        public boolean isDisposed() {
            return this.f21866c.isDisposed();
        }

        public void onComplete() {
            this.f21865b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21865b.onError(th2);
        }

        public void onNext(T t11) {
            this.f21865b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21866c, disposable)) {
                this.f21866c = disposable;
                this.f21865b.onSubscribe(this);
            }
        }
    }

    public ObservableHide(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new HideDisposable(observer));
    }
}
