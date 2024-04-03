package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.fuseable.CancellableQueueFuseable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableFromRunnable<T> extends Flowable<T> implements Supplier<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f19838c;

    public FlowableFromRunnable(Runnable runnable) {
        this.f19838c = runnable;
    }

    public T get() throws Throwable {
        this.f19838c.run();
        return null;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        CancellableQueueFuseable cancellableQueueFuseable = new CancellableQueueFuseable();
        subscriber.onSubscribe(cancellableQueueFuseable);
        if (!cancellableQueueFuseable.isDisposed()) {
            try {
                this.f19838c.run();
                if (!cancellableQueueFuseable.isDisposed()) {
                    subscriber.onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                if (!cancellableQueueFuseable.isDisposed()) {
                    subscriber.onError(th2);
                } else {
                    RxJavaPlugins.onError(th2);
                }
            }
        }
    }
}
