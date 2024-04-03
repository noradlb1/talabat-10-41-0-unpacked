package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastOne<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5467847744262967226L;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15942d;

        public TakeLastOneSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.f15942d.cancel();
        }

        public void onComplete() {
            T t11 = this.f18610c;
            if (t11 != null) {
                complete(t11);
            } else {
                this.f18609b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f18610c = null;
            this.f18609b.onError(th2);
        }

        public void onNext(T t11) {
            this.f18610c = t11;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15942d, subscription)) {
                this.f15942d = subscription;
                this.f18609b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableTakeLastOne(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new TakeLastOneSubscriber(subscriber));
    }
}
