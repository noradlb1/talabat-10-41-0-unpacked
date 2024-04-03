package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<U> f15879d;

    public static final class SkipUntilMainSubscriber<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6270983465606289181L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15880b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Subscription> f15881c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f15882d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public final SkipUntilMainSubscriber<T>.OtherSubscriber f15883e = new OtherSubscriber();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicThrowable f15884f = new AtomicThrowable();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f15885g;

        public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            public OtherSubscriber() {
            }

            public void onComplete() {
                SkipUntilMainSubscriber.this.f15885g = true;
            }

            public void onError(Throwable th2) {
                SubscriptionHelper.cancel(SkipUntilMainSubscriber.this.f15881c);
                SkipUntilMainSubscriber skipUntilMainSubscriber = SkipUntilMainSubscriber.this;
                HalfSerializer.onError((Subscriber<?>) skipUntilMainSubscriber.f15880b, th2, (AtomicInteger) skipUntilMainSubscriber, skipUntilMainSubscriber.f15884f);
            }

            public void onNext(Object obj) {
                SkipUntilMainSubscriber.this.f15885g = true;
                ((Subscription) get()).cancel();
            }

            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public SkipUntilMainSubscriber(Subscriber<? super T> subscriber) {
            this.f15880b = subscriber;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f15881c);
            SubscriptionHelper.cancel(this.f15883e);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f15883e);
            HalfSerializer.onComplete((Subscriber<?>) this.f15880b, (AtomicInteger) this, this.f15884f);
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f15883e);
            HalfSerializer.onError((Subscriber<?>) this.f15880b, th2, (AtomicInteger) this, this.f15884f);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f15881c.get().request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f15881c, this.f15882d, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f15881c, this.f15882d, j11);
        }

        public boolean tryOnNext(T t11) {
            if (!this.f15885g) {
                return false;
            }
            HalfSerializer.onNext(this.f15880b, t11, (AtomicInteger) this, this.f15884f);
            return true;
        }
    }

    public FlowableSkipUntil(Flowable<T> flowable, Publisher<U> publisher) {
        super(flowable);
        this.f15879d = publisher;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SkipUntilMainSubscriber skipUntilMainSubscriber = new SkipUntilMainSubscriber(subscriber);
        subscriber.onSubscribe(skipUntilMainSubscriber);
        this.f15879d.subscribe(skipUntilMainSubscriber.f15883e);
        this.f14763c.subscribe(skipUntilMainSubscriber);
    }
}
