package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFromPublisher<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T> f15322c;

    public FlowableFromPublisher(Publisher<? extends T> publisher) {
        this.f15322c = publisher;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f15322c.subscribe(subscriber);
    }
}
