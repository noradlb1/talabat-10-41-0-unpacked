package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableFromCallable<T> extends Flowable<T> implements Callable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends T> f15310c;

    public FlowableFromCallable(Callable<? extends T> callable) {
        this.f15310c = callable;
    }

    public T call() throws Exception {
        return ObjectHelper.requireNonNull(this.f15310c.call(), "The callable returned a null value");
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            deferredScalarSubscription.complete(ObjectHelper.requireNonNull(this.f15310c.call(), "The callable returned a null value"));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            if (deferredScalarSubscription.isCancelled()) {
                RxJavaPlugins.onError(th2);
            } else {
                subscriber.onError(th2);
            }
        }
    }
}
