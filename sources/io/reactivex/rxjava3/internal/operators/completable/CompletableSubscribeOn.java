package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubscribeOn extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19215b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f19216c;

    public static final class SubscribeOnObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19217b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f19218c = new SequentialDisposable();

        /* renamed from: d  reason: collision with root package name */
        public final CompletableSource f19219d;

        public SubscribeOnObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.f19217b = completableObserver;
            this.f19219d = completableSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f19218c.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f19217b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19217b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void run() {
            this.f19219d.subscribe(this);
        }
    }

    public CompletableSubscribeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f19215b = completableSource;
        this.f19216c = scheduler;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(completableObserver, this.f19215b);
        completableObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.f19218c.replace(this.f19216c.scheduleDirect(subscribeOnObserver));
    }
}
