package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleObserveOn<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22936b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f22937c;

    public static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22938b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f22939c;

        /* renamed from: d  reason: collision with root package name */
        public T f22940d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f22941e;

        public ObserveOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.f22938b = singleObserver;
            this.f22939c = scheduler;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f22941e = th2;
            DisposableHelper.replace(this, this.f22939c.scheduleDirect(this));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f22938b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f22940d = t11;
            DisposableHelper.replace(this, this.f22939c.scheduleDirect(this));
        }

        public void run() {
            Throwable th2 = this.f22941e;
            if (th2 != null) {
                this.f22938b.onError(th2);
            } else {
                this.f22938b.onSuccess(this.f22940d);
            }
        }
    }

    public SingleObserveOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f22936b = singleSource;
        this.f22937c = scheduler;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22936b.subscribe(new ObserveOnSingleObserver(singleObserver, this.f22937c));
    }
}
