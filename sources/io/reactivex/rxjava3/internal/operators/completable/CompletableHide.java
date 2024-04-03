package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class CompletableHide extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19156b;

    public static final class HideCompletableObserver implements CompletableObserver, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19157b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f19158c;

        public HideCompletableObserver(CompletableObserver completableObserver) {
            this.f19157b = completableObserver;
        }

        public void dispose() {
            this.f19158c.dispose();
            this.f19158c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f19158c.isDisposed();
        }

        public void onComplete() {
            this.f19157b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19157b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19158c, disposable)) {
                this.f19158c = disposable;
                this.f19157b.onSubscribe(this);
            }
        }
    }

    public CompletableHide(CompletableSource completableSource) {
        this.f19156b = completableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19156b.subscribe(new HideCompletableObserver(completableObserver));
    }
}
