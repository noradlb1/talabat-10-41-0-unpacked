package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ObservableFromFuture<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Future<? extends T> f21790b;

    /* renamed from: c  reason: collision with root package name */
    public final long f21791c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f21792d;

    public ObservableFromFuture(Future<? extends T> future, long j11, TimeUnit timeUnit) {
        this.f21790b = future;
        this.f21791c = j11;
        this.f21792d = timeUnit;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Object obj;
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                TimeUnit timeUnit = this.f21792d;
                if (timeUnit != null) {
                    obj = this.f21790b.get(this.f21791c, timeUnit);
                } else {
                    obj = this.f21790b.get();
                }
                deferredScalarDisposable.complete(ExceptionHelper.nullCheck(obj, "Future returned a null value."));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th2);
                }
            }
        }
    }
}
