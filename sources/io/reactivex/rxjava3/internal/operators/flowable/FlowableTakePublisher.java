package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableTakePublisher<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f20469c;

    /* renamed from: d  reason: collision with root package name */
    public final long f20470d;

    public FlowableTakePublisher(Publisher<T> publisher, long j11) {
        this.f20469c = publisher;
        this.f20470d = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f20469c.subscribe(new FlowableTake.TakeSubscriber(subscriber, this.f20470d));
    }
}
