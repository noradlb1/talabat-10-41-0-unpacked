package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableOperator;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableLift<R, T> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableOperator<? extends R, ? super T> f21939c;

    public ObservableLift(ObservableSource<T> observableSource, ObservableOperator<? extends R, ? super T> observableOperator) {
        super(observableSource);
        this.f21939c = observableOperator;
    }

    public void subscribeActual(Observer<? super R> observer) {
        try {
            Observer<? super Object> apply = this.f21939c.apply(observer);
            Objects.requireNonNull(apply, "Operator " + this.f21939c + " returned a null Observer");
            this.f21304b.subscribe(apply);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }
}
