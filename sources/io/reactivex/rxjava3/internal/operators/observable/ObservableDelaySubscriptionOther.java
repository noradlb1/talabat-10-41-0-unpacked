package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T> f21632b;

    /* renamed from: c  reason: collision with root package name */
    public final ObservableSource<U> f21633c;

    public final class DelayObserver implements Observer<U> {

        /* renamed from: b  reason: collision with root package name */
        public final SequentialDisposable f21634b;

        /* renamed from: c  reason: collision with root package name */
        public final Observer<? super T> f21635c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f21636d;

        public final class OnComplete implements Observer<T> {
            public OnComplete() {
            }

            public void onComplete() {
                DelayObserver.this.f21635c.onComplete();
            }

            public void onError(Throwable th2) {
                DelayObserver.this.f21635c.onError(th2);
            }

            public void onNext(T t11) {
                DelayObserver.this.f21635c.onNext(t11);
            }

            public void onSubscribe(Disposable disposable) {
                DelayObserver.this.f21634b.update(disposable);
            }
        }

        public DelayObserver(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.f21634b = sequentialDisposable;
            this.f21635c = observer;
        }

        public void onComplete() {
            if (!this.f21636d) {
                this.f21636d = true;
                ObservableDelaySubscriptionOther.this.f21632b.subscribe(new OnComplete());
            }
        }

        public void onError(Throwable th2) {
            if (this.f21636d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21636d = true;
            this.f21635c.onError(th2);
        }

        public void onNext(U u11) {
            onComplete();
        }

        public void onSubscribe(Disposable disposable) {
            this.f21634b.update(disposable);
        }
    }

    public ObservableDelaySubscriptionOther(ObservableSource<? extends T> observableSource, ObservableSource<U> observableSource2) {
        this.f21632b = observableSource;
        this.f21633c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.f21633c.subscribe(new DelayObserver(sequentialDisposable, observer));
    }
}
