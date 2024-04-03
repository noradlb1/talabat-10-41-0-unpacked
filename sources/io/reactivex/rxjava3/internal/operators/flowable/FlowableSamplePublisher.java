package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSamplePublisher<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f20273c;

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<?> f20274d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f20275e;

    public static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicInteger f20276g = new AtomicInteger();

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f20277h;

        public SampleMainEmitLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        public void a() {
            this.f20277h = true;
            if (this.f20276g.getAndIncrement() == 0) {
                b();
                this.f20278b.onComplete();
            }
        }

        public void c() {
            if (this.f20276g.getAndIncrement() == 0) {
                do {
                    boolean z11 = this.f20277h;
                    b();
                    if (z11) {
                        this.f20278b.onComplete();
                        return;
                    }
                } while (this.f20276g.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        public void a() {
            this.f20278b.onComplete();
        }

        public void c() {
            b();
        }
    }

    public static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20278b;

        /* renamed from: c  reason: collision with root package name */
        public final Publisher<?> f20279c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicLong f20280d = new AtomicLong();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Subscription> f20281e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public Subscription f20282f;

        public SamplePublisherSubscriber(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            this.f20278b = subscriber;
            this.f20279c = publisher;
        }

        public abstract void a();

        public void b() {
            Object andSet = getAndSet((Object) null);
            if (andSet == null) {
                return;
            }
            if (this.f20280d.get() != 0) {
                this.f20278b.onNext(andSet);
                BackpressureHelper.produced(this.f20280d, 1);
                return;
            }
            cancel();
            this.f20278b.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }

        public abstract void c();

        public void cancel() {
            SubscriptionHelper.cancel(this.f20281e);
            this.f20282f.cancel();
        }

        public void complete() {
            this.f20282f.cancel();
            a();
        }

        public void d(Subscription subscription) {
            SubscriptionHelper.setOnce(this.f20281e, subscription, Long.MAX_VALUE);
        }

        public void error(Throwable th2) {
            this.f20282f.cancel();
            this.f20278b.onError(th2);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f20281e);
            a();
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f20281e);
            this.f20278b.onError(th2);
        }

        public void onNext(T t11) {
            lazySet(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20282f, subscription)) {
                this.f20282f = subscription;
                this.f20278b.onSubscribe(this);
                if (this.f20281e.get() == null) {
                    this.f20279c.subscribe(new SamplerSubscriber(this));
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20280d, j11);
            }
        }
    }

    public static final class SamplerSubscriber<T> implements FlowableSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final SamplePublisherSubscriber<T> f20283b;

        public SamplerSubscriber(SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.f20283b = samplePublisherSubscriber;
        }

        public void onComplete() {
            this.f20283b.complete();
        }

        public void onError(Throwable th2) {
            this.f20283b.error(th2);
        }

        public void onNext(Object obj) {
            this.f20283b.c();
        }

        public void onSubscribe(Subscription subscription) {
            this.f20283b.d(subscription);
        }
    }

    public FlowableSamplePublisher(Publisher<T> publisher, Publisher<?> publisher2, boolean z11) {
        this.f20273c = publisher;
        this.f20274d = publisher2;
        this.f20275e = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f20275e) {
            this.f20273c.subscribe(new SampleMainEmitLast(serializedSubscriber, this.f20274d));
        } else {
            this.f20273c.subscribe(new SampleMainNoLast(serializedSubscriber, this.f20274d));
        }
    }
}
