package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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

public final class MaybeUsing<T, D> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends D> f16564b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super D, ? extends MaybeSource<? extends T>> f16565c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super D> f16566d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f16567e;

    public static final class UsingObserver<T, D> extends AtomicReference<Object> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -674404550052917487L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16568b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super D> f16569c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16570d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f16571e;

        public UsingObserver(MaybeObserver<? super T> maybeObserver, D d11, Consumer<? super D> consumer, boolean z11) {
            super(d11);
            this.f16568b = maybeObserver;
            this.f16569c = consumer;
            this.f16570d = z11;
        }

        public void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f16569c.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            this.f16571e.dispose();
            this.f16571e = DisposableHelper.DISPOSED;
            a();
        }

        public boolean isDisposed() {
            return this.f16571e.isDisposed();
        }

        public void onComplete() {
            this.f16571e = DisposableHelper.DISPOSED;
            if (this.f16570d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f16569c.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f16568b.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f16568b.onComplete();
            if (!this.f16570d) {
                a();
            }
        }

        public void onError(Throwable th2) {
            this.f16571e = DisposableHelper.DISPOSED;
            if (this.f16570d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f16569c.accept(andSet);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        th2 = new CompositeException(th2, th3);
                    }
                } else {
                    return;
                }
            }
            this.f16568b.onError(th2);
            if (!this.f16570d) {
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16571e, disposable)) {
                this.f16571e = disposable;
                this.f16568b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16571e = DisposableHelper.DISPOSED;
            if (this.f16570d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f16569c.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f16568b.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f16568b.onSuccess(t11);
            if (!this.f16570d) {
                a();
            }
        }
    }

    public MaybeUsing(Callable<? extends D> callable, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer, boolean z11) {
        this.f16564b = callable;
        this.f16565c = function;
        this.f16566d = consumer;
        this.f16567e = z11;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            Object call = this.f16564b.call();
            try {
                ((MaybeSource) ObjectHelper.requireNonNull(this.f16565c.apply(call), "The sourceSupplier returned a null MaybeSource")).subscribe(new UsingObserver(maybeObserver, call, this.f16566d, this.f16567e));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptyDisposable.error(th3, (MaybeObserver<?>) maybeObserver);
        }
    }
}
