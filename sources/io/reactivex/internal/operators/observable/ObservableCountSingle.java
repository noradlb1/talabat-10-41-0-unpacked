package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17052b;

    public static final class CountObserver implements Observer<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Long> f17053b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17054c;

        /* renamed from: d  reason: collision with root package name */
        public long f17055d;

        public CountObserver(SingleObserver<? super Long> singleObserver) {
            this.f17053b = singleObserver;
        }

        public void dispose() {
            this.f17054c.dispose();
            this.f17054c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f17054c.isDisposed();
        }

        public void onComplete() {
            this.f17054c = DisposableHelper.DISPOSED;
            this.f17053b.onSuccess(Long.valueOf(this.f17055d));
        }

        public void onError(Throwable th2) {
            this.f17054c = DisposableHelper.DISPOSED;
            this.f17053b.onError(th2);
        }

        public void onNext(Object obj) {
            this.f17055d++;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17054c, disposable)) {
                this.f17054c = disposable;
                this.f17053b.onSubscribe(this);
            }
        }
    }

    public ObservableCountSingle(ObservableSource<T> observableSource) {
        this.f17052b = observableSource;
    }

    public Observable<Long> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableCount(this.f17052b));
    }

    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f17052b.subscribe(new CountObserver(singleObserver));
    }
}
