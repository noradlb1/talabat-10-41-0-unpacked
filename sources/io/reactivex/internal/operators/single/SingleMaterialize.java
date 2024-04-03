package io.reactivex.internal.operators.single;

import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

@Experimental
public final class SingleMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final Single<T> f18377b;

    public SingleMaterialize(Single<T> single) {
        this.f18377b = single;
    }

    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f18377b.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
