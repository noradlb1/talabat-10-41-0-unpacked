package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableFromFuture<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Future<? extends T> f19826c;

    /* renamed from: d  reason: collision with root package name */
    public final long f19827d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f19828e;

    public FlowableFromFuture(Future<? extends T> future, long j11, TimeUnit timeUnit) {
        this.f19826c = future;
        this.f19827d = j11;
        this.f19828e = timeUnit;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Object obj;
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.onSubscribe(deferredScalarSubscription);
        try {
            TimeUnit timeUnit = this.f19828e;
            if (timeUnit != null) {
                obj = this.f19826c.get(this.f19827d, timeUnit);
            } else {
                obj = this.f19826c.get();
            }
            if (obj == null) {
                subscriber.onError(ExceptionHelper.createNullPointerException("The future returned a null value."));
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
