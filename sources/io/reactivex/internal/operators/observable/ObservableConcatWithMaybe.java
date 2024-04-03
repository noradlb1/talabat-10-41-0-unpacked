package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T> f17041c;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17042b;

        /* renamed from: c  reason: collision with root package name */
        public MaybeSource<? extends T> f17043c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f17044d;

        public ConcatWithObserver(Observer<? super T> observer, MaybeSource<? extends T> maybeSource) {
            this.f17042b = observer;
            this.f17043c = maybeSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.f17044d) {
                this.f17042b.onComplete();
                return;
            }
            this.f17044d = true;
            DisposableHelper.replace(this, (Disposable) null);
            MaybeSource<? extends T> maybeSource = this.f17043c;
            this.f17043c = null;
            maybeSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f17042b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17042b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.f17044d) {
                this.f17042b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f17042b.onNext(t11);
            this.f17042b.onComplete();
        }
    }

    public ObservableConcatWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f17041c = maybeSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new ConcatWithObserver(observer, this.f17041c));
    }
}
