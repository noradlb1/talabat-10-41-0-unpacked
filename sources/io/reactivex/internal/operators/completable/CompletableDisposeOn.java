package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableDisposeOn extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14643b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f14644c;

    public static final class DisposeOnObserver implements CompletableObserver, Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14645b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f14646c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f14647d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f14648e;

        public DisposeOnObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f14645b = completableObserver;
            this.f14646c = scheduler;
        }

        public void dispose() {
            this.f14648e = true;
            this.f14646c.scheduleDirect(this);
        }

        public boolean isDisposed() {
            return this.f14648e;
        }

        public void onComplete() {
            if (!this.f14648e) {
                this.f14645b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f14648e) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f14645b.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f14647d, disposable)) {
                this.f14647d = disposable;
                this.f14645b.onSubscribe(this);
            }
        }

        public void run() {
            this.f14647d.dispose();
            this.f14647d = DisposableHelper.DISPOSED;
        }
    }

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f14643b = completableSource;
        this.f14644c = scheduler;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14643b.subscribe(new DisposeOnObserver(completableObserver, this.f14644c));
    }
}
