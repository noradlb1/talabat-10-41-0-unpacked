package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableThrottleLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20499d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f20500e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f20501f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f20502g;

    public static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20503b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20504c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f20505d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f20506e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f20507f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<T> f20508g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicLong f20509h = new AtomicLong();

        /* renamed from: i  reason: collision with root package name */
        public Subscription f20510i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f20511j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f20512k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f20513l;

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f20514m;

        /* renamed from: n  reason: collision with root package name */
        public long f20515n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f20516o;

        public ThrottleLatestSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker, boolean z11) {
            this.f20503b = subscriber;
            this.f20504c = j11;
            this.f20505d = timeUnit;
            this.f20506e = worker;
            this.f20507f = z11;
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.f20508g;
                AtomicLong atomicLong = this.f20509h;
                Subscriber<? super T> subscriber = this.f20503b;
                int i11 = 1;
                while (!this.f20513l) {
                    boolean z12 = this.f20511j;
                    if (!z12 || this.f20512k == null) {
                        if (atomicReference.get() == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12) {
                            if (z11 || !this.f20507f) {
                                atomicReference.lazySet((Object) null);
                                subscriber.onComplete();
                            } else {
                                T andSet = atomicReference.getAndSet((Object) null);
                                long j11 = this.f20515n;
                                if (j11 != atomicLong.get()) {
                                    this.f20515n = j11 + 1;
                                    subscriber.onNext(andSet);
                                    subscriber.onComplete();
                                } else {
                                    subscriber.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                                }
                            }
                            this.f20506e.dispose();
                            return;
                        }
                        if (z11) {
                            if (this.f20514m) {
                                this.f20516o = false;
                                this.f20514m = false;
                            }
                        } else if (!this.f20516o || this.f20514m) {
                            T andSet2 = atomicReference.getAndSet((Object) null);
                            long j12 = this.f20515n;
                            if (j12 != atomicLong.get()) {
                                subscriber.onNext(andSet2);
                                this.f20515n = j12 + 1;
                                this.f20514m = false;
                                this.f20516o = true;
                                this.f20506e.schedule(this, this.f20504c, this.f20505d);
                            } else {
                                this.f20510i.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                                this.f20506e.dispose();
                                return;
                            }
                        }
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        subscriber.onError(this.f20512k);
                        this.f20506e.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public void cancel() {
            this.f20513l = true;
            this.f20510i.cancel();
            this.f20506e.dispose();
            if (getAndIncrement() == 0) {
                this.f20508g.lazySet((Object) null);
            }
        }

        public void onComplete() {
            this.f20511j = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f20512k = th2;
            this.f20511j = true;
            a();
        }

        public void onNext(T t11) {
            this.f20508g.set(t11);
            a();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20510i, subscription)) {
                this.f20510i = subscription;
                this.f20503b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20509h, j11);
            }
        }

        public void run() {
            this.f20514m = true;
            a();
        }
    }

    public FlowableThrottleLatest(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(flowable);
        this.f20499d = j11;
        this.f20500e = timeUnit;
        this.f20501f = scheduler;
        this.f20502g = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new ThrottleLatestSubscriber(subscriber, this.f20499d, this.f20500e, this.f20501f.createWorker(), this.f20502g));
    }
}
