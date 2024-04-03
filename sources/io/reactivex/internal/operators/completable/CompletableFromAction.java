package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableFromAction extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Action f14659b;

    public CompletableFromAction(Action action) {
        this.f14659b = action;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        Disposable empty = Disposables.empty();
        completableObserver.onSubscribe(empty);
        try {
            this.f14659b.run();
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
