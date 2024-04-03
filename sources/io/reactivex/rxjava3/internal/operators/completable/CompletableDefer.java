package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class CompletableDefer extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends CompletableSource> f19113b;

    public CompletableDefer(Supplier<? extends CompletableSource> supplier) {
        this.f19113b = supplier;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            Object obj = this.f19113b.get();
            Objects.requireNonNull(obj, "The completableSupplier returned a null CompletableSource");
            ((CompletableSource) obj).subscribe(completableObserver);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, completableObserver);
        }
    }
}
