package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21869b;

    public static final class IgnoreObservable<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f21870b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f21871c;

        public IgnoreObservable(CompletableObserver completableObserver) {
            this.f21870b = completableObserver;
        }

        public void dispose() {
            this.f21871c.dispose();
        }

        public boolean isDisposed() {
            return this.f21871c.isDisposed();
        }

        public void onComplete() {
            this.f21870b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21870b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Disposable disposable) {
            this.f21871c = disposable;
            this.f21870b.onSubscribe(this);
        }
    }

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.f21869b = observableSource;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this.f21869b));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f21869b.subscribe(new IgnoreObservable(completableObserver));
    }
}
