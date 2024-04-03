package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTakeUntilCompletable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Completable f14728b;

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f14729c;

    public static final class TakeUntilMainObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 3533011714830024923L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14730b;

        /* renamed from: c  reason: collision with root package name */
        public final OtherObserver f14731c = new OtherObserver(this);

        /* renamed from: d  reason: collision with root package name */
        public final AtomicBoolean f14732d = new AtomicBoolean();

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5176264485428790318L;

            /* renamed from: b  reason: collision with root package name */
            public final TakeUntilMainObserver f14733b;

            public OtherObserver(TakeUntilMainObserver takeUntilMainObserver) {
                this.f14733b = takeUntilMainObserver;
            }

            public void onComplete() {
                this.f14733b.a();
            }

            public void onError(Throwable th2) {
                this.f14733b.b(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public TakeUntilMainObserver(CompletableObserver completableObserver) {
            this.f14730b = completableObserver;
        }

        public void a() {
            if (this.f14732d.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                this.f14730b.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (this.f14732d.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                this.f14730b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void dispose() {
            if (this.f14732d.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                DisposableHelper.dispose(this.f14731c);
            }
        }

        public boolean isDisposed() {
            return this.f14732d.get();
        }

        public void onComplete() {
            if (this.f14732d.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f14731c);
                this.f14730b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f14732d.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f14731c);
                this.f14730b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public CompletableTakeUntilCompletable(Completable completable, CompletableSource completableSource) {
        this.f14728b = completable;
        this.f14729c = completableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(completableObserver);
        completableObserver.onSubscribe(takeUntilMainObserver);
        this.f14729c.subscribe(takeUntilMainObserver.f14731c);
        this.f14728b.subscribe((CompletableObserver) takeUntilMainObserver);
    }
}
