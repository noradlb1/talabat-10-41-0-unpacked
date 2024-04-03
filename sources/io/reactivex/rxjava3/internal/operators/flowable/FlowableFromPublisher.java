package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFromPublisher<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T> f19837c;

    public FlowableFromPublisher(Publisher<? extends T> publisher) {
        this.f19837c = publisher;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19837c.subscribe(subscriber);
    }
}
