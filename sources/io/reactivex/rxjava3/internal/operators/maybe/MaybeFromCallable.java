package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromCallable<T> extends Maybe<T> implements Supplier<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends T> f20939b;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.f20939b = callable;
    }

    public T get() throws Exception {
        return this.f20939b.call();
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable b11 = a.b();
        maybeObserver.onSubscribe(b11);
        if (!b11.isDisposed()) {
            try {
                Object call = this.f20939b.call();
                if (b11.isDisposed()) {
                    return;
                }
                if (call == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(call);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                if (!b11.isDisposed()) {
                    maybeObserver.onError(th2);
                } else {
                    RxJavaPlugins.onError(th2);
                }
            }
        }
    }
}
