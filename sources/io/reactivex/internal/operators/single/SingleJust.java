package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposables;

public final class SingleJust<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f18370b;

    public SingleJust(T t11) {
        this.f18370b = t11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(Disposables.disposed());
        singleObserver.onSuccess(this.f18370b);
    }
}
