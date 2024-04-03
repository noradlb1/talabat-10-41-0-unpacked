package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeFromSupplier<T> extends Maybe<T> implements Supplier<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends T> f20950b;

    public MaybeFromSupplier(Supplier<? extends T> supplier) {
        this.f20950b = supplier;
    }

    public T get() throws Throwable {
        return this.f20950b.get();
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable b11 = a.b();
        maybeObserver.onSubscribe(b11);
        if (!b11.isDisposed()) {
            try {
                Object obj = this.f20950b.get();
                if (b11.isDisposed()) {
                    return;
                }
                if (obj == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(obj);
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
