package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleUnsubscribeOn<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18422b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f18423c;

    public static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18424b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f18425c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f18426d;

        public UnsubscribeOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.f18424b = singleObserver;
            this.f18425c = scheduler;
        }

        public void dispose() {
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable disposable = (Disposable) getAndSet(disposableHelper);
            if (disposable != disposableHelper) {
                this.f18426d = disposable;
                this.f18425c.scheduleDirect(this);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f18424b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f18424b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f18424b.onSuccess(t11);
        }

        public void run() {
            this.f18426d.dispose();
        }
    }

    public SingleUnsubscribeOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f18422b = singleSource;
        this.f18423c = scheduler;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18422b.subscribe(new UnsubscribeOnSingleObserver(singleObserver, this.f18423c));
    }
}
