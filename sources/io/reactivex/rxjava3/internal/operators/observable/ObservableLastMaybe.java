package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class ObservableLastMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21929b;

    public static final class LastObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21930b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f21931c;

        /* renamed from: d  reason: collision with root package name */
        public T f21932d;

        public LastObserver(MaybeObserver<? super T> maybeObserver) {
            this.f21930b = maybeObserver;
        }

        public void dispose() {
            this.f21931c.dispose();
            this.f21931c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f21931c == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.f21931c = DisposableHelper.DISPOSED;
            T t11 = this.f21932d;
            if (t11 != null) {
                this.f21932d = null;
                this.f21930b.onSuccess(t11);
                return;
            }
            this.f21930b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21931c = DisposableHelper.DISPOSED;
            this.f21932d = null;
            this.f21930b.onError(th2);
        }

        public void onNext(T t11) {
            this.f21932d = t11;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21931c, disposable)) {
                this.f21931c = disposable;
                this.f21930b.onSubscribe(this);
            }
        }
    }

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.f21929b = observableSource;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f21929b.subscribe(new LastObserver(maybeObserver));
    }
}
