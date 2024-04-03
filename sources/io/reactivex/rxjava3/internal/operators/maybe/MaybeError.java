package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.a;

public final class MaybeError<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f20879b;

    public MaybeError(Throwable th2) {
        this.f20879b = th2;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(a.a());
        maybeObserver.onError(this.f20879b);
    }
}
