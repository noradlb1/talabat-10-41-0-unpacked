package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCount<T> extends AbstractFlowableWithUpstream<T, Long> {

    public static final class CountSubscriber extends DeferredScalarSubscription<Long> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 4973004223787171406L;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f19550d;

        /* renamed from: e  reason: collision with root package name */
        public long f19551e;

        public CountSubscriber(Subscriber<? super Long> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.f19550d.cancel();
        }

        public void onComplete() {
            complete(Long.valueOf(this.f19551e));
        }

        public void onError(Throwable th2) {
            this.f23170b.onError(th2);
        }

        public void onNext(Object obj) {
            this.f19551e++;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19550d, subscription)) {
                this.f19550d = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCount(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        this.f19260c.subscribe(new CountSubscriber(subscriber));
    }
}
