package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableError<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends Throwable> f17173b;

    public ObservableError(Callable<? extends Throwable> callable) {
        this.f17173b = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f17173b.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, (Observer<?>) observer);
    }
}
