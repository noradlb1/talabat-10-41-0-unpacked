package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

@Experimental
public final class CompletableMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final Completable f14675b;

    public CompletableMaterialize(Completable completable) {
        this.f14675b = completable;
    }

    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f14675b.subscribe((CompletableObserver) new MaterializeSingleObserver(singleObserver));
    }
}
