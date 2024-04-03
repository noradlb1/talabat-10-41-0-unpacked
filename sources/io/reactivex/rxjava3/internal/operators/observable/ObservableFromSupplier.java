package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableFromSupplier<T> extends Observable<T> implements Supplier<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends T> f21804b;

    public ObservableFromSupplier(Supplier<? extends T> supplier) {
        this.f21804b = supplier;
    }

    public T get() throws Throwable {
        return ExceptionHelper.nullCheck(this.f21804b.get(), "The supplier returned a null value.");
    }

    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                deferredScalarDisposable.complete(ExceptionHelper.nullCheck(this.f21804b.get(), "Supplier returned a null value."));
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
