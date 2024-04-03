package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class SingleHide<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22925b;

    public static final class HideSingleObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22926b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f22927c;

        public HideSingleObserver(SingleObserver<? super T> singleObserver) {
            this.f22926b = singleObserver;
        }

        public void dispose() {
            this.f22927c.dispose();
        }

        public boolean isDisposed() {
            return this.f22927c.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f22926b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22927c, disposable)) {
                this.f22927c = disposable;
                this.f22926b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f22926b.onSuccess(t11);
        }
    }

    public SingleHide(SingleSource<? extends T> singleSource) {
        this.f22925b = singleSource;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22925b.subscribe(new HideSingleObserver(singleObserver));
    }
}
