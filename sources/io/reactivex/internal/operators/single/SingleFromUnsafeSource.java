package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

public final class SingleFromUnsafeSource<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18366b;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.f18366b = singleSource;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18366b.subscribe(singleObserver);
    }
}
