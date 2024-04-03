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

public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20373d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f20374e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f20375f;

    /* renamed from: g  reason: collision with root package name */
    public final int f20376g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f20377h;

    public static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20378b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20379c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f20380d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f20381e;

        /* renamed from: f  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f20382f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f20383g;

        /* renamed from: h  reason: collision with root package name */
        public Subscription f20384h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicLong f20385i = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f20386j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f20387k;

        /* renamed from: l  reason: collision with root package name */
        public Throwable f20388l;

        public SkipLastTimedSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
            this.f20378b = subscriber;
            this.f20379c = j11;
            this.f20380d = timeUnit;
            this.f20381e = scheduler;
            this.f20382f = new SpscLinkedArrayQueue<>(i11);
            this.f20383g = z11;
        }

        public boolean a(boolean z11, boolean z12, Subscriber<? super T> subscriber, boolean z13) {
            if (this.f20386j) {
                this.f20382f.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!z13) {
                    Throwable th2 = this.f20388l;
                    if (th2 != null) {
                        this.f20382f.clear();
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
                    Throwable th3 = this.f20388l;
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
                Subscriber<? super T> subscriber = this.f20378b;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f20382f;
                boolean z13 = this.f20383g;
                TimeUnit timeUnit = this.f20380d;
                Scheduler scheduler = this.f20381e;
                long j11 = this.f20379c;
                int i11 = 1;
                do {
                    long j12 = this.f20385i.get();
                    long j13 = 0;
                    while (j13 != j12) {
                        boolean z14 = this.f20387k;
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
                        BackpressureHelper.produced(this.f20385i, j13);
                    }
                    i11 = addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void cancel() {
            if (!this.f20386j) {
                this.f20386j = true;
                this.f20384h.cancel();
                if (getAndIncrement() == 0) {
                    this.f20382f.clear();
                }
            }
        }

        public void onComplete() {
            this.f20387k = true;
            b();
        }

        public void onError(Throwable th2) {
            this.f20388l = th2;
            this.f20387k = true;
            b();
        }

        public void onNext(T t11) {
            this.f20382f.offer(Long.valueOf(this.f20381e.now(this.f20380d)), t11);
            b();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20384h, subscription)) {
                this.f20384h = subscription;
                this.f20378b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20385i, j11);
                b();
            }
        }
    }

    public FlowableSkipLastTimed(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
        super(flowable);
        this.f20373d = j11;
        this.f20374e = timeUnit;
        this.f20375f = scheduler;
        this.f20376g = i11;
        this.f20377h = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new SkipLastTimedSubscriber(subscriber, this.f20373d, this.f20374e, this.f20375f, this.f20376g, this.f20377h));
    }
}
