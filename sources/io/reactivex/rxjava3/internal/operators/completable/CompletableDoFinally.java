package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableDoFinally extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19134b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f19135c;

    public static final class DoFinallyObserver extends AtomicInteger implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19136b;

        /* renamed from: c  reason: collision with root package name */
        public final Action f19137c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f19138d;

        public DoFinallyObserver(CompletableObserver completableObserver, Action action) {
            this.f19136b = completableObserver;
            this.f19137c = action;
        }

        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f19137c.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            this.f19138d.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f19138d.isDisposed();
        }

        public void onComplete() {
            this.f19136b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            this.f19136b.onError(th2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19138d, disposable)) {
                this.f19138d = disposable;
                this.f19136b.onSubscribe(this);
            }
        }
    }

    public CompletableDoFinally(CompletableSource completableSource, Action action) {
        this.f19134b = completableSource;
        this.f19135c = action;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19134b.subscribe(new DoFinallyObserver(completableObserver, this.f19135c));
    }
}
