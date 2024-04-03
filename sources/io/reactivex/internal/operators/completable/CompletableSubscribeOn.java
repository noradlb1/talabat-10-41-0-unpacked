package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubscribeOn extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14723b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f14724c;

    public static final class SubscribeOnObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14725b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f14726c = new SequentialDisposable();

        /* renamed from: d  reason: collision with root package name */
        public final CompletableSource f14727d;

        public SubscribeOnObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.f14725b = completableObserver;
            this.f14727d = completableSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f14726c.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f14725b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f14725b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void run() {
            this.f14727d.subscribe(this);
        }
    }

    public CompletableSubscribeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f14723b = completableSource;
        this.f14724c = scheduler;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(completableObserver, this.f14723b);
        completableObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.f14726c.replace(this.f14724c.scheduleDirect(subscribeOnObserver));
    }
}
