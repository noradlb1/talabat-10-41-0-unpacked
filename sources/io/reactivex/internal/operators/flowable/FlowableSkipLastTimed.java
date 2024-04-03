package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15863d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f15864e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f15865f;

    /* renamed from: g  reason: collision with root package name */
    public final int f15866g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f15867h;

    public static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15868b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15869c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f15870d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f15871e;

        /* renamed from: f  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f15872f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f15873g;

        /* renamed from: h  reason: collision with root package name */
        public Subscription f15874h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicLong f15875i = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f15876j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f15877k;

        /* renamed from: l  reason: collision with root package name */
        public Throwable f15878l;

        public SkipLastTimedSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
            this.f15868b = subscriber;
            this.f15869c = j11;
            this.f15870d = timeUnit;
            this.f15871e = scheduler;
            this.f15872f = new SpscLinkedArrayQueue<>(i11);
            this.f15873g = z11;
        }

        public boolean a(boolean z11, boolean z12, Subscriber<? super T> subscriber, boolean z13) {
            if (this.f15876j) {
                this.f15872f.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!z13) {
                    Throwable th2 = this.f15878l;
                    if (th2 != null) {
                        this.f15872f.clear();
                        subscriber.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = this.f15878l;
                    if (th3 != null) {
                        subscriber.onError(th3);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        public void b() {
            boolean z11;
            boolean z12;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f15868b;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f15872f;
                boolean z13 = this.f15873g;
                TimeUnit timeUnit = this.f15870d;
                Scheduler scheduler = this.f15871e;
                long j11 = this.f15869c;
                int i11 = 1;
                do {
                    long j12 = this.f15875i.get();
                    long j13 = 0;
                    while (j13 != j12) {
                        boolean z14 = this.f15877k;
                        Long l11 = (Long) spscLinkedArrayQueue.peek();
                        if (l11 == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        long now = scheduler.now(timeUnit);
                        if (z11 || l11.longValue() <= now - j11) {
                            z12 = z11;
                        } else {
                            z12 = true;
                        }
                        if (!a(z14, z12, subscriber, z13)) {
                            if (z12) {
                                break;
                            }
                            spscLinkedArrayQueue.poll();
                            subscriber.onNext(spscLinkedArrayQueue.poll());
                            j13++;
                        } else {
                            return;
                        }
                    }
                    if (j13 != 0) {
                        BackpressureHelper.produced(this.f15875i, j13);
                    }
                    i11 = addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void cancel() {
            if (!this.f15876j) {
                this.f15876j = true;
                this.f15874h.cancel();
                if (getAndIncrement() == 0) {
                    this.f15872f.clear();
                }
            }
        }

        public void onComplete() {
            this.f15877k = true;
            b();
        }

        public void onError(Throwable th2) {
            this.f15878l = th2;
            this.f15877k = true;
            b();
        }

        public void onNext(T t11) {
            this.f15872f.offer(Long.valueOf(this.f15871e.now(this.f15870d)), t11);
            b();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15874h, subscription)) {
                this.f15874h = subscription;
                this.f15868b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15875i, j11);
                b();
            }
        }
    }

    public FlowableSkipLastTimed(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
        super(flowable);
        this.f15863d = j11;
        this.f15864e = timeUnit;
        this.f15865f = scheduler;
        this.f15866g = i11;
        this.f15867h = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new SkipLastTimedSubscriber(subscriber, this.f15863d, this.f15864e, this.f15865f, this.f15866g, this.f15867h));
    }
}
