package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleObserveOn<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18378b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f18379c;

    public static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18380b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f18381c;

        /* renamed from: d  reason: collision with root package name */
        public T f18382d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f18383e;

        public ObserveOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.f18380b = singleObserver;
            this.f18381c = scheduler;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f18383e = th2;
            DisposableHelper.replace(this, this.f18381c.scheduleDirect(this));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f18380b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f18382d = t11;
            DisposableHelper.replace(this, this.f18381c.scheduleDirect(this));
        }

        public void run() {
            Throwable th2 = this.f18383e;
            if (th2 != null) {
                this.f18380b.onError(th2);
            } else {
                this.f18380b.onSuccess(this.f18382d);
            }
        }
    }

    public SingleObserveOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f18378b = singleSource;
        this.f18379c = scheduler;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18378b.subscribe(new ObserveOnSingleObserver(singleObserver, this.f18379c));
    }
}
