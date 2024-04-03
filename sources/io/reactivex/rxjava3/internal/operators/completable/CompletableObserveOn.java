package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableObserveOn extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19187b;

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f19188c;

    public static final class ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19189b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f19190c;

        /* renamed from: d  reason: collision with root package name */
        public Throwable f19191d;

        public ObserveOnCompletableObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f19189b = completableObserver;
            this.f19190c = scheduler;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            DisposableHelper.replace(this, this.f19190c.scheduleDirect(this));
        }

        public void onError(Throwable th2) {
            this.f19191d = th2;
            DisposableHelper.replace(this, this.f19190c.scheduleDirect(this));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f19189b.onSubscribe(this);
            }
        }

        public void run() {
            Throwable th2 = this.f19191d;
            if (th2 != null) {
                this.f19191d = null;
                this.f19189b.onError(th2);
                return;
            }
            this.f19189b.onComplete();
        }
    }

    public CompletableObserveOn(CompletableSource completableSource, Scheduler scheduler) {
        this.f19187b = completableSource;
        this.f19188c = scheduler;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19187b.subscribe(new ObserveOnCompletableObserver(completableObserver, this.f19188c));
    }
}
