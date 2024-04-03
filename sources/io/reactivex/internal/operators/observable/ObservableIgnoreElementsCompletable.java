package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17336b;

    public static final class IgnoreObservable<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f17337b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17338c;

        public IgnoreObservable(CompletableObserver completableObserver) {
            this.f17337b = completableObserver;
        }

        public void dispose() {
            this.f17338c.dispose();
        }

        public boolean isDisposed() {
            return this.f17338c.isDisposed();
        }

        public void onComplete() {
            this.f17337b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17337b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Disposable disposable) {
            this.f17338c = disposable;
            this.f17337b.onSubscribe(this);
        }
    }

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.f17336b = observableSource;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this.f17336b));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f17336b.subscribe(new IgnoreObservable(completableObserver));
    }
}
