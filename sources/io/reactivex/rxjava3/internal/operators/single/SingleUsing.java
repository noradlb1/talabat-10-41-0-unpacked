package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
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

public final class SingleUsing<T, U> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<U> f22996b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super U, ? extends SingleSource<? extends T>> f22997c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super U> f22998d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f22999e;

    public static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5331524057054083935L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f23000b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super U> f23001c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f23002d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f23003e;

        public UsingSingleObserver(SingleObserver<? super T> singleObserver, U u11, boolean z11, Consumer<? super U> consumer) {
            super(u11);
            this.f23000b = singleObserver;
            this.f23002d = z11;
            this.f23001c = consumer;
        }

        public void a() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f23001c.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            if (this.f23002d) {
                a();
                this.f23003e.dispose();
                this.f23003e = DisposableHelper.DISPOSED;
                return;
            }
            this.f23003e.dispose();
            this.f23003e = DisposableHelper.DISPOSED;
            a();
        }

        public boolean isDisposed() {
            return this.f23003e.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f23003e = DisposableHelper.DISPOSED;
            if (this.f23002d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f23001c.accept(andSet);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        th2 = new CompositeException(th2, th3);
                    }
                } else {
                    return;
                }
            }
            this.f23000b.onError(th2);
            if (!this.f23002d) {
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f23003e, disposable)) {
                this.f23003e = disposable;
                this.f23000b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f23003e = DisposableHelper.DISPOSED;
            if (this.f23002d) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.f23001c.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f23000b.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f23000b.onSuccess(t11);
            if (!this.f23002d) {
                a();
            }
        }
    }

    public SingleUsing(Supplier<U> supplier, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z11) {
        this.f22996b = supplier;
        this.f22997c = function;
        this.f22998d = consumer;
        this.f22999e = z11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            U u11 = this.f22996b.get();
            try {
                Object apply = this.f22997c.apply(u11);
                Objects.requireNonNull(apply, "The singleFunction returned a null SingleSource");
                ((SingleSource) apply).subscribe(new UsingSingleObserver(singleObserver, u11, this.f22999e, this.f22998d));
                return;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
                return;
            }
            EmptyDisposable.error((Throwable) th, (SingleObserver<?>) singleObserver);
            if (!this.f22999e) {
                this.f22998d.accept(u11);
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptyDisposable.error(th3, (SingleObserver<?>) singleObserver);
        }
    }
}
