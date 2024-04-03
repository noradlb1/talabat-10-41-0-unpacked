package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;

public final class MaybeToObservable<T> extends Observable<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f21066b;

    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21067d;

        public MaybeToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        public void dispose() {
            super.dispose();
            this.f21067d.dispose();
        }

        public void onComplete() {
            complete();
        }

        public void onError(Throwable th2) {
            error(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21067d, disposable)) {
                this.f21067d = disposable;
                this.f19028b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            complete(t11);
        }
    }

    public MaybeToObservable(MaybeSource<T> maybeSource) {
        this.f21066b = maybeSource;
    }

    public static <T> MaybeObserver<T> create(Observer<? super T> observer) {
        return new MaybeToObservableObserver(observer);
    }

    public MaybeSource<T> source() {
        return this.f21066b;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21066b.subscribe(create(observer));
    }
}
