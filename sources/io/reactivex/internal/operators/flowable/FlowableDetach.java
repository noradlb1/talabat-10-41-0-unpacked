package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public Subscriber<? super T> f15122b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f15123c;

        public DetachSubscriber(Subscriber<? super T> subscriber) {
            this.f15122b = subscriber;
        }

        public void cancel() {
            Subscription subscription = this.f15123c;
            this.f15123c = EmptyComponent.INSTANCE;
            this.f15122b = EmptyComponent.asSubscriber();
            subscription.cancel();
        }

        public void onComplete() {
            Subscriber<? super T> subscriber = this.f15122b;
            this.f15123c = EmptyComponent.INSTANCE;
            this.f15122b = EmptyComponent.asSubscriber();
            subscriber.onComplete();
        }

        public void onError(Throwable th2) {
            Subscriber<? super T> subscriber = this.f15122b;
            this.f15123c = EmptyComponent.INSTANCE;
            this.f15122b = EmptyComponent.asSubscriber();
            subscriber.onError(th2);
        }

        public void onNext(T t11) {
            this.f15122b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15123c, subscription)) {
                this.f15123c = subscription;
                this.f15122b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15123c.request(j11);
        }
    }

    public FlowableDetach(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new DetachSubscriber(subscriber));
    }
}
