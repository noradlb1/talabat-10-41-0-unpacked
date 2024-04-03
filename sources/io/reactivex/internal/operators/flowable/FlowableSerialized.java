package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableSerialized<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableSerialized(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new SerializedSubscriber(subscriber));
    }
}
