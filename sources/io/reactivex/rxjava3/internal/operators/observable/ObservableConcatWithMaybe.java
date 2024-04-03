package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<? extends T> f21569c;

    public static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21570b;

        /* renamed from: c  reason: collision with root package name */
        public MaybeSource<? extends T> f21571c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f21572d;

        public ConcatWithObserver(Observer<? super T> observer, MaybeSource<? extends T> maybeSource) {
            this.f21570b = observer;
            this.f21571c = maybeSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (this.f21572d) {
                this.f21570b.onComplete();
                return;
            }
            this.f21572d = true;
            DisposableHelper.replace(this, (Disposable) null);
            MaybeSource<? extends T> maybeSource = this.f21571c;
            this.f21571c = null;
            maybeSource.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f21570b.onError(th2);
        }

        public void onNext(T t11) {
            this.f21570b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.f21572d) {
                this.f21570b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f21570b.onNext(t11);
            this.f21570b.onComplete();
        }
    }

    public ObservableConcatWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f21569c = maybeSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new ConcatWithObserver(observer, this.f21569c));
    }
}
