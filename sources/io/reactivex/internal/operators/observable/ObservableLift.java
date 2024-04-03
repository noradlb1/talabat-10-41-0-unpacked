package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableLift<R, T> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final ObservableOperator<? extends R, ? super T> f17392c;

    public ObservableLift(ObservableSource<T> observableSource, ObservableOperator<? extends R, ? super T> observableOperator) {
        super(observableSource);
        this.f17392c = observableOperator;
    }

    public void subscribeActual(Observer<? super R> observer) {
        try {
            Observer<? super Object> apply = this.f17392c.apply(observer);
            this.f16799b.subscribe((Observer) ObjectHelper.requireNonNull(apply, "Operator " + this.f17392c + " returned a null Observer"));
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
