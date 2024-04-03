package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubscribeOn<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18392b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f18393c;

    public static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18394b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f18395c = new SequentialDisposable();

        /* renamed from: d  reason: collision with root package name */
        public final SingleSource<? extends T> f18396d;

        public SubscribeOnObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.f18394b = singleObserver;
            this.f18396d = singleSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f18395c.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f18394b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f18394b.onSuccess(t11);
        }

        public void run() {
            this.f18396d.subscribe(this);
        }
    }

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler) {
        this.f18392b = singleSource;
        this.f18393c = scheduler;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(singleObserver, this.f18392b);
        singleObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.f18395c.replace(this.f18393c.scheduleDirect(subscribeOnObserver));
    }
}
