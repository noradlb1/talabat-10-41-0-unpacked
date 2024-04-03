package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeFromRunnable<T> extends Maybe<T> implements Supplier<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Runnable f20946b;

    public MaybeFromRunnable(Runnable runnable) {
        this.f20946b = runnable;
    }

    public T get() {
        this.f20946b.run();
        return null;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable b11 = a.b();
        maybeObserver.onSubscribe(b11);
        if (!b11.isDisposed()) {
            try {
                this.f20946b.run();
                if (!b11.isDisposed()) {
                    maybeObserver.onComplete();
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
