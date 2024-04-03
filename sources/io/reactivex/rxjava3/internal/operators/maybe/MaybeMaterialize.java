package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.operators.mixed.MaterializeSingleObserver;

public final class MaybeMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final Maybe<T> f20969b;

    public MaybeMaterialize(Maybe<T> maybe) {
        this.f20969b = maybe;
    }

    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f20969b.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
