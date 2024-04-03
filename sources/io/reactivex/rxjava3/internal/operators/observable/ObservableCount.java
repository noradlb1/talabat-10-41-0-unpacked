package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {

    public static final class CountObserver implements Observer<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Long> f21577b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f21578c;

        /* renamed from: d  reason: collision with root package name */
        public long f21579d;

        public CountObserver(Observer<? super Long> observer) {
            this.f21577b = observer;
        }

        public void dispose() {
            this.f21578c.dispose();
        }

        public boolean isDisposed() {
            return this.f21578c.isDisposed();
        }

        public void onComplete() {
            this.f21577b.onNext(Long.valueOf(this.f21579d));
            this.f21577b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21577b.onError(th2);
        }

        public void onNext(Object obj) {
            this.f21579d++;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21578c, disposable)) {
                this.f21578c = disposable;
                this.f21577b.onSubscribe(this);
            }
        }
    }

    public ObservableCount(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super Long> observer) {
        this.f21304b.subscribe(new CountObserver(observer));
    }
}
