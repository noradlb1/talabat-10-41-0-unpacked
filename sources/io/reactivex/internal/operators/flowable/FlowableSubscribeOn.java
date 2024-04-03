package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f15892d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15893e;

    public static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15894b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler.Worker f15895c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Subscription> f15896d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f15897e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final boolean f15898f;

        /* renamed from: g  reason: collision with root package name */
        public Publisher<T> f15899g;

        public static final class Request implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final Subscription f15900b;

            /* renamed from: c  reason: collision with root package name */
            public final long f15901c;

            public Request(Subscription subscription, long j11) {
                this.f15900b = subscription;
                this.f15901c = j11;
            }

            public void run() {
                this.f15900b.request(this.f15901c);
            }
        }

        public SubscribeOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, Publisher<T> publisher, boolean z11) {
            this.f15894b = subscriber;
            this.f15895c = worker;
            this.f15899g = publisher;
            this.f15898f = !z11;
        }

        public void a(long j11, Subscription subscription) {
            if (this.f15898f || Thread.currentThread() == get()) {
                subscription.request(j11);
            } else {
                this.f15895c.schedule(new Request(subscription, j11));
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f15896d);
            this.f15895c.dispose();
        }

        public void onComplete() {
            this.f15894b.onComplete();
            this.f15895c.dispose();
        }

        public void onError(Throwable th2) {
            this.f15894b.onError(th2);
            this.f15895c.dispose();
        }

        public void onNext(T t11) {
            this.f15894b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f15896d, subscription)) {
                long andSet = this.f15897e.getAndSet(0);
                if (andSet != 0) {
                    a(andSet, subscription);
                }
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                Subscription subscription = this.f15896d.get();
                if (subscription != null) {
                    a(j11, subscription);
                    return;
                }
                BackpressureHelper.add(this.f15897e, j11);
                Subscription subscription2 = this.f15896d.get();
                if (subscription2 != null) {
                    long andSet = this.f15897e.getAndSet(0);
                    if (andSet != 0) {
                        a(andSet, subscription2);
                    }
                }
            }
        }

        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.f15899g;
            this.f15899g = null;
            publisher.subscribe(this);
        }
    }

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean z11) {
        super(flowable);
        this.f15892d = scheduler;
        this.f15893e = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.f15892d.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, createWorker, this.f14763c, this.f15893e);
        subscriber.onSubscribe(subscribeOnSubscriber);
        createWorker.schedule(subscribeOnSubscriber);
    }
}
