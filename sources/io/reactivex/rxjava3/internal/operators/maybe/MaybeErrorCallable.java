package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

public final class MaybeErrorCallable<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends Throwable> f20880b;

    public MaybeErrorCallable(Supplier<? extends Throwable> supplier) {
        this.f20880b = supplier;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(a.a());
        try {
            th = (Throwable) ExceptionHelper.nullCheck(this.f20880b.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        maybeObserver.onError(th);
    }
}
