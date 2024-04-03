package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class CompletableDetach extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19125b;

    public static final class DetachCompletableObserver implements CompletableObserver, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public CompletableObserver f19126b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f19127c;

        public DetachCompletableObserver(CompletableObserver completableObserver) {
            this.f19126b = completableObserver;
        }

        public void dispose() {
            this.f19126b = null;
            this.f19127c.dispose();
            this.f19127c = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f19127c.isDisposed();
        }

        public void onComplete() {
            this.f19127c = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.f19126b;
            if (completableObserver != null) {
                this.f19126b = null;
                completableObserver.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f19127c = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.f19126b;
            if (completableObserver != null) {
                this.f19126b = null;
                completableObserver.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19127c, disposable)) {
                this.f19127c = disposable;
                this.f19126b.onSubscribe(this);
            }
        }
    }

    public CompletableDetach(CompletableSource completableSource) {
        this.f19125b = completableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19125b.subscribe(new DetachCompletableObserver(completableObserver));
    }
}
