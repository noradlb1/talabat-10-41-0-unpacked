package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20451d;

    /* renamed from: e  reason: collision with root package name */
    public final long f20452e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f20453f;

    /* renamed from: g  reason: collision with root package name */
    public final Scheduler f20454g;

    /* renamed from: h  reason: collision with root package name */
    public final int f20455h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f20456i;

    public static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20457b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20458c;

        /* renamed from: d  reason: collision with root package name */
        public final long f20459d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f20460e;

        /* renamed from: f  reason: collision with root package name */
        public final Scheduler f20461f;

        /* renamed from: g  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f20462g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f20463h;

        /* renamed from: i  reason: collision with root package name */
        public Subscription f20464i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicLong f20465j = new AtomicLong();

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f20466k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f20467l;

        /* renamed from: m  reason: collision with root package name */
        public Throwable f20468m;

        public TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
            this.f20457b = subscriber;
            this.f20458c = j11;
            this.f20459d = j12;
            this.f20460e = timeUnit;
            this.f20461f = scheduler;
            this.f20462g = new SpscLinkedArrayQueue<>(i11);
            this.f20463h = z11;
        }

        public boolean a(boolean z11, Subscriber<? super T> subscriber, boolean z12) {
            if (this.f20466k) {
                this.f20462g.clear();
                return true;
            } else if (!z12) {
                Throwable th2 = this.f20468m;
                if (th2 != null) {
                    this.f20462g.clear();
                    subscriber.onError(th2);
                    return true;
                } else if (!z11) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            } else if (!z11) {
                return false;
            } else {
                Throwable th3 = this.f20468m;
                if (th3 != null) {
                    subscriber.onError(th3);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f20457b;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f20462g;
                boolean z12 = this.f20463h;
                int i11 = 1;
                do {
                    if (this.f20467l) {
                        if (!a(spscLinkedArrayQueue.isEmpty(), subscriber, z12)) {
                            long j11 = this.f20465j.get();
                            long j12 = 0;
                            while (true) {
                                if (spscLinkedArrayQueue.peek() == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (!a(z11, subscriber, z12)) {
                                    if (j11 != j12) {
                                        spscLinkedArrayQueue.poll();
                                        subscriber.onNext(spscLinkedArrayQueue.poll());
                                        j12++;
                                    } else if (j12 != 0) {
                                        BackpressureHelper.produced(this.f20465j, j12);
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    i11 = addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void c(long j11, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue) {
            boolean z11;
            long j12 = this.f20459d;
            long j13 = this.f20458c;
            if (j13 == Long.MAX_VALUE) {
                z11 = true;
            } else {
                z11 = false;
            }
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() < j11 - j12 || (!z11 && ((long) (spscLinkedArrayQueue.size() >> 1)) > j13)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }

        public void cancel() {
            if (!this.f20466k) {
                this.f20466k = true;
                this.f20464i.cancel();
                if (getAndIncrement() == 0) {
                    this.f20462g.clear();
                }
            }
        }

        public void onComplete() {
            c(this.f20461f.now(this.f20460e), this.f20462g);
            this.f20467l = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f20463h) {
                c(this.f20461f.now(this.f20460e), this.f20462g);
            }
            this.f20468m = th2;
            this.f20467l = true;
            b();
        }

        public void onNext(T t11) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f20462g;
            long now = this.f20461f.now(this.f20460e);
            spscLinkedArrayQueue.offer(Long.valueOf(now), t11);
            c(now, spscLinkedArrayQueue);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20464i, subscription)) {
                this.f20464i = subscription;
                this.f20457b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20465j, j11);
                b();
            }
        }
    }

    public FlowableTakeLastTimed(Flowable<T> flowable, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
        super(flowable);
        this.f20451d = j11;
        this.f20452e = j12;
        this.f20453f = timeUnit;
        this.f20454g = scheduler;
        this.f20455h = i11;
        this.f20456i = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new TakeLastTimedSubscriber(subscriber, this.f20451d, this.f20452e, this.f20453f, this.f20454g, this.f20455h, this.f20456i));
    }
}
