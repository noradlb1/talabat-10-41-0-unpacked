package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class DisposeOnCancel implements Future<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final Disposable f23031b;

    public DisposeOnCancel(Disposable disposable) {
        this.f23031b = disposable;
    }

    public boolean cancel(boolean z11) {
        this.f23031b.dispose();
        return false;
    }

    public Object get() {
        return null;
    }

    public Object get(long j11, @NonNull TimeUnit timeUnit) {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }
}
