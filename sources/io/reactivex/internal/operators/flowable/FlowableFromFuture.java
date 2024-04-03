package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableFromFuture<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Future<? extends T> f15311c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15312d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f15313e;

    public FlowableFromFuture(Future<? extends T> future, long j11, TimeUnit timeUnit) {
        this.f15311c = future;
        this.f15312d = j11;
        this.f15313e = timeUnit;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Object obj;
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            TimeUnit timeUnit = this.f15313e;
            if (timeUnit != null) {
                obj = this.f15311c.get(this.f15312d, timeUnit);
            } else {
                obj = this.f15311c.get();
            }
            if (obj == null) {
                subscriber.onError(new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.complete(obj);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            if (!deferredScalarSubscription.isCancelled()) {
                subscriber.onError(th2);
            }
        }
    }
}
