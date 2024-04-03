package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends U> f20471d;

    public static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4945480365982832967L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20472b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicLong f20473c = new AtomicLong();

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Subscription> f20474d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f20475e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final TakeUntilMainSubscriber<T>.OtherSubscriber f20476f = new OtherSubscriber();

        public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            public OtherSubscriber() {
            }

            public void onComplete() {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.f20474d);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                HalfSerializer.onComplete((Subscriber<?>) takeUntilMainSubscriber.f20472b, (AtomicInteger) takeUntilMainSubscriber, takeUntilMainSubscriber.f20475e);
            }

            public void onError(Throwable th2) {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.f20474d);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                HalfSerializer.onError((Subscriber<?>) takeUntilMainSubscriber.f20472b, th2, (AtomicInteger) takeUntilMainSubscriber, takeUntilMainSubscriber.f20475e);
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
            this.f20472b = subscriber;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f20474d);
            SubscriptionHelper.cancel(this.f20476f);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f20476f);
            HalfSerializer.onComplete((Subscriber<?>) this.f20472b, (AtomicInteger) this, this.f20475e);
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f20476f);
            HalfSerializer.onError((Subscriber<?>) this.f20472b, th2, (AtomicInteger) this, this.f20475e);
        }

        public void onNext(T t11) {
            HalfSerializer.onNext(this.f20472b, t11, (AtomicInteger) this, this.f20475e);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f20474d, this.f20473c, subscription);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f20474d, this.f20473c, j11);
        }
    }

    public FlowableTakeUntil(Flowable<T> flowable, Publisher<? extends U> publisher) {
        super(flowable);
        this.f20471d = publisher;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(subscriber);
        subscriber.onSubscribe(takeUntilMainSubscriber);
        this.f20471d.subscribe(takeUntilMainSubscriber.f20476f);
        this.f19260c.subscribe(takeUntilMainSubscriber);
    }
}
