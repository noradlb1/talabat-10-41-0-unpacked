package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaterializeSingleObserver<T> implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final SingleObserver<? super Notification<T>> f21219b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f21220c;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.f21219b = singleObserver;
    }

    public void dispose() {
        this.f21220c.dispose();
    }

    public boolean isDisposed() {
        return this.f21220c.isDisposed();
    }

    public void onComplete() {
        this.f21219b.onSuccess(Notification.createOnComplete());
    }

    public void onError(Throwable th2) {
        this.f21219b.onSuccess(Notification.createOnError(th2));
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f21220c, disposable)) {
            this.f21220c = disposable;
            this.f21219b.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.f21219b.onSuccess(Notification.createOnNext(t11));
    }
}
