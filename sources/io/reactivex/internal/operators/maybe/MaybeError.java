package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;

public final class MaybeError<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f16368b;

    public MaybeError(Throwable th2) {
        this.f16368b = th2;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.disposed());
        maybeObserver.onError(this.f16368b);
    }
}
