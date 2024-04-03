package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableFromSupplier<T> extends Flowable<T> implements Supplier<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<? extends T> f19839c;

    public FlowableFromSupplier(Supplier<? extends T> supplier) {
        this.f19839c = supplier;
    }

    public T get() throws Throwable {
        T t11 = this.f19839c.get();
        Objects.requireNonNull(t11, "The supplier returned a null value");
        return t11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            Object obj = this.f19839c.get();
            Objects.requireNonNull(obj, "The supplier returned a null value");
            deferredScalarSubscription.complete(obj);
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
