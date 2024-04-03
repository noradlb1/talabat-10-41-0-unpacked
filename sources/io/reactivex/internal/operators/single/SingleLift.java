package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOperator;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

public final class SingleLift<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18371b;

    /* renamed from: c  reason: collision with root package name */
    public final SingleOperator<? extends R, ? super T> f18372c;

    public SingleLift(SingleSource<T> singleSource, SingleOperator<? extends R, ? super T> singleOperator) {
        this.f18371b = singleSource;
        this.f18372c = singleOperator;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f18371b.subscribe((SingleObserver) ObjectHelper.requireNonNull(this.f18372c.apply(singleObserver), "The onLift returned a null SingleObserver"));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
