package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class ObservableLastMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17382b;

    public static final class LastObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f17383b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17384c;

        /* renamed from: d  reason: collision with root package name */
        public T f17385d;

        public LastObserver(MaybeObserver<? super T> maybeObserver) {
            this.f17383b = maybeObserver;
        }

        public void dispose() {
            this.f17384c.dispose();
            this.f17384c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f17384c == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.f17384c = DisposableHelper.DISPOSED;
            T t11 = this.f17385d;
            if (t11 != null) {
                this.f17385d = null;
                this.f17383b.onSuccess(t11);
                return;
            }
            this.f17383b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17384c = DisposableHelper.DISPOSED;
            this.f17385d = null;
            this.f17383b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17385d = t11;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17384c, disposable)) {
                this.f17384c = disposable;
                this.f17383b.onSubscribe(this);
            }
        }
    }

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.f17382b = observableSource;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f17382b.subscribe(new LastObserver(maybeObserver));
    }
}
