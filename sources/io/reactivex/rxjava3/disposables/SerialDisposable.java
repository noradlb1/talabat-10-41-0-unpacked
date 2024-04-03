package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SerialDisposable implements Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Disposable> f18784b;

    public SerialDisposable() {
        this.f18784b = new AtomicReference<>();
    }

    public void dispose() {
        DisposableHelper.dispose(this.f18784b);
    }

    @Nullable
    public Disposable get() {
        Disposable disposable = this.f18784b.get();
        if (disposable == DisposableHelper.DISPOSED) {
            return a.a();
        }
        return disposable;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f18784b.get());
    }

    public boolean replace(@Nullable Disposable disposable) {
        return DisposableHelper.replace(this.f18784b, disposable);
    }

    public boolean set(@Nullable Disposable disposable) {
        return DisposableHelper.set(this.f18784b, disposable);
    }

    public SerialDisposable(@Nullable Disposable disposable) {
        this.f18784b = new AtomicReference<>(disposable);
    }
}
