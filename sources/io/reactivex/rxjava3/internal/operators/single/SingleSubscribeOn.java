package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubscribeOn<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22952b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f22953c;

    public static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22954b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f22955c = new SequentialDisposable();

        /* renamed from: d  reason: collision with root package name */
        public final SingleSource<? extends T> f22956d;

        public SubscribeOnObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.f22954b = singleObserver;
            this.f22956d = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f22955c.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f22954b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f22954b.onSuccess(t11);
        }

        public void run() {
            this.f22956d.subscribe(this);
        }
    }

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler) {
        this.f22952b = singleSource;
        this.f22953c = scheduler;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(singleObserver, this.f22952b);
        singleObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.f22955c.replace(this.f22953c.scheduleDirect(subscribeOnObserver));
    }
}
