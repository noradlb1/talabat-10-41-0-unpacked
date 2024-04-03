package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {

    public static final class MaterializeObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Notification<T>> f21950b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f21951c;

        public MaterializeObserver(Observer<? super Notification<T>> observer) {
            this.f21950b = observer;
        }

        public void dispose() {
            this.f21951c.dispose();
        }

        public boolean isDisposed() {
            return this.f21951c.isDisposed();
        }

        public void onComplete() {
            this.f21950b.onNext(Notification.createOnComplete());
            this.f21950b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21950b.onNext(Notification.createOnError(th2));
            this.f21950b.onComplete();
        }

        public void onNext(T t11) {
            this.f21950b.onNext(Notification.createOnNext(t11));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21951c, disposable)) {
                this.f21951c = disposable;
                this.f21950b.onSubscribe(this);
            }
        }
    }

    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super Notification<T>> observer) {
        this.f21304b.subscribe(new MaterializeObserver(observer));
    }
}
