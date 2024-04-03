package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

public final class SingleError<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends Throwable> f22860b;

    public SingleError(Supplier<? extends Throwable> supplier) {
        this.f22860b = supplier;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            th = (Throwable) ExceptionHelper.nullCheck(this.f22860b.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
    }
}
