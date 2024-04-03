package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableUsing<R> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<R> f14755b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super R, ? extends CompletableSource> f14756c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super R> f14757d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f14758e;

    public static final class UsingObserver<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -674404550052917487L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14759b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super R> f14760c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f14761d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f14762e;

        public UsingObserver(CompletableObserver completableObserver, R r11, Consumer<? super R> consumer, boolean z11) {
            super(r11);
            this.f14759b = completableObserver;
            this.f14760c = consumer;
            this.f14761d = z11;
        }

        public void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f14760c.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            this.f14762e.dispose();
            this.f14762e = DisposableHelper.DISPOSED;
            a();
        }

        public boolean isDisposed() {
            return this.f14762e.isDisposed();
        }

        public void onComplete() {
            this.f14762e = DisposableHelper.DISPOSED;
            if (this.f14761d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f14760c.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f14759b.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f14759b.onComplete();
            if (!this.f14761d) {
                a();
            }
        }

        public void onError(Throwable th2) {
            this.f14762e = DisposableHelper.DISPOSED;
            if (this.f14761d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f14760c.accept(andSet);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        th2 = new CompositeException(th2, th3);
                    }
                } else {
                    return;
                }
            }
            this.f14759b.onError(th2);
            if (!this.f14761d) {
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f14762e, disposable)) {
                this.f14762e = disposable;
                this.f14759b.onSubscribe(this);
            }
        }
    }

    public CompletableUsing(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z11) {
        this.f14755b = callable;
        this.f14756c = function;
        this.f14757d = consumer;
        this.f14758e = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            R call = this.f14755b.call();
            try {
                ((CompletableSource) ObjectHelper.requireNonNull(this.f14756c.apply(call), "The completableFunction returned a null CompletableSource")).subscribe(new UsingObserver(completableObserver, call, this.f14757d, this.f14758e));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptyDisposable.error(th3, completableObserver);
        }
    }
}
