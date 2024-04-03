package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastOne<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class TakeLastOneSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5467847744262967226L;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20450d;

        public TakeLastOneSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.f20450d.cancel();
        }

        public void onComplete() {
            T t11 = this.f23171c;
            if (t11 != null) {
                complete(t11);
            } else {
                this.f23170b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f23171c = null;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            this.f23171c = t11;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20450d, subscription)) {
                this.f20450d = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableTakeLastOne(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new TakeLastOneSubscriber(subscriber));
    }
}
