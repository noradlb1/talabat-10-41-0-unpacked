package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class MaybeToObservable<T> extends Observable<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16553b;

    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16554d;

        public MaybeToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        public void dispose() {
            super.dispose();
            this.f16554d.dispose();
        }

        public void onComplete() {
            complete();
        }

        public void onError(Throwable th2) {
            error(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16554d, disposable)) {
                this.f16554d = disposable;
                this.f14549b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            complete(t11);
        }
    }

    public MaybeToObservable(MaybeSource<T> maybeSource) {
        this.f16553b = maybeSource;
    }

    public static <T> MaybeObserver<T> create(Observer<? super T> observer) {
        return new MaybeToObservableObserver(observer);
    }

    public MaybeSource<T> source() {
        return this.f16553b;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16553b.subscribe(create(observer));
    }
}
