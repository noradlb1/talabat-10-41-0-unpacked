package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class ObservableLastSingle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17386b;

    /* renamed from: c  reason: collision with root package name */
    public final T f17387c;

    public static final class LastObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f17388b;

        /* renamed from: c  reason: collision with root package name */
        public final T f17389c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17390d;

        /* renamed from: e  reason: collision with root package name */
        public T f17391e;

        public LastObserver(SingleObserver<? super T> singleObserver, T t11) {
            this.f17388b = singleObserver;
            this.f17389c = t11;
        }

        public void dispose() {
            this.f17390d.dispose();
            this.f17390d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f17390d == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.f17390d = DisposableHelper.DISPOSED;
            T t11 = this.f17391e;
            if (t11 != null) {
                this.f17391e = null;
                this.f17388b.onSuccess(t11);
                return;
            }
            T t12 = this.f17389c;
            if (t12 != null) {
                this.f17388b.onSuccess(t12);
            } else {
                this.f17388b.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th2) {
            this.f17390d = DisposableHelper.DISPOSED;
            this.f17391e = null;
            this.f17388b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17391e = t11;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17390d, disposable)) {
                this.f17390d = disposable;
                this.f17388b.onSubscribe(this);
            }
        }
    }

    public ObservableLastSingle(ObservableSource<T> observableSource, T t11) {
        this.f17386b = observableSource;
        this.f17387c = t11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f17386b.subscribe(new LastObserver(singleObserver, this.f17387c));
    }
}
