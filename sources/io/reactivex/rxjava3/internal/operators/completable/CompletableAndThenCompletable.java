package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenCompletable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19074b;

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f19075c;

    public static final class NextObserver implements CompletableObserver {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicReference<Disposable> f19076b;

        /* renamed from: c  reason: collision with root package name */
        public final CompletableObserver f19077c;

        public NextObserver(AtomicReference<Disposable> atomicReference, CompletableObserver completableObserver) {
            this.f19076b = atomicReference;
            this.f19077c = completableObserver;
        }

        public void onComplete() {
            this.f19077c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19077c.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f19076b, disposable);
        }
    }

    public static final class SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -4101678820158072998L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19078b;

        /* renamed from: c  reason: collision with root package name */
        public final CompletableSource f19079c;

        public SourceObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.f19078b = completableObserver;
            this.f19079c = completableSource;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f19079c.subscribe(new NextObserver(this, this.f19078b));
        }

        public void onError(Throwable th2) {
            this.f19078b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f19078b.onSubscribe(this);
            }
        }
    }

    public CompletableAndThenCompletable(CompletableSource completableSource, CompletableSource completableSource2) {
        this.f19074b = completableSource;
        this.f19075c = completableSource2;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19074b.subscribe(new SourceObserver(completableObserver, this.f19075c));
    }
}
