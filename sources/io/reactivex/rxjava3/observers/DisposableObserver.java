package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Disposable> f23213b = new AtomicReference<>();

    public void a() {
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f23213b);
    }

    public final boolean isDisposed() {
        return this.f23213b.get() == DisposableHelper.DISPOSED;
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f23213b, disposable, getClass())) {
            a();
        }
    }
}
