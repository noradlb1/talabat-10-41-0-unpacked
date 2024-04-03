package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableObserveOn extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14700b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f14701c;

    public static final class ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14702b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f14703c;

        /* renamed from: d  reason: collision with root package name */
        public Throwable f14704d;

        public ObserveOnCompletableObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f14702b = completableObserver;
            this.f14703c = scheduler;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            DisposableHelper.replace(this, this.f14703c.scheduleDirect(this));
        }

        public void onError(Throwable th2) {
            this.f14704d = th2;
            DisposableHelper.replace(this, this.f14703c.scheduleDirect(this));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f14702b.onSubscribe(this);
            }
        }

        public void run() {
            Throwable th2 = this.f14704d;
            if (th2 != null) {
                this.f14704d = null;
                this.f14702b.onError(th2);
                return;
            }
            this.f14702b.onComplete();
        }
    }

    public CompletableObserveOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f14700b = completableSource;
        this.f14701c = scheduler;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14700b.subscribe(new ObserveOnCompletableObserver(completableObserver, this.f14701c));
    }
}
