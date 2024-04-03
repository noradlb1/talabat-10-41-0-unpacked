package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<U> f20389d;

    public static final class SkipUntilMainSubscriber<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6270983465606289181L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20390b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f20391c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f20392d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public final SkipUntilMainSubscriber<T>.OtherSubscriber f20393e = new OtherSubscriber();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f20394f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f20395g;

        public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            public OtherSubscriber() {
            }

            public void onComplete() {
                SkipUntilMainSubscriber.this.f20395g = true;
            }

            public void onError(Throwable th2) {
                SubscriptionHelper.cancel(SkipUntilMainSubscriber.this.f20391c);
                SkipUntilMainSubscriber skipUntilMainSubscriber = SkipUntilMainSubscriber.this;
                HalfSerializer.onError((Subscriber<?>) skipUntilMainSubscriber.f20390b, th2, (AtomicInteger) skipUntilMainSubscriber, skipUntilMainSubscriber.f20394f);
            }

            public void onNext(Object obj) {
                SkipUntilMainSubscriber.this.f20395g = true;
                ((Subscription) get()).cancel();
            }

            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public SkipUntilMainSubscriber(Subscriber<? super T> subscriber) {
            this.f20390b = subscriber;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f20391c);
            SubscriptionHelper.cancel(this.f20393e);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f20393e);
            HalfSerializer.onComplete((Subscriber<?>) this.f20390b, (AtomicInteger) this, this.f20394f);
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f20393e);
            HalfSerializer.onError((Subscriber<?>) this.f20390b, th2, (AtomicInteger) this, this.f20394f);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f20391c.get().request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f20391c, this.f20392d, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f20391c, this.f20392d, j11);
        }

        public boolean tryOnNext(T t11) {
            if (!this.f20395g) {
                return false;
            }
            HalfSerializer.onNext(this.f20390b, t11, (AtomicInteger) this, this.f20394f);
            return true;
        }
    }

    public FlowableSkipUntil(Flowable<T> flowable, Publisher<U> publisher) {
        super(flowable);
        this.f20389d = publisher;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SkipUntilMainSubscriber skipUntilMainSubscriber = new SkipUntilMainSubscriber(subscriber);
        subscriber.onSubscribe(skipUntilMainSubscriber);
        this.f20389d.subscribe(skipUntilMainSubscriber.f20393e);
        this.f19260c.subscribe(skipUntilMainSubscriber);
    }
}
