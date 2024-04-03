package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<? extends T> f19616c;

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<U> f19617d;

    public static final class MainSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2259811067697317255L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19618b;

        /* renamed from: c  reason: collision with root package name */
        public final Publisher<? extends T> f19619c;

        /* renamed from: d  reason: collision with root package name */
        public final MainSubscriber<T>.OtherSubscriber f19620d = new OtherSubscriber();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Subscription> f19621e = new AtomicReference<>();

        public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3892798459447644106L;

            public OtherSubscriber() {
            }

            public void onComplete() {
                if (((Subscription) get()) != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.a();
                }
            }

            public void onError(Throwable th2) {
                if (((Subscription) get()) != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.f19618b.onError(th2);
                } else {
                    RxJavaPlugins.onError(th2);
                }
            }

            public void onNext(Object obj) {
                Subscription subscription = (Subscription) get();
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper) {
                    lazySet(subscriptionHelper);
                    subscription.cancel();
                    MainSubscriber.this.a();
                }
            }

            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public MainSubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.f19618b = subscriber;
            this.f19619c = publisher;
        }

        public void a() {
            this.f19619c.subscribe(this);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f19620d);
            SubscriptionHelper.cancel(this.f19621e);
        }

        public void onComplete() {
            this.f19618b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19618b.onError(th2);
        }

        public void onNext(T t11) {
            this.f19618b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f19621e, this, subscription);
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                SubscriptionHelper.deferredRequest(this.f19621e, this, j11);
            }
        }
    }

    public FlowableDelaySubscriptionOther(Publisher<? extends T> publisher, Publisher<U> publisher2) {
        this.f19616c = publisher;
        this.f19617d = publisher2;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        MainSubscriber mainSubscriber = new MainSubscriber(subscriber, this.f19616c);
        subscriber.onSubscribe(mainSubscriber);
        this.f19617d.subscribe(mainSubscriber.f19620d);
    }
}
