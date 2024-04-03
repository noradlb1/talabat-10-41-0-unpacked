package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class CompletableErrorSupplier extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends Throwable> f14658b;

    public CompletableErrorSupplier(Callable<? extends Throwable> callable) {
        this.f14658b = callable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f14658b.call(), "The error returned is null");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, completableObserver);
    }
}
