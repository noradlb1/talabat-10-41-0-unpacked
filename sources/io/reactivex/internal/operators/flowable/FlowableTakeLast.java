package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLast<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final int f15934d;

    public static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7240042530241604978L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15935b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15936c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15937d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f15938e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f15939f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f15940g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f15941h = new AtomicInteger();

        public TakeLastSubscriber(Subscriber<? super T> subscriber, int i11) {
            this.f15935b = subscriber;
            this.f15936c = i11;
        }

        public void a() {
            if (this.f15941h.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f15935b;
                long j11 = this.f15940g.get();
                while (!this.f15939f) {
                    if (this.f15938e) {
                        long j12 = 0;
                        while (j12 != j11) {
                            if (!this.f15939f) {
                                Object poll = poll();
                                if (poll == null) {
                                    subscriber.onComplete();
                                    return;
                                } else {
                                    subscriber.onNext(poll);
                                    j12++;
                                }
                            } else {
                                return;
                            }
                        }
                        if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                            j11 = this.f15940g.addAndGet(-j12);
                        }
                    }
                    if (this.f15941h.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void cancel() {
            this.f15939f = true;
            this.f15937d.cancel();
        }

        public void onComplete() {
            this.f15938e = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f15935b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f15936c == size()) {
                poll();
            }
            offer(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15937d, subscription)) {
                this.f15937d = subscription;
                this.f15935b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15940g, j11);
                a();
            }
        }
    }

    public FlowableTakeLast(Flowable<T> flowable, int i11) {
        super(flowable);
        this.f15934d = i11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new TakeLastSubscriber(subscriber, this.f15934d));
    }
}
