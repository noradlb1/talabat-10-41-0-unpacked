package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSamplePublisher<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f15763c;

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<?> f15764d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15765e;

    public static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f15766g = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f15767h;

        public SampleMainEmitLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        public void a() {
            this.f15767h = true;
            if (this.f15766g.getAndIncrement() == 0) {
                b();
                this.f15768b.onComplete();
            }
        }

        public void c() {
            if (this.f15766g.getAndIncrement() == 0) {
                do {
                    boolean z11 = this.f15767h;
                    b();
                    if (z11) {
                        this.f15768b.onComplete();
                        return;
                    }
                } while (this.f15766g.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        public void a() {
            this.f15768b.onComplete();
        }

        public void c() {
            b();
        }
    }

    public static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15768b;

        /* renamed from: c  reason: collision with root package name */
        public final Publisher<?> f15769c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f15770d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Subscription> f15771e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public Subscription f15772f;

        public SamplePublisherSubscriber(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            this.f15768b = subscriber;
            this.f15769c = publisher;
        }

        public abstract void a();

        public void b() {
            Object andSet = getAndSet((Object) null);
            if (andSet == null) {
                return;
            }
            if (this.f15770d.get() != 0) {
                this.f15768b.onNext(andSet);
                BackpressureHelper.produced(this.f15770d, 1);
                return;
            }
            cancel();
            this.f15768b.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }

        public abstract void c();

        public void cancel() {
            SubscriptionHelper.cancel(this.f15771e);
            this.f15772f.cancel();
        }

        public void complete() {
            this.f15772f.cancel();
            a();
        }

        public void d(Subscription subscription) {
            SubscriptionHelper.setOnce(this.f15771e, subscription, Long.MAX_VALUE);
        }

        public void error(Throwable th2) {
            this.f15772f.cancel();
            this.f15768b.onError(th2);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f15771e);
            a();
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f15771e);
            this.f15768b.onError(th2);
        }

        public void onNext(T t11) {
            lazySet(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15772f, subscription)) {
                this.f15772f = subscription;
                this.f15768b.onSubscribe(this);
                if (this.f15771e.get() == null) {
                    this.f15769c.subscribe(new SamplerSubscriber(this));
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15770d, j11);
            }
        }
    }

    public static final class SamplerSubscriber<T> implements FlowableSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final SamplePublisherSubscriber<T> f15773b;

        public SamplerSubscriber(SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.f15773b = samplePublisherSubscriber;
        }

        public void onComplete() {
            this.f15773b.complete();
        }

        public void onError(Throwable th2) {
            this.f15773b.error(th2);
        }

        public void onNext(Object obj) {
            this.f15773b.c();
        }

        public void onSubscribe(Subscription subscription) {
            this.f15773b.d(subscription);
        }
    }

    public FlowableSamplePublisher(Publisher<T> publisher, Publisher<?> publisher2, boolean z11) {
        this.f15763c = publisher;
        this.f15764d = publisher2;
        this.f15765e = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f15765e) {
            this.f15763c.subscribe(new SampleMainEmitLast(serializedSubscriber, this.f15764d));
        } else {
            this.f15763c.subscribe(new SampleMainNoLast(serializedSubscriber, this.f15764d));
        }
    }
}
