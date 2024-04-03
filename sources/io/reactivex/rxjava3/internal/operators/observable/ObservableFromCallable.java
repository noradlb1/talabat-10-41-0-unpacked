package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableFromCallable<T> extends Observable<T> implements Supplier<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends T> f21786b;

    public ObservableFromCallable(Callable<? extends T> callable) {
        this.f21786b = callable;
    }

    public T get() throws Throwable {
        return ExceptionHelper.nullCheck(this.f21786b.call(), "The Callable returned a null value.");
    }

    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                deferredScalarDisposable.complete(ExceptionHelper.nullCheck(this.f21786b.call(), "Callable returned a null value."));
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
