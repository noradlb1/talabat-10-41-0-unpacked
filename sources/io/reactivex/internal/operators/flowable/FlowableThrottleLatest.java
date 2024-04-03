package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableThrottleLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15991d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f15992e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f15993f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f15994g;

    public static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15995b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15996c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f15997d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f15998e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f15999f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<T> f16000g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicLong f16001h = new AtomicLong();

        /* renamed from: i  reason: collision with root package name */
        public Subscription f16002i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f16003j;

        /* renamed from: k  reason: collision with root package name */
        public Throwable f16004k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f16005l;

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f16006m;

        /* renamed from: n  reason: collision with root package name */
        public long f16007n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f16008o;

        public ThrottleLatestSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker, boolean z11) {
            this.f15995b = subscriber;
            this.f15996c = j11;
            this.f15997d = timeUnit;
            this.f15998e = worker;
            this.f15999f = z11;
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.f16000g;
                AtomicLong atomicLong = this.f16001h;
                Subscriber<? super T> subscriber = this.f15995b;
                int i11 = 1;
                while (!this.f16005l) {
                    boolean z12 = this.f16003j;
                    if (!z12 || this.f16004k == null) {
                        if (atomicReference.get() == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12) {
                            if (z11 || !this.f15999f) {
                                atomicReference.lazySet((Object) null);
                                subscriber.onComplete();
                            } else {
                                T andSet = atomicReference.getAndSet((Object) null);
                                long j11 = this.f16007n;
                                if (j11 != atomicLong.get()) {
                                    this.f16007n = j11 + 1;
                                    subscriber.onNext(andSet);
                                    subscriber.onComplete();
                                } else {
                                    subscriber.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                                }
                            }
                            this.f15998e.dispose();
                            return;
                        }
                        if (z11) {
                            if (this.f16006m) {
                                this.f16008o = false;
                                this.f16006m = false;
                            }
                        } else if (!this.f16008o || this.f16006m) {
                            T andSet2 = atomicReference.getAndSet((Object) null);
                            long j12 = this.f16007n;
                            if (j12 != atomicLong.get()) {
                                subscriber.onNext(andSet2);
                                this.f16007n = j12 + 1;
                                this.f16006m = false;
                                this.f16008o = true;
                                this.f15998e.schedule(this, this.f15996c, this.f15997d);
                            } else {
                                this.f16002i.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                                this.f15998e.dispose();
                                return;
                            }
                        }
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        subscriber.onError(this.f16004k);
                        this.f15998e.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public void cancel() {
            this.f16005l = true;
            this.f16002i.cancel();
            this.f15998e.dispose();
            if (getAndIncrement() == 0) {
                this.f16000g.lazySet((Object) null);
            }
        }

        public void onComplete() {
            this.f16003j = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f16004k = th2;
            this.f16003j = true;
            a();
        }

        public void onNext(T t11) {
            this.f16000g.set(t11);
            a();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16002i, subscription)) {
                this.f16002i = subscription;
                this.f15995b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f16001h, j11);
            }
        }

        public void run() {
            this.f16006m = true;
            a();
        }
    }

    public FlowableThrottleLatest(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(flowable);
        this.f15991d = j11;
        this.f15992e = timeUnit;
        this.f15993f = scheduler;
        this.f15994g = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new ThrottleLatestSubscriber(subscriber, this.f15991d, this.f15992e, this.f15993f.createWorker(), this.f15994g));
    }
}
