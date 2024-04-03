package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.operators.ScalarSupplier;

public final class MaybeJust<T> extends Maybe<T> implements ScalarSupplier<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f20963b;

    public MaybeJust(T t11) {
        this.f20963b = t11;
    }

    public T get() {
        return this.f20963b;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(a.a());
        maybeObserver.onSuccess(this.f20963b);
    }
}
