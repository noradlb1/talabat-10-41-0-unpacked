package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ResumeSingleObserver<T> implements SingleObserver<T> {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Disposable> f14581b;

    /* renamed from: c  reason: collision with root package name */
    public final SingleObserver<? super T> f14582c;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.f14581b = atomicReference;
        this.f14582c = singleObserver;
    }

    public void onError(Throwable th2) {
        this.f14582c.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f14581b, disposable);
    }

    public void onSuccess(T t11) {
        this.f14582c.onSuccess(t11);
    }
}
