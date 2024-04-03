package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class DisposeOnCancel implements Future<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final Disposable f18475b;

    public DisposeOnCancel(Disposable disposable) {
        this.f18475b = disposable;
    }

    public boolean cancel(boolean z11) {
        this.f18475b.dispose();
        return false;
    }

    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    public Object get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }
}
