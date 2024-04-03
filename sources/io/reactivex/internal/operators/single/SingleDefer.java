package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class SingleDefer<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends SingleSource<? extends T>> f18235b;

    public SingleDefer(Callable<? extends SingleSource<? extends T>> callable) {
        this.f18235b = callable;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            ((SingleSource) ObjectHelper.requireNonNull(this.f18235b.call(), "The singleSupplier returned a null SingleSource")).subscribe(singleObserver);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
