package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends U> f15963d;

    public static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4945480365982832967L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15964b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f15965c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Subscription> f15966d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f15967e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final TakeUntilMainSubscriber<T>.OtherSubscriber f15968f = new OtherSubscriber();

        public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            public OtherSubscriber() {
            }

            public void onComplete() {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.f15966d);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                HalfSerializer.onComplete((Subscriber<?>) takeUntilMainSubscriber.f15964b, (AtomicInteger) takeUntilMainSubscriber, takeUntilMainSubscriber.f15967e);
            }

            public void onError(Throwable th2) {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.f15966d);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                HalfSerializer.onError((Subscriber<?>) takeUntilMainSubscriber.f15964b, th2, (AtomicInteger) takeUntilMainSubscriber, takeUntilMainSubscriber.f15967e);
            }

            public void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                onComplete();
            }

            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public TakeUntilMainSubscriber(Subscriber<? super T> subscriber) {
            this.f15964b = subscriber;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f15966d);
            SubscriptionHelper.cancel(this.f15968f);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f15968f);
            HalfSerializer.onComplete((Subscriber<?>) this.f15964b, (AtomicInteger) this, this.f15967e);
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f15968f);
            HalfSerializer.onError((Subscriber<?>) this.f15964b, th2, (AtomicInteger) this, this.f15967e);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f15964b, t11, (AtomicInteger) this, this.f15967e);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f15966d, this.f15965c, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f15966d, this.f15965c, j11);
        }
    }

    public FlowableTakeUntil(Flowable<T> flowable, Publisher<? extends U> publisher) {
        super(flowable);
        this.f15963d = publisher;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(subscriber);
        subscriber.onSubscribe(takeUntilMainSubscriber);
        this.f15963d.subscribe(takeUntilMainSubscriber.f15968f);
        this.f14763c.subscribe(takeUntilMainSubscriber);
    }
}
