package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {

    /* renamed from: b  reason: collision with root package name */
    public Subscription f23474b;

    public void a() {
        b(Long.MAX_VALUE);
    }

    public final void b(long j11) {
        Subscription subscription = this.f23474b;
        if (subscription != null) {
            subscription.request(j11);
        }
    }

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.validate(this.f23474b, subscription, getClass())) {
            this.f23474b = subscription;
            a();
        }
    }
}
