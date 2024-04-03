package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.operators.mixed.MaterializeSingleObserver;

public final class CompletableMaterialize<T> extends Single<Notification<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final Completable f19161b;

    public CompletableMaterialize(Completable completable) {
        this.f19161b = completable;
    }

    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.f19161b.subscribe((CompletableObserver) new MaterializeSingleObserver(singleObserver));
    }
}
