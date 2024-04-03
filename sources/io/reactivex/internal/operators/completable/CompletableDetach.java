package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class CompletableDetach extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14640b;

    public static final class DetachCompletableObserver implements CompletableObserver, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public CompletableObserver f14641b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f14642c;

        public DetachCompletableObserver(CompletableObserver completableObserver) {
            this.f14641b = completableObserver;
        }

        public void dispose() {
            this.f14641b = null;
            this.f14642c.dispose();
            this.f14642c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f14642c.isDisposed();
        }

        public void onComplete() {
            this.f14642c = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.f14641b;
            if (completableObserver != null) {
                this.f14641b = null;
                completableObserver.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f14642c = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.f14641b;
            if (completableObserver != null) {
                this.f14641b = null;
                completableObserver.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f14642c, disposable)) {
                this.f14642c = disposable;
                this.f14641b.onSubscribe(this);
            }
        }
    }

    public CompletableDetach(CompletableSource completableSource) {
        this.f14640b = completableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14640b.subscribe(new DetachCompletableObserver(completableObserver));
    }
}
