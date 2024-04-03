package io.reactivex.disposables;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SerialDisposable implements Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Disposable> f14496b;

    public SerialDisposable() {
        this.f14496b = new AtomicReference<>();
    }

    public void dispose() {
        DisposableHelper.dispose(this.f14496b);
    }

    @Nullable
    public Disposable get() {
        Disposable disposable = this.f14496b.get();
        if (disposable == DisposableHelper.DISPOSED) {
            return Disposables.disposed();
        }
        return disposable;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f14496b.get());
    }

    public boolean replace(@Nullable Disposable disposable) {
        return DisposableHelper.replace(this.f14496b, disposable);
    }

    public boolean set(@Nullable Disposable disposable) {
        return DisposableHelper.set(this.f14496b, disposable);
    }

    public SerialDisposable(@Nullable Disposable disposable) {
        this.f14496b = new AtomicReference<>(disposable);
    }
}
