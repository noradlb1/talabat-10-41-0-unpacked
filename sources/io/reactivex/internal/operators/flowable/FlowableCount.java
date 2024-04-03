package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCount<T> extends AbstractFlowableWithUpstream<T, Long> {

    public static final class CountSubscriber extends DeferredScalarSubscription<Long> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 4973004223787171406L;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15044d;

        /* renamed from: e  reason: collision with root package name */
        public long f15045e;

        public CountSubscriber(Subscriber<? super Long> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.f15044d.cancel();
        }

        public void onComplete() {
            complete(Long.valueOf(this.f15045e));
        }

        public void onError(Throwable th2) {
            this.f18609b.onError(th2);
        }

        public void onNext(Object obj) {
            this.f15045e++;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15044d, subscription)) {
                this.f15044d = subscription;
                this.f18609b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCount(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        this.f14763c.subscribe(new CountSubscriber(subscriber));
    }
}
