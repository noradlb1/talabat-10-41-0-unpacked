package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends T> f16434b;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.f16434b = callable;
    }

    public T call() throws Exception {
        return this.f16434b.call();
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                Object call = this.f16434b.call();
                if (empty.isDisposed()) {
                    return;
                }
                if (call == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(call);
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
