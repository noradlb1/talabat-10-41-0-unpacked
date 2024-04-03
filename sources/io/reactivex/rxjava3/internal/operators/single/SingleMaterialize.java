package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.operators.mixed.MaterializeSingleObserver;

public final class SingleMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final Single<T> f22935b;

    public SingleMaterialize(Single<T> single) {
        this.f22935b = single;
    }

    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f22935b.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
