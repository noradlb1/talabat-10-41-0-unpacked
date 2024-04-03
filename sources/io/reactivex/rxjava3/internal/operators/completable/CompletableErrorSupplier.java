package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class CompletableErrorSupplier extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends Throwable> f19143b;

    public CompletableErrorSupplier(Supplier<? extends Throwable> supplier) {
        this.f19143b = supplier;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            Object obj = this.f19143b.get();
            Objects.requireNonNull(obj, "The error returned is null");
            th = (Throwable) obj;
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, completableObserver);
    }
}
