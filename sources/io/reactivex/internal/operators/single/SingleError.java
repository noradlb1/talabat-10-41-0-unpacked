package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class SingleError<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends Throwable> f18319b;

    public SingleError(Callable<? extends Throwable> callable) {
        this.f18319b = callable;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f18319b.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
    }
}
