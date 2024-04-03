package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class MaybeDefer<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends MaybeSource<? extends T>> f20812b;

    public MaybeDefer(Supplier<? extends MaybeSource<? extends T>> supplier) {
        this.f20812b = supplier;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            Object obj = this.f20812b.get();
            Objects.requireNonNull(obj, "The maybeSupplier returned a null MaybeSource");
            ((MaybeSource) obj).subscribe(maybeObserver);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (MaybeObserver<?>) maybeObserver);
        }
    }
}
