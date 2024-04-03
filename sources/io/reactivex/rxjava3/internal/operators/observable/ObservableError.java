package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

public final class ObservableError<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends Throwable> f21701b;

    public ObservableError(Supplier<? extends Throwable> supplier) {
        this.f21701b = supplier;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            th = (Throwable) ExceptionHelper.nullCheck(this.f21701b.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, (Observer<?>) observer);
    }
}
