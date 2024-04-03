package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOperator;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeLift<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeOperator<? extends R, ? super T> f16458c;

    public MaybeLift(MaybeSource<T> maybeSource, MaybeOperator<? extends R, ? super T> maybeOperator) {
        super(maybeSource);
        this.f16458c = maybeOperator;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        try {
            this.f16264b.subscribe((MaybeObserver) ObjectHelper.requireNonNull(this.f16458c.apply(maybeObserver), "The operator returned a null MaybeObserver"));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (MaybeObserver<?>) maybeObserver);
        }
    }
}
