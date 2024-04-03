package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class CompletableError extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f14657b;

    public CompletableError(Throwable th2) {
        this.f14657b = th2;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.error(this.f14657b, completableObserver);
    }
}
