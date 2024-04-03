package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f20402d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f20403e;

    public static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20404b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler.Worker f20405c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Subscription> f20406d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f20407e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final boolean f20408f;

        /* renamed from: g  reason: collision with root package name */
        public Publisher<T> f20409g;

        public static final class Request implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final Subscription f20410b;

            /* renamed from: c  reason: collision with root package name */
            public final long f20411c;

            public Request(Subscription subscription, long j11) {
                this.f20410b = subscription;
                this.f20411c = j11;
            }

            public void run() {
                this.f20410b.request(this.f20411c);
            }
        }

        public SubscribeOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, Publisher<T> publisher, boolean z11) {
            this.f20404b = subscriber;
            this.f20405c = worker;
            this.f20409g = publisher;
            this.f20408f = !z11;
        }

        public void a(long j11, Subscription subscription) {
            if (this.f20408f || Thread.currentThread() == get()) {
                subscription.request(j11);
            } else {
                this.f20405c.schedule(new Request(subscription, j11));
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f20406d);
            this.f20405c.dispose();
        }

        public void onComplete() {
            this.f20404b.onComplete();
            this.f20405c.dispose();
        }

        public void onError(Throwable th2) {
            this.f20404b.onError(th2);
            this.f20405c.dispose();
        }

        public void onNext(T t11) {
            this.f20404b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f20406d, subscription)) {
                long andSet = this.f20407e.getAndSet(0);
                if (andSet != 0) {
                    a(andSet, subscription);
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                Subscription subscription = this.f20406d.get();
                if (subscription != null) {
                    a(j11, subscription);
                    return;
                }
                BackpressureHelper.add(this.f20407e, j11);
                Subscription subscription2 = this.f20406d.get();
                if (subscription2 != null) {
                    long andSet = this.f20407e.getAndSet(0);
                    if (andSet != 0) {
                        a(andSet, subscription2);
                    }
                }
            }
        }

        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.f20409g;
            this.f20409g = null;
            publisher.subscribe(this);
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z11) {
        super(flowable);
        this.f20402d = scheduler;
        this.f20403e = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.f20402d.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, createWorker, this.f19260c, this.f20403e);
        subscriber.onSubscribe(subscribeOnSubscriber);
        createWorker.schedule(subscribeOnSubscriber);
    }
}
