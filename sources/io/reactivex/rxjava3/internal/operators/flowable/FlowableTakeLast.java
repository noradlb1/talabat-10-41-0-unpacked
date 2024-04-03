package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeLast<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final int f20442d;

    public static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7240042530241604978L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20443b;

        /* renamed from: c  reason: collision with root package name */
        public final int f20444c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20445d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f20446e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f20447f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f20448g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f20449h = new AtomicInteger();

        public TakeLastSubscriber(Subscriber<? super T> subscriber, int i11) {
            this.f20443b = subscriber;
            this.f20444c = i11;
        }

        public void a() {
            if (this.f20449h.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f20443b;
                long j11 = this.f20448g.get();
                while (!this.f20447f) {
                    if (this.f20446e) {
                        long j12 = 0;
                        while (j12 != j11) {
                            if (!this.f20447f) {
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
                        if (isEmpty()) {
                            subscriber.onComplete();
                            return;
                        } else if (j12 != 0) {
                            j11 = BackpressureHelper.produced(this.f20448g, j12);
                        }
                    }
                    if (this.f20449h.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void cancel() {
            this.f20447f = true;
            this.f20445d.cancel();
        }

        public void onComplete() {
            this.f20446e = true;
            a();
        }

        public void onError(Throwable th2) {
            this.f20443b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f20444c == size()) {
                poll();
            }
            offer(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20445d, subscription)) {
                this.f20445d = subscription;
                this.f20443b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20448g, j11);
                a();
            }
        }
    }

    public FlowableTakeLast(Flowable<T> flowable, int i11) {
        super(flowable);
        this.f20442d = i11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new TakeLastSubscriber(subscriber, this.f20442d));
    }
}
