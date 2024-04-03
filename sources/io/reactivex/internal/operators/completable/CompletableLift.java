package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOperator;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableLift extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14673b;

    /* renamed from: c  reason: collision with root package name */
    public final CompletableOperator f14674c;

    public CompletableLift(CompletableSource completableSource, CompletableOperator completableOperator) {
        this.f14673b = completableSource;
        this.f14674c = completableOperator;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            this.f14673b.subscribe(this.f14674c.apply(completableObserver));
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }
}
