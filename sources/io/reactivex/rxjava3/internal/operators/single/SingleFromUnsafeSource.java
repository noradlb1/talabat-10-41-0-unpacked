package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;

public final class SingleFromUnsafeSource<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22924b;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.f22924b = singleSource;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22924b.subscribe(singleObserver);
    }
}
