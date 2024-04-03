package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

public final class CompletableError extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f19142b;

    public CompletableError(Throwable th2) {
        this.f19142b = th2;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        EmptyDisposable.error(this.f19142b, completableObserver);
    }
}
