package io.reactivex.observers;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableSingleObserver<T> implements SingleObserver<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Disposable> f18654b = new AtomicReference<>();

    public void a() {
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f18654b);
    }

    public final boolean isDisposed() {
        return this.f18654b.get() == DisposableHelper.DISPOSED;
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f18654b, disposable, getClass())) {
            a();
        }
    }
}
