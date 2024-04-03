package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOperator;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class SingleLift<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22929b;

    /* renamed from: c  reason: collision with root package name */
    public final SingleOperator<? extends R, ? super T> f22930c;

    public SingleLift(SingleSource<T> singleSource, SingleOperator<? extends R, ? super T> singleOperator) {
        this.f22929b = singleSource;
        this.f22930c = singleOperator;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            SingleObserver<? super Object> apply = this.f22930c.apply(singleObserver);
            Objects.requireNonNull(apply, "The onLift returned a null SingleObserver");
            this.f22929b.subscribe(apply);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
