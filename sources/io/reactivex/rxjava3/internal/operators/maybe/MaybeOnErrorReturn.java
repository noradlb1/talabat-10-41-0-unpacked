package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

public final class MaybeOnErrorReturn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f20998c;

    public static final class OnErrorReturnMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20999b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends T> f21000c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21001d;

        public OnErrorReturnMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends T> function) {
            this.f20999b = maybeObserver;
            this.f21000c = function;
        }

        public void dispose() {
            this.f21001d.dispose();
        }

        public boolean isDisposed() {
            return this.f21001d.isDisposed();
        }

        public void onComplete() {
            this.f20999b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f21000c.apply(th2);
                Objects.requireNonNull(apply, "The itemSupplier returned a null value");
                this.f20999b.onSuccess(apply);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f20999b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21001d, disposable)) {
                this.f21001d = disposable;
                this.f20999b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20999b.onSuccess(t11);
        }
    }

    public MaybeOnErrorReturn(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends T> function) {
        super(maybeSource);
        this.f20998c = function;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new OnErrorReturnMaybeObserver(maybeObserver, this.f20998c));
    }
}
