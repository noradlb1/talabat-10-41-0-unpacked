package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMap;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableMapPublisher<T, U> extends Flowable<U> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f19996c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends U> f19997d;

    public FlowableMapPublisher(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.f19996c = publisher;
        this.f19997d = function;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f19996c.subscribe(new FlowableMap.MapSubscriber(subscriber, this.f19997d));
    }
}
