package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public final class CompletableFromObservable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f19146b;

    public static final class CompletableFromObservableObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19147b;

        public CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f19147b = completableObserver;
        }

        public void onComplete() {
            this.f19147b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19147b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Disposable disposable) {
            this.f19147b.onSubscribe(disposable);
        }
    }

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.f19146b = observableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19146b.subscribe(new CompletableFromObservableObserver(completableObserver));
    }
}
