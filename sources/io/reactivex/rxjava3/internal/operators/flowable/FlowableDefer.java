package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableDefer<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<? extends Publisher<? extends T>> f19600c;

    public FlowableDefer(Supplier<? extends Publisher<? extends T>> supplier) {
        this.f19600c = supplier;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Object obj = this.f19600c.get();
            Objects.requireNonNull(obj, "The publisher supplied is null");
            ((Publisher) obj).subscribe(subscriber);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
