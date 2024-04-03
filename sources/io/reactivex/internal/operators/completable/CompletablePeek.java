package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletablePeek extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14708b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Disposable> f14709c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super Throwable> f14710d;

    /* renamed from: e  reason: collision with root package name */
    public final Action f14711e;

    /* renamed from: f  reason: collision with root package name */
    public final Action f14712f;

    /* renamed from: g  reason: collision with root package name */
    public final Action f14713g;

    /* renamed from: h  reason: collision with root package name */
    public final Action f14714h;

    public final class CompletableObserverImplementation implements CompletableObserver, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14715b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f14716c;

        public CompletableObserverImplementation(CompletableObserver completableObserver) {
            this.f14715b = completableObserver;
        }

        public void a() {
            try {
                CompletablePeek.this.f14713g.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        public void dispose() {
            try {
                CompletablePeek.this.f14714h.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f14716c.dispose();
        }

        public boolean isDisposed() {
            return this.f14716c.isDisposed();
        }

        public void onComplete() {
            if (this.f14716c != DisposableHelper.DISPOSED) {
                try {
                    CompletablePeek.this.f14711e.run();
                    CompletablePeek.this.f14712f.run();
                    this.f14715b.onComplete();
                    a();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14715b.onError(th2);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f14716c == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th2);
                return;
            }
            try {
                CompletablePeek.this.f14710d.accept(th2);
                CompletablePeek.this.f14712f.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f14715b.onError(th2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            try {
                CompletablePeek.this.f14709c.accept(disposable);
                if (DisposableHelper.validate(this.f14716c, disposable)) {
                    this.f14716c = disposable;
                    this.f14715b.onSubscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                disposable.dispose();
                this.f14716c = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th2, this.f14715b);
            }
        }
    }

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.f14708b = completableSource;
        this.f14709c = consumer;
        this.f14710d = consumer2;
        this.f14711e = action;
        this.f14712f = action2;
        this.f14713g = action3;
        this.f14714h = action4;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14708b.subscribe(new CompletableObserverImplementation(completableObserver));
    }
}
