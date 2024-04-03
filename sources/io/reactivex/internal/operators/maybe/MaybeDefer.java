package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class MaybeDefer<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends MaybeSource<? extends T>> f16313b;

    public MaybeDefer(Callable<? extends MaybeSource<? extends T>> callable) {
        this.f16313b = callable;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            ((MaybeSource) ObjectHelper.requireNonNull(this.f16313b.call(), "The maybeSupplier returned a null MaybeSource")).subscribe(maybeObserver);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (MaybeObserver<?>) maybeObserver);
        }
    }
}
