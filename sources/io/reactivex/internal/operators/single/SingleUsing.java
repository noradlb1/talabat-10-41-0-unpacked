package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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

public final class SingleUsing<T, U> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<U> f18427b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super U, ? extends SingleSource<? extends T>> f18428c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super U> f18429d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f18430e;

    public static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5331524057054083935L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18431b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super U> f18432c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f18433d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f18434e;

        public UsingSingleObserver(SingleObserver<? super T> singleObserver, U u11, boolean z11, Consumer<? super U> consumer) {
            super(u11);
            this.f18431b = singleObserver;
            this.f18433d = z11;
            this.f18432c = consumer;
        }

        public void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f18432c.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            this.f18434e.dispose();
            this.f18434e = DisposableHelper.DISPOSED;
            a();
        }

        public boolean isDisposed() {
            return this.f18434e.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f18434e = DisposableHelper.DISPOSED;
            if (this.f18433d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f18432c.accept(andSet);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        th2 = new CompositeException(th2, th3);
                    }
                } else {
                    return;
                }
            }
            this.f18431b.onError(th2);
            if (!this.f18433d) {
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f18434e, disposable)) {
                this.f18434e = disposable;
                this.f18431b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f18434e = DisposableHelper.DISPOSED;
            if (this.f18433d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f18432c.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f18431b.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f18431b.onSuccess(t11);
            if (!this.f18433d) {
                a();
            }
        }
    }

    public SingleUsing(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z11) {
        this.f18427b = callable;
        this.f18428c = function;
        this.f18429d = consumer;
        this.f18430e = z11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            U call = this.f18427b.call();
            try {
                ((SingleSource) ObjectHelper.requireNonNull(this.f18428c.apply(call), "The singleFunction returned a null SingleSource")).subscribe(new UsingSingleObserver(singleObserver, call, this.f18430e, this.f18429d));
                return;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
                return;
            }
            EmptyDisposable.error((Throwable) th, (SingleObserver<?>) singleObserver);
            if (!this.f18430e) {
                this.f18429d.accept(call);
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptyDisposable.error(th3, (SingleObserver<?>) singleObserver);
        }
    }
}
