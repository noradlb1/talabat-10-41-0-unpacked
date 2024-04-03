package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

public final class CompletableOnErrorReturn<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19195b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f19196c;

    public static final class OnErrorReturnMaybeObserver<T> implements CompletableObserver, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f19197b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends T> f19198c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f19199d;

        public OnErrorReturnMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends T> function) {
            this.f19197b = maybeObserver;
            this.f19198c = function;
        }

        public void dispose() {
            this.f19199d.dispose();
        }

        public boolean isDisposed() {
            return this.f19199d.isDisposed();
        }

        public void onComplete() {
            this.f19197b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f19198c.apply(th2);
                Objects.requireNonNull(apply, "The itemSupplier returned a null value");
                this.f19197b.onSuccess(apply);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f19197b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f19199d, disposable)) {
                this.f19199d = disposable;
                this.f19197b.onSubscribe(this);
            }
        }
    }

    public CompletableOnErrorReturn(CompletableSource completableSource, Function<? super Throwable, ? extends T> function) {
        this.f19195b = completableSource;
        this.f19196c = function;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19195b.subscribe(new OnErrorReturnMaybeObserver(maybeObserver, this.f19196c));
    }
}
