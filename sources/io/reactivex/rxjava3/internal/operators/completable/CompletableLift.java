package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOperator;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class CompletableLift extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19159b;

    /* renamed from: c  reason: collision with root package name */
    public final CompletableOperator f19160c;

    public CompletableLift(CompletableSource completableSource, CompletableOperator completableOperator) {
        this.f19159b = completableSource;
        this.f19160c = completableOperator;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        try {
            this.f19159b.subscribe(this.f19160c.apply(completableObserver));
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }
}
