package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {

    public static final class CountObserver implements Observer<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Long> f17049b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17050c;

        /* renamed from: d  reason: collision with root package name */
        public long f17051d;

        public CountObserver(Observer<? super Long> observer) {
            this.f17049b = observer;
        }

        public void dispose() {
            this.f17050c.dispose();
        }

        public boolean isDisposed() {
            return this.f17050c.isDisposed();
        }

        public void onComplete() {
            this.f17049b.onNext(Long.valueOf(this.f17051d));
            this.f17049b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17049b.onError(th2);
        }

        public void onNext(Object obj) {
            this.f17051d++;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17050c, disposable)) {
                this.f17050c = disposable;
                this.f17049b.onSubscribe(this);
            }
        }
    }

    public ObservableCount(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super Long> observer) {
        this.f16799b.subscribe(new CountObserver(observer));
    }
}
