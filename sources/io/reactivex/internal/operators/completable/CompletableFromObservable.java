package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public final class CompletableFromObservable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f14661b;

    public static final class CompletableFromObservableObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14662b;

        public CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f14662b = completableObserver;
        }

        public void onComplete() {
            this.f14662b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f14662b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Disposable disposable) {
            this.f14662b.onSubscribe(disposable);
        }
    }

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.f14661b = observableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14661b.subscribe(new CompletableFromObservableObserver(completableObserver));
    }
}
