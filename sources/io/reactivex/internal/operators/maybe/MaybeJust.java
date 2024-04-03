package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.fuseable.ScalarCallable;

public final class MaybeJust<T> extends Maybe<T> implements ScalarCallable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f16457b;

    public MaybeJust(T t11) {
        this.f16457b = t11;
    }

    public T call() {
        return this.f16457b;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.disposed());
        maybeObserver.onSuccess(this.f16457b);
    }
}
