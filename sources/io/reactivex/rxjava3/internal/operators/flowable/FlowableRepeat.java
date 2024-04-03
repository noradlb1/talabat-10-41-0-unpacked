package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeat<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20201d;

    public static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20202b;

        /* renamed from: c  reason: collision with root package name */
        public final SubscriptionArbiter f20203c;

        /* renamed from: d  reason: collision with root package name */
        public final Publisher<? extends T> f20204d;

        /* renamed from: e  reason: collision with root package name */
        public long f20205e;

        /* renamed from: f  reason: collision with root package name */
        public long f20206f;

        public RepeatSubscriber(Subscriber<? super T> subscriber, long j11, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f20202b = subscriber;
            this.f20203c = subscriptionArbiter;
            this.f20204d = publisher;
            this.f20205e = j11;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f20203c.isCancelled()) {
                    long j11 = this.f20206f;
                    if (j11 != 0) {
                        this.f20206f = 0;
                        this.f20203c.produced(j11);
                    }
                    this.f20204d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            long j11 = this.f20205e;
            if (j11 != Long.MAX_VALUE) {
                this.f20205e = j11 - 1;
            }
            if (j11 != 0) {
                a();
            } else {
                this.f20202b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f20202b.onError(th2);
        }

        public void onNext(T t11) {
            this.f20206f++;
            this.f20202b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f20203c.setSubscription(subscription);
        }
    }

    public FlowableRepeat(Flowable<T> flowable, long j11) {
        super(flowable);
        this.f20201d = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        long j11 = this.f20201d;
        long j12 = Long.MAX_VALUE;
        if (j11 != Long.MAX_VALUE) {
            j12 = j11 - 1;
        }
        new RepeatSubscriber(subscriber, j12, subscriptionArbiter, this.f19260c).a();
    }
}
