package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class CompletableFromCallable extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<?> f14660b;

    public CompletableFromCallable(Callable<?> callable) {
        this.f14660b = callable;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable empty = Disposables.empty();
        completableObserver.onSubscribe(empty);
        try {
            this.f14660b.call();
            if (!empty.isDisposed()) {
                completableObserver.onComplete();
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            if (!empty.isDisposed()) {
                completableObserver.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }
    }
}
