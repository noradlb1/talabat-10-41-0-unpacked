package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableFromAction<T> extends Observable<T> implements Supplier<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Action f21779b;

    public ObservableFromAction(Action action) {
        this.f21779b = action;
    }

    public T get() throws Throwable {
        this.f21779b.run();
        return null;
    }

    public void subscribeActual(Observer<? super T> observer) {
        CancellableQueueFuseable cancellableQueueFuseable = new CancellableQueueFuseable();
        observer.onSubscribe(cancellableQueueFuseable);
        if (!cancellableQueueFuseable.isDisposed()) {
            try {
                this.f21779b.run();
                if (!cancellableQueueFuseable.isDisposed()) {
                    observer.onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                if (!cancellableQueueFuseable.isDisposed()) {
                    observer.onError(th2);
                } else {
                    RxJavaPlugins.onError(th2);
                }
            }
        }
    }
}
