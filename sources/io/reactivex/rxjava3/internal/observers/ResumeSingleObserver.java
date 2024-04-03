package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ResumeSingleObserver<T> implements SingleObserver<T> {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Disposable> f19062b;

    /* renamed from: c  reason: collision with root package name */
    public final SingleObserver<? super T> f19063c;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.f19062b = atomicReference;
        this.f19063c = singleObserver;
    }

    public void onError(Throwable th2) {
        this.f19063c.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f19062b, disposable);
    }

    public void onSuccess(T t11) {
        this.f19063c.onSuccess(t11);
    }
}
