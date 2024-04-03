package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends T> f17258b;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.f17258b = callable;
    }

    public T call() throws Exception {
        return ObjectHelper.requireNonNull(this.f17258b.call(), "The callable returned a null value");
    }

    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                deferredScalarDisposable.complete(ObjectHelper.requireNonNull(this.f17258b.call(), "Callable returned null"));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th2);
                } else {
                    RxJavaPlugins.onError(th2);
                }
            }
        }
    }
}
