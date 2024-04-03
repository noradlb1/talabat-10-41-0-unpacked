package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableFromCallable<T> extends Flowable<T> implements Supplier<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends T> f19822c;

    public FlowableFromCallable(Callable<? extends T> callable) {
        this.f19822c = callable;
    }

    public T get() throws Throwable {
        T call = this.f19822c.call();
        Objects.requireNonNull(call, "The callable returned a null value");
        return call;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            Object call = this.f19822c.call();
            Objects.requireNonNull(call, "The callable returned a null value");
            deferredScalarSubscription.complete(call);
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
