package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.a;

public final class SingleJust<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f22928b;

    public SingleJust(T t11) {
        this.f22928b = t11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        singleObserver.onSubscribe(a.a());
        singleObserver.onSuccess(this.f22928b);
    }
}
