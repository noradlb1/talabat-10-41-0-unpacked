package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class CompletableDefer extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends CompletableSource> f14628b;

    public CompletableDefer(Callable<? extends CompletableSource> callable) {
        this.f14628b = callable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            ((CompletableSource) ObjectHelper.requireNonNull(this.f14628b.call(), "The completableSupplier returned a null CompletableSource")).subscribe(completableObserver);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, completableObserver);
        }
    }
}
