package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableHide<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class HideSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19912b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f19913c;

        public HideSubscriber(Subscriber<? super T> subscriber) {
            this.f19912b = subscriber;
        }

        public void cancel() {
            this.f19913c.cancel();
        }

        public void onComplete() {
            this.f19912b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19912b.onError(th2);
        }

        public void onNext(T t11) {
            this.f19912b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19913c, subscription)) {
                this.f19913c = subscription;
                this.f19912b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f19913c.request(j11);
        }
    }

    public FlowableHide(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new HideSubscriber(subscriber));
    }
}
