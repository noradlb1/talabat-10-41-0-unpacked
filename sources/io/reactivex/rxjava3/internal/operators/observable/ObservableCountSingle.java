package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21580b;

    public static final class CountObserver implements Observer<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Long> f21581b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f21582c;

        /* renamed from: d  reason: collision with root package name */
        public long f21583d;

        public CountObserver(SingleObserver<? super Long> singleObserver) {
            this.f21581b = singleObserver;
        }

        public void dispose() {
            this.f21582c.dispose();
            this.f21582c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f21582c.isDisposed();
        }

        public void onComplete() {
            this.f21582c = DisposableHelper.DISPOSED;
            this.f21581b.onSuccess(Long.valueOf(this.f21583d));
        }

        public void onError(Throwable th2) {
            this.f21582c = DisposableHelper.DISPOSED;
            this.f21581b.onError(th2);
        }

        public void onNext(Object obj) {
            this.f21583d++;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21582c, disposable)) {
                this.f21582c = disposable;
                this.f21581b.onSubscribe(this);
            }
        }
    }

    public ObservableCountSingle(ObservableSource<T> observableSource) {
        this.f21580b = observableSource;
    }

    public Observable<Long> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableCount(this.f21580b));
    }

    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.f21580b.subscribe(new CountObserver(singleObserver));
    }
}
