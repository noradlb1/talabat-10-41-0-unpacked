package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class CompletableFromSupplier extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<?> f19154b;

    public CompletableFromSupplier(Supplier<?> supplier) {
        this.f19154b = supplier;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable b11 = a.b();
        completableObserver.onSubscribe(b11);
        try {
            this.f19154b.get();
            if (!b11.isDisposed()) {
                completableObserver.onComplete();
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            if (!b11.isDisposed()) {
                completableObserver.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }
    }
}
