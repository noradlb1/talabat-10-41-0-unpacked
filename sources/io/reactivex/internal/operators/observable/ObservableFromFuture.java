package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ObservableFromFuture<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Future<? extends T> f17259b;

    /* renamed from: c  reason: collision with root package name */
    public final long f17260c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f17261d;

    public ObservableFromFuture(Future<? extends T> future, long j11, TimeUnit timeUnit) {
        this.f17259b = future;
        this.f17260c = j11;
        this.f17261d = timeUnit;
    }

    public void subscribeActual(Observer<? super T> observer) {
        Object obj;
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (!deferredScalarDisposable.isDisposed()) {
            try {
                TimeUnit timeUnit = this.f17261d;
                if (timeUnit != null) {
                    obj = this.f17259b.get(this.f17260c, timeUnit);
                } else {
                    obj = this.f17259b.get();
                }
                deferredScalarDisposable.complete(ObjectHelper.requireNonNull(obj, "Future returned null"));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th2);
                }
            }
        }
    }
}
