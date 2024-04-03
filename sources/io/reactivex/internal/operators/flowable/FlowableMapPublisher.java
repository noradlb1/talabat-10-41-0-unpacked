package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableMap;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableMapPublisher<T, U> extends Flowable<U> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f15473c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends U> f15474d;

    public FlowableMapPublisher(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.f15473c = publisher;
        this.f15474d = function;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f15473c.subscribe(new FlowableMap.MapSubscriber(subscriber, this.f15474d));
    }
}
