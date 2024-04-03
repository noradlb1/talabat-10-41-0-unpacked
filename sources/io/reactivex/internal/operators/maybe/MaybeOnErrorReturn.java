package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeOnErrorReturn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f16494c;

    public static final class OnErrorReturnMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16495b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends T> f16496c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16497d;

        public OnErrorReturnMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends T> function) {
            this.f16495b = maybeObserver;
            this.f16496c = function;
        }

        public void dispose() {
            this.f16497d.dispose();
        }

        public boolean isDisposed() {
            return this.f16497d.isDisposed();
        }

        public void onComplete() {
            this.f16495b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                this.f16495b.onSuccess(ObjectHelper.requireNonNull(this.f16496c.apply(th2), "The valueSupplier returned a null value"));
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f16495b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16497d, disposable)) {
                this.f16497d = disposable;
                this.f16495b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16495b.onSuccess(t11);
        }
    }

    public MaybeOnErrorReturn(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends T> function) {
        super(maybeSource);
        this.f16494c = function;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new OnErrorReturnMaybeObserver(maybeObserver, this.f16494c));
    }
}
