package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableDefer<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends ObservableSource<? extends T>> f17089b;

    public ObservableDefer(Callable<? extends ObservableSource<? extends T>> callable) {
        this.f17089b = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            ((ObservableSource) ObjectHelper.requireNonNull(this.f17089b.call(), "null ObservableSource supplied")).subscribe(observer);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
