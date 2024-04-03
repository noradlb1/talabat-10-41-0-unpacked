package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

@Experimental
public final class MaybeMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final Maybe<T> f16463b;

    public MaybeMaterialize(Maybe<T> maybe) {
        this.f16463b = maybe;
    }

    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f16463b.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
