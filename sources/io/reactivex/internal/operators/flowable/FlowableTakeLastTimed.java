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

public final class FlowableTakeLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15943d;

    /* renamed from: e  reason: collision with root package name */
    public final long f15944e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f15945f;

    /* renamed from: g  reason: collision with root package name */
    public final Scheduler f15946g;

    /* renamed from: h  reason: collision with root package name */
    public final int f15947h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f15948i;

    public static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15949b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15950c;

        /* renamed from: d  reason: collision with root package name */
        public final long f15951d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f15952e;

        /* renamed from: f  reason: collision with root package name */
        public final Scheduler f15953f;

        /* renamed from: g  reason: collision with root package name */
        public final SpscLinkedArrayQueue<Object> f15954g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f15955h;

        /* renamed from: i  reason: collision with root package name */
        public Subscription f15956i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicLong f15957j = new AtomicLong();

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f15958k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f15959l;

        /* renamed from: m  reason: collision with root package name */
        public Throwable f15960m;

        public TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
            this.f15949b = subscriber;
            this.f15950c = j11;
            this.f15951d = j12;
            this.f15952e = timeUnit;
            this.f15953f = scheduler;
            this.f15954g = new SpscLinkedArrayQueue<>(i11);
            this.f15955h = z11;
        }

        public boolean a(boolean z11, Subscriber<? super T> subscriber, boolean z12) {
            if (this.f15958k) {
                this.f15954g.clear();
                return true;
            } else if (!z12) {
                Throwable th2 = this.f15960m;
                if (th2 != null) {
                    this.f15954g.clear();
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
                Throwable th3 = this.f15960m;
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
                Subscriber<? super T> subscriber = this.f15949b;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f15954g;
                boolean z12 = this.f15955h;
                int i11 = 1;
                do {
                    if (this.f15959l) {
                        if (!a(spscLinkedArrayQueue.isEmpty(), subscriber, z12)) {
                            long j11 = this.f15957j.get();
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
                                        BackpressureHelper.produced(this.f15957j, j12);
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
            long j12 = this.f15951d;
            long j13 = this.f15950c;
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
            if (!this.f15958k) {
                this.f15958k = true;
                this.f15956i.cancel();
                if (getAndIncrement() == 0) {
                    this.f15954g.clear();
                }
            }
        }

        public void onComplete() {
            c(this.f15953f.now(this.f15952e), this.f15954g);
            this.f15959l = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f15955h) {
                c(this.f15953f.now(this.f15952e), this.f15954g);
            }
            this.f15960m = th2;
            this.f15959l = true;
            b();
        }

        public void onNext(T t11) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f15954g;
            long now = this.f15953f.now(this.f15952e);
            spscLinkedArrayQueue.offer(Long.valueOf(now), t11);
            c(now, spscLinkedArrayQueue);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15956i, subscription)) {
                this.f15956i = subscription;
                this.f15949b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15957j, j11);
                b();
            }
        }
    }

    public FlowableTakeLastTimed(Flowable<T> flowable, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, int i11, boolean z11) {
        super(flowable);
        this.f15943d = j11;
        this.f15944e = j12;
        this.f15945f = timeUnit;
        this.f15946g = scheduler;
        this.f15947h = i11;
        this.f15948i = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new TakeLastTimedSubscriber(subscriber, this.f15943d, this.f15944e, this.f15945f, this.f15946g, this.f15947h, this.f15948i));
    }
}
