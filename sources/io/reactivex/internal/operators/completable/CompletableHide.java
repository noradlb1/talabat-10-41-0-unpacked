package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class CompletableHide extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14670b;

    public static final class HideCompletableObserver implements CompletableObserver, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14671b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f14672c;

        public HideCompletableObserver(CompletableObserver completableObserver) {
            this.f14671b = completableObserver;
        }

        public void dispose() {
            this.f14672c.dispose();
            this.f14672c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f14672c.isDisposed();
        }

        public void onComplete() {
            this.f14671b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f14671b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f14672c, disposable)) {
                this.f14672c = disposable;
                this.f14671b.onSubscribe(this);
            }
        }
    }

    public CompletableHide(CompletableSource completableSource) {
        this.f14670b = completableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14670b.subscribe(new HideCompletableObserver(completableObserver));
    }
}
