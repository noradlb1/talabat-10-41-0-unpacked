package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class SingleDetach<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22805b;

    public static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public SingleObserver<? super T> f22806b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f22807c;

        public DetachSingleObserver(SingleObserver<? super T> singleObserver) {
            this.f22806b = singleObserver;
        }

        public void dispose() {
            this.f22806b = null;
            this.f22807c.dispose();
            this.f22807c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f22807c.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f22807c = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.f22806b;
            if (singleObserver != null) {
                this.f22806b = null;
                singleObserver.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22807c, disposable)) {
                this.f22807c = disposable;
                this.f22806b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f22807c = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.f22806b;
            if (singleObserver != null) {
                this.f22806b = null;
                singleObserver.onSuccess(t11);
            }
        }
    }

    public SingleDetach(SingleSource<T> singleSource) {
        this.f22805b = singleSource;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22805b.subscribe(new DetachSingleObserver(singleObserver));
    }
}
