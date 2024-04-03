package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromRunnable<T> extends Maybe<T> implements Callable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f16441b;

    public MaybeFromRunnable(Runnable runnable) {
        this.f16441b = runnable;
    }

    public T call() throws Exception {
        this.f16441b.run();
        return null;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                this.f16441b.run();
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
