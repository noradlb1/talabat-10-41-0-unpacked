package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableTakePublisher<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f15961c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15962d;

    public FlowableTakePublisher(Publisher<T> publisher, long j11) {
        this.f15961c = publisher;
        this.f15962d = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f15961c.subscribe(new FlowableTake.TakeSubscriber(subscriber, this.f15962d));
    }
}
