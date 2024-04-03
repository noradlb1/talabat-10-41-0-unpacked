package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public Subscriber<? super T> f19628b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f19629c;

        public DetachSubscriber(Subscriber<? super T> subscriber) {
            this.f19628b = subscriber;
        }

        public void cancel() {
            Subscription subscription = this.f19629c;
            this.f19629c = EmptyComponent.INSTANCE;
            this.f19628b = EmptyComponent.asSubscriber();
            subscription.cancel();
        }

        public void onComplete() {
            Subscriber<? super T> subscriber = this.f19628b;
            this.f19629c = EmptyComponent.INSTANCE;
            this.f19628b = EmptyComponent.asSubscriber();
            subscriber.onComplete();
        }

        public void onError(Throwable th2) {
            Subscriber<? super T> subscriber = this.f19628b;
            this.f19629c = EmptyComponent.INSTANCE;
            this.f19628b = EmptyComponent.asSubscriber();
            subscriber.onError(th2);
        }

        public void onNext(T t11) {
            this.f19628b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19629c, subscription)) {
                this.f19629c = subscription;
                this.f19628b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f19629c.request(j11);
        }
    }

    public FlowableDetach(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new DetachSubscriber(subscriber));
    }
}
