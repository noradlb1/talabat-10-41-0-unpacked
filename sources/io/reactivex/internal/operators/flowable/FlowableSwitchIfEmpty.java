package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends T> f15902d;

    public static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15903b;

        /* renamed from: c  reason: collision with root package name */
        public final Publisher<? extends T> f15904c;

        /* renamed from: d  reason: collision with root package name */
        public final SubscriptionArbiter f15905d = new SubscriptionArbiter(false);

        /* renamed from: e  reason: collision with root package name */
        public boolean f15906e = true;

        public SwitchIfEmptySubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.f15903b = subscriber;
            this.f15904c = publisher;
        }

        public void onComplete() {
            if (this.f15906e) {
                this.f15906e = false;
                this.f15904c.subscribe(this);
                return;
            }
            this.f15903b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15903b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f15906e) {
                this.f15906e = false;
            }
            this.f15903b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f15905d.setSubscription(subscription);
        }
    }

    public FlowableSwitchIfEmpty(Flowable<T> flowable, Publisher<? extends T> publisher) {
        super(flowable);
        this.f15902d = publisher;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SwitchIfEmptySubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(subscriber, this.f15902d);
        subscriber.onSubscribe(switchIfEmptySubscriber.f15905d);
        this.f14763c.subscribe(switchIfEmptySubscriber);
    }
}
