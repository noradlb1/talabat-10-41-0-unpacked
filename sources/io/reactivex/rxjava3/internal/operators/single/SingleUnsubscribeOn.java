package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleUnsubscribeOn<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22991b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f22992c;

    public static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22993b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f22994c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22995d;

        public UnsubscribeOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.f22993b = singleObserver;
            this.f22994c = scheduler;
        }

        public void dispose() {
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable disposable = (Disposable) getAndSet(disposableHelper);
            if (disposable != disposableHelper) {
                this.f22995d = disposable;
                this.f22994c.scheduleDirect(this);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f22993b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f22993b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f22993b.onSuccess(t11);
        }

        public void run() {
            this.f22995d.dispose();
        }
    }

    public SingleUnsubscribeOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f22991b = singleSource;
        this.f22992c = scheduler;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22991b.subscribe(new UnsubscribeOnSingleObserver(singleObserver, this.f22992c));
    }
}
