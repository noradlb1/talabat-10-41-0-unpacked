package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableHide<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class HideSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15396b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f15397c;

        public HideSubscriber(Subscriber<? super T> subscriber) {
            this.f15396b = subscriber;
        }

        public void cancel() {
            this.f15397c.cancel();
        }

        public void onComplete() {
            this.f15396b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15396b.onError(th2);
        }

        public void onNext(T t11) {
            this.f15396b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15397c, subscription)) {
                this.f15397c = subscription;
                this.f15396b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15397c.request(j11);
        }
    }

    public FlowableHide(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new HideSubscriber(subscriber));
    }
}
