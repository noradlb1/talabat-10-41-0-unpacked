package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {

    /* renamed from: b  reason: collision with root package name */
    public Subscription f23669b;

    public void a() {
        b(Long.MAX_VALUE);
    }

    public final void b(long j11) {
        Subscription subscription = this.f23669b;
        if (subscription != null) {
            subscription.request(j11);
        }
    }

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.validate(this.f23669b, subscription, getClass())) {
            this.f23669b = subscription;
            a();
        }
    }
}
