package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class CompletableFromCallable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<?> f19145b;

    public CompletableFromCallable(Callable<?> callable) {
        this.f19145b = callable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable b11 = a.b();
        completableObserver.onSubscribe(b11);
        try {
            this.f19145b.call();
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
