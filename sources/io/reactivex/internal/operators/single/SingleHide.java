package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class SingleHide<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18367b;

    public static final class HideSingleObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18368b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f18369c;

        public HideSingleObserver(SingleObserver<? super T> singleObserver) {
            this.f18368b = singleObserver;
        }

        public void dispose() {
            this.f18369c.dispose();
        }

        public boolean isDisposed() {
            return this.f18369c.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f18368b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18369c, disposable)) {
                this.f18369c = disposable;
                this.f18368b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f18368b.onSuccess(t11);
        }
    }

    public SingleHide(SingleSource<? extends T> singleSource) {
        this.f18367b = singleSource;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18367b.subscribe(new HideSingleObserver(singleObserver));
    }
}
