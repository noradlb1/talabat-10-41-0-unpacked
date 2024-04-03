package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeFromAction<T> extends Maybe<T> implements Supplier<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Action f20938b;

    public MaybeFromAction(Action action) {
        this.f20938b = action;
    }

    public T get() throws Throwable {
        this.f20938b.run();
        return null;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable b11 = a.b();
        maybeObserver.onSubscribe(b11);
        if (!b11.isDisposed()) {
            try {
                this.f20938b.run();
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
