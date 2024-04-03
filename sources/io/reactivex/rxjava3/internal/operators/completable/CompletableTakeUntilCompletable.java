package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTakeUntilCompletable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Completable f19220b;

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f19221c;

    public static final class TakeUntilMainObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 3533011714830024923L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19222b;

        /* renamed from: c  reason: collision with root package name */
        public final OtherObserver f19223c = new OtherObserver(this);

        /* renamed from: d  reason: collision with root package name */
        public final AtomicBoolean f19224d = new AtomicBoolean();

        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5176264485428790318L;

            /* renamed from: b  reason: collision with root package name */
            public final TakeUntilMainObserver f19225b;

            public OtherObserver(TakeUntilMainObserver takeUntilMainObserver) {
                this.f19225b = takeUntilMainObserver;
            }

            public void onComplete() {
                this.f19225b.a();
            }

            public void onError(Throwable th2) {
                this.f19225b.b(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public TakeUntilMainObserver(CompletableObserver completableObserver) {
            this.f19222b = completableObserver;
        }

        public void a() {
            if (this.f19224d.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                this.f19222b.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (this.f19224d.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                this.f19222b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void dispose() {
            if (this.f19224d.compareAndSet(false, true)) {
                DisposableHelper.dispose(this);
                DisposableHelper.dispose(this.f19223c);
            }
        }

        public boolean isDisposed() {
            return this.f19224d.get();
        }

        public void onComplete() {
            if (this.f19224d.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f19223c);
                this.f19222b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19224d.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f19223c);
                this.f19222b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public CompletableTakeUntilCompletable(Completable completable, CompletableSource completableSource) {
        this.f19220b = completable;
        this.f19221c = completableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(completableObserver);
        completableObserver.onSubscribe(takeUntilMainObserver);
        this.f19221c.subscribe(takeUntilMainObserver.f19223c);
        this.f19220b.subscribe((CompletableObserver) takeUntilMainObserver);
    }
}
