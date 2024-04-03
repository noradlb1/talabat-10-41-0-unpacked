package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromAction<T> extends Maybe<T> implements Callable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Action f16433b;

    public MaybeFromAction(Action action) {
        this.f16433b = action;
    }

    public T call() throws Exception {
        this.f16433b.run();
        return null;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                this.f16433b.run();
                if (!empty.isDisposed()) {
                    maybeObserver.onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                if (!empty.isDisposed()) {
                    maybeObserver.onError(th2);
                } else {
                    RxJavaPlugins.onError(th2);
                }
            }
        }
    }
}
