package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends T> f20412d;

    public static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20413b;

        /* renamed from: c  reason: collision with root package name */
        public final Publisher<? extends T> f20414c;

        /* renamed from: d  reason: collision with root package name */
        public final SubscriptionArbiter f20415d = new SubscriptionArbiter(false);

        /* renamed from: e  reason: collision with root package name */
        public boolean f20416e = true;

        public SwitchIfEmptySubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.f20413b = subscriber;
            this.f20414c = publisher;
        }

        public void onComplete() {
            if (this.f20416e) {
                this.f20416e = false;
                this.f20414c.subscribe(this);
                return;
            }
            this.f20413b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20413b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f20416e) {
                this.f20416e = false;
            }
            this.f20413b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f20415d.setSubscription(subscription);
        }
    }

    public FlowableSwitchIfEmpty(Flowable<T> flowable, Publisher<? extends T> publisher) {
        super(flowable);
        this.f20412d = publisher;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SwitchIfEmptySubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(subscriber, this.f20412d);
        subscriber.onSubscribe(switchIfEmptySubscriber.f20415d);
        this.f19260c.subscribe(switchIfEmptySubscriber);
    }
}
