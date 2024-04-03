package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class ObservableLastSingle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21933b;

    /* renamed from: c  reason: collision with root package name */
    public final T f21934c;

    public static final class LastObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f21935b;

        /* renamed from: c  reason: collision with root package name */
        public final T f21936c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21937d;

        /* renamed from: e  reason: collision with root package name */
        public T f21938e;

        public LastObserver(SingleObserver<? super T> singleObserver, T t11) {
            this.f21935b = singleObserver;
            this.f21936c = t11;
        }

        public void dispose() {
            this.f21937d.dispose();
            this.f21937d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f21937d == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.f21937d = DisposableHelper.DISPOSED;
            T t11 = this.f21938e;
            if (t11 != null) {
                this.f21938e = null;
                this.f21935b.onSuccess(t11);
                return;
            }
            T t12 = this.f21936c;
            if (t12 != null) {
                this.f21935b.onSuccess(t12);
            } else {
                this.f21935b.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th2) {
            this.f21937d = DisposableHelper.DISPOSED;
            this.f21938e = null;
            this.f21935b.onError(th2);
        }

        public void onNext(T t11) {
            this.f21938e = t11;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21937d, disposable)) {
                this.f21937d = disposable;
                this.f21935b.onSubscribe(this);
            }
        }
    }

    public ObservableLastSingle(ObservableSource<T> observableSource, T t11) {
        this.f21933b = observableSource;
        this.f21934c = t11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f21933b.subscribe(new LastObserver(singleObserver, this.f21934c));
    }
}
