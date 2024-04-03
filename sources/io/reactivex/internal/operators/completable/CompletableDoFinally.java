package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableDoFinally extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14649b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f14650c;

    public static final class DoFinallyObserver extends AtomicInteger implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14651b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f14652c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f14653d;

        public DoFinallyObserver(CompletableObserver completableObserver, Action action) {
            this.f14651b = completableObserver;
            this.f14652c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f14652c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            this.f14653d.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f14653d.isDisposed();
        }

        public void onComplete() {
            this.f14651b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            this.f14651b.onError(th2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f14653d, disposable)) {
                this.f14653d = disposable;
                this.f14651b.onSubscribe(this);
            }
        }
    }

    public CompletableDoFinally(CompletableSource completableSource, Action action) {
        this.f14649b = completableSource;
        this.f14650c = action;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14649b.subscribe(new DoFinallyObserver(completableObserver, this.f14650c));
    }
}
