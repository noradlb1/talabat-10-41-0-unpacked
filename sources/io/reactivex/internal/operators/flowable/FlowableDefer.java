package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableDefer<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends Publisher<? extends T>> f15094c;

    public FlowableDefer(Callable<? extends Publisher<? extends T>> callable) {
        this.f15094c = callable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.f15094c.call(), "The publisher supplied is null")).subscribe(subscriber);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
