package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeOperator;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class MaybeLift<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeOperator<? extends R, ? super T> f20964c;

    public MaybeLift(MaybeSource<T> maybeSource, MaybeOperator<? extends R, ? super T> maybeOperator) {
        super(maybeSource);
        this.f20964c = maybeOperator;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        try {
            MaybeObserver<? super Object> apply = this.f20964c.apply(maybeObserver);
            Objects.requireNonNull(apply, "The operator returned a null MaybeObserver");
            this.f20763b.subscribe(apply);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (MaybeObserver<?>) maybeObserver);
        }
    }
}
