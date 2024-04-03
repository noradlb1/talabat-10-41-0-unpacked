package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
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

public final class MaybeUsing<T, D> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends D> f21077b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super D, ? extends MaybeSource<? extends T>> f21078c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super D> f21079d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f21080e;

    public static final class UsingObserver<T, D> extends AtomicReference<Object> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -674404550052917487L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21081b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super D> f21082c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21083d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f21084e;

        public UsingObserver(MaybeObserver<? super T> maybeObserver, D d11, Consumer<? super D> consumer, boolean z11) {
            super(d11);
            this.f21081b = maybeObserver;
            this.f21082c = consumer;
            this.f21083d = z11;
        }

        public void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f21082c.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            if (this.f21083d) {
                a();
                this.f21084e.dispose();
                this.f21084e = DisposableHelper.DISPOSED;
                return;
            }
            this.f21084e.dispose();
            this.f21084e = DisposableHelper.DISPOSED;
            a();
        }

        public boolean isDisposed() {
            return this.f21084e.isDisposed();
        }

        public void onComplete() {
            this.f21084e = DisposableHelper.DISPOSED;
            if (this.f21083d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f21082c.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f21081b.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f21081b.onComplete();
            if (!this.f21083d) {
                a();
            }
        }

        public void onError(Throwable th2) {
            this.f21084e = DisposableHelper.DISPOSED;
            if (this.f21083d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f21082c.accept(andSet);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        th2 = new CompositeException(th2, th3);
                    }
                } else {
                    return;
                }
            }
            this.f21081b.onError(th2);
            if (!this.f21083d) {
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21084e, disposable)) {
                this.f21084e = disposable;
                this.f21081b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f21084e = DisposableHelper.DISPOSED;
            if (this.f21083d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f21082c.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f21081b.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f21081b.onSuccess(t11);
            if (!this.f21083d) {
                a();
            }
        }
    }

    public MaybeUsing(Supplier<? extends D> supplier, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer, boolean z11) {
        this.f21077b = supplier;
        this.f21078c = function;
        this.f21079d = consumer;
        this.f21080e = z11;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            Object obj = this.f21077b.get();
            try {
                Object apply = this.f21078c.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null MaybeSource");
                ((MaybeSource) apply).subscribe(new UsingObserver(maybeObserver, obj, this.f21079d, this.f21080e));
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
