package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenCompletable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14589b;

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f14590c;

    public static final class NextObserver implements CompletableObserver {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<Disposable> f14591b;

        /* renamed from: c  reason: collision with root package name */
        public final CompletableObserver f14592c;

        public NextObserver(AtomicReference<Disposable> atomicReference, CompletableObserver completableObserver) {
            this.f14591b = atomicReference;
            this.f14592c = completableObserver;
        }

        public void onComplete() {
            this.f14592c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f14592c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f14591b, disposable);
        }
    }

    public static final class SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -4101678820158072998L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14593b;

        /* renamed from: c  reason: collision with root package name */
        public final CompletableSource f14594c;

        public SourceObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.f14593b = completableObserver;
            this.f14594c = completableSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f14594c.subscribe(new NextObserver(this, this.f14593b));
        }

        public void onError(Throwable th2) {
            this.f14593b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f14593b.onSubscribe(this);
            }
        }
    }

    public CompletableAndThenCompletable(CompletableSource completableSource, CompletableSource completableSource2) {
        this.f14589b = completableSource;
        this.f14590c = completableSource2;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14589b.subscribe(new SourceObserver(completableObserver, this.f14590c));
    }
}
