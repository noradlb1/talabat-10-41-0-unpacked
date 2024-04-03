package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableUsing<R> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<R> f19245b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super R, ? extends CompletableSource> f19246c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super R> f19247d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f19248e;

    public static final class UsingObserver<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -674404550052917487L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19249b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super R> f19250c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f19251d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f19252e;

        public UsingObserver(CompletableObserver completableObserver, R r11, Consumer<? super R> consumer, boolean z11) {
            super(r11);
            this.f19249b = completableObserver;
            this.f19250c = consumer;
            this.f19251d = z11;
        }

        public void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f19250c.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            if (this.f19251d) {
                a();
                this.f19252e.dispose();
                this.f19252e = DisposableHelper.DISPOSED;
                return;
            }
            this.f19252e.dispose();
            this.f19252e = DisposableHelper.DISPOSED;
            a();
        }

        public boolean isDisposed() {
            return this.f19252e.isDisposed();
        }

        public void onComplete() {
            this.f19252e = DisposableHelper.DISPOSED;
            if (this.f19251d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f19250c.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f19249b.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f19249b.onComplete();
            if (!this.f19251d) {
                a();
            }
        }

        public void onError(Throwable th2) {
            this.f19252e = DisposableHelper.DISPOSED;
            if (this.f19251d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f19250c.accept(andSet);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        th2 = new CompositeException(th2, th3);
                    }
                } else {
                    return;
                }
            }
            this.f19249b.onError(th2);
            if (!this.f19251d) {
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19252e, disposable)) {
                this.f19252e = disposable;
                this.f19249b.onSubscribe(this);
            }
        }
    }

    public CompletableUsing(Supplier<R> supplier, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z11) {
        this.f19245b = supplier;
        this.f19246c = function;
        this.f19247d = consumer;
        this.f19248e = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            R r11 = this.f19245b.get();
            try {
                Object apply = this.f19246c.apply(r11);
                Objects.requireNonNull(apply, "The completableFunction returned a null CompletableSource");
                ((CompletableSource) apply).subscribe(new UsingObserver(completableObserver, r11, this.f19247d, this.f19248e));
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
