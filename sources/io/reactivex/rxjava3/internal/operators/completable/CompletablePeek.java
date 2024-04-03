package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class CompletablePeek extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19200b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Disposable> f19201c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super Throwable> f19202d;

    /* renamed from: e  reason: collision with root package name */
    public final Action f19203e;

    /* renamed from: f  reason: collision with root package name */
    public final Action f19204f;

    /* renamed from: g  reason: collision with root package name */
    public final Action f19205g;

    /* renamed from: h  reason: collision with root package name */
    public final Action f19206h;

    public final class CompletableObserverImplementation implements CompletableObserver, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19207b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f19208c;

        public CompletableObserverImplementation(CompletableObserver completableObserver) {
            this.f19207b = completableObserver;
        }

        public void a() {
            try {
                CompletablePeek.this.f19205g.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        public void dispose() {
            try {
                CompletablePeek.this.f19206h.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f19208c.dispose();
        }

        public boolean isDisposed() {
            return this.f19208c.isDisposed();
        }

        public void onComplete() {
            if (this.f19208c != DisposableHelper.DISPOSED) {
                try {
                    CompletablePeek.this.f19203e.run();
                    CompletablePeek.this.f19204f.run();
                    this.f19207b.onComplete();
                    a();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19207b.onError(th2);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f19208c == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th2);
                return;
            }
            try {
                CompletablePeek.this.f19202d.accept(th2);
                CompletablePeek.this.f19204f.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f19207b.onError(th2);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            try {
                CompletablePeek.this.f19201c.accept(disposable);
                if (DisposableHelper.validate(this.f19208c, disposable)) {
                    this.f19208c = disposable;
                    this.f19207b.onSubscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                disposable.dispose();
                this.f19208c = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th2, this.f19207b);
            }
        }
    }

    public CompletablePeek(CompletableSource completableSource, Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        this.f19200b = completableSource;
        this.f19201c = consumer;
        this.f19202d = consumer2;
        this.f19203e = action;
        this.f19204f = action2;
        this.f19205g = action3;
        this.f19206h = action4;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19200b.subscribe(new CompletableObserverImplementation(completableObserver));
    }
}
