package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

@Experimental
public final class MaterializeSingleObserver<T> implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final SingleObserver<? super Notification<T>> f16695b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f16696c;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.f16695b = singleObserver;
    }

    public void dispose() {
        this.f16696c.dispose();
    }

    public boolean isDisposed() {
        return this.f16696c.isDisposed();
    }

    public void onComplete() {
        this.f16695b.onSuccess(Notification.createOnComplete());
    }

    public void onError(Throwable th2) {
        this.f16695b.onSuccess(Notification.createOnError(th2));
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f16696c, disposable)) {
            this.f16696c = disposable;
            this.f16695b.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        this.f16695b.onSuccess(Notification.createOnNext(t11));
    }
}
