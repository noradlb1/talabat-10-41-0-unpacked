package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class SingleDetach<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18271b;

    public static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public SingleObserver<? super T> f18272b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f18273c;

        public DetachSingleObserver(SingleObserver<? super T> singleObserver) {
            this.f18272b = singleObserver;
        }

        public void dispose() {
            this.f18272b = null;
            this.f18273c.dispose();
            this.f18273c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f18273c.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f18273c = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.f18272b;
            if (singleObserver != null) {
                this.f18272b = null;
                singleObserver.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18273c, disposable)) {
                this.f18273c = disposable;
                this.f18272b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f18273c = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.f18272b;
            if (singleObserver != null) {
                this.f18272b = null;
                singleObserver.onSuccess(t11);
            }
        }
    }

    public SingleDetach(SingleSource<T> singleSource) {
        this.f18271b = singleSource;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18271b.subscribe(new DetachSingleObserver(singleObserver));
    }
}
