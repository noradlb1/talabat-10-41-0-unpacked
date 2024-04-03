package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T> f17104b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<U> f17105c;

    public final class DelayObserver implements Observer<U> {

        /* renamed from: b  reason: collision with root package name */
        public final SequentialDisposable f17106b;

        /* renamed from: c  reason: collision with root package name */
        public final Observer<? super T> f17107c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f17108d;

        public final class OnComplete implements Observer<T> {
            public OnComplete() {
            }

            public void onComplete() {
                DelayObserver.this.f17107c.onComplete();
            }

            public void onError(Throwable th2) {
                DelayObserver.this.f17107c.onError(th2);
            }

            public void onNext(T t11) {
                DelayObserver.this.f17107c.onNext(t11);
            }

            public void onSubscribe(Disposable disposable) {
                DelayObserver.this.f17106b.update(disposable);
            }
        }

        public DelayObserver(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.f17106b = sequentialDisposable;
            this.f17107c = observer;
        }

        public void onComplete() {
            if (!this.f17108d) {
                this.f17108d = true;
                ObservableDelaySubscriptionOther.this.f17104b.subscribe(new OnComplete());
            }
        }

        public void onError(Throwable th2) {
            if (this.f17108d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17108d = true;
            this.f17107c.onError(th2);
        }

        public void onNext(U u11) {
            onComplete();
        }

        public void onSubscribe(Disposable disposable) {
            this.f17106b.update(disposable);
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.f17104b = observableSource;
        this.f17105c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.f17105c.subscribe(new DelayObserver(sequentialDisposable, observer));
    }
}
