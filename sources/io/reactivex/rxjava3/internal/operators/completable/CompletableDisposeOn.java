package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class CompletableDisposeOn extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19128b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f19129c;

    public static final class DisposeOnObserver implements CompletableObserver, Disposable, Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19130b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f19131c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f19132d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f19133e;

        public DisposeOnObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f19130b = completableObserver;
            this.f19131c = scheduler;
        }

        public void dispose() {
            this.f19133e = true;
            this.f19131c.scheduleDirect(this);
        }

        public boolean isDisposed() {
            return this.f19133e;
        }

        public void onComplete() {
            if (!this.f19133e) {
                this.f19130b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19133e) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f19130b.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19132d, disposable)) {
                this.f19132d = disposable;
                this.f19130b.onSubscribe(this);
            }
        }

        public void run() {
            this.f19132d.dispose();
            this.f19132d = DisposableHelper.DISPOSED;
        }
    }

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f19128b = completableSource;
        this.f19129c = scheduler;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19128b.subscribe(new DisposeOnObserver(completableObserver, this.f19129c));
    }
}
