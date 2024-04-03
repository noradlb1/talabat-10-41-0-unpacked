package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {

    public static final class MaterializeObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Notification<T>> f17403b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17404c;

        public MaterializeObserver(Observer<? super Notification<T>> observer) {
            this.f17403b = observer;
        }

        public void dispose() {
            this.f17404c.dispose();
        }

        public boolean isDisposed() {
            return this.f17404c.isDisposed();
        }

        public void onComplete() {
            this.f17403b.onNext(Notification.createOnComplete());
            this.f17403b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17403b.onNext(Notification.createOnError(th2));
            this.f17403b.onComplete();
        }

        public void onNext(T t11) {
            this.f17403b.onNext(Notification.createOnNext(t11));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17404c, disposable)) {
                this.f17404c = disposable;
                this.f17403b.onSubscribe(this);
            }
        }
    }

    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super Notification<T>> observer) {
        this.f16799b.subscribe(new MaterializeObserver(observer));
    }
}
