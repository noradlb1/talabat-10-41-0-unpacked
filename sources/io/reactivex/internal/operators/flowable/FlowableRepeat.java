package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeat<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15694d;

    public static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15695b;

        /* renamed from: c  reason: collision with root package name */
        public final SubscriptionArbiter f15696c;

        /* renamed from: d  reason: collision with root package name */
        public final Publisher<? extends T> f15697d;

        /* renamed from: e  reason: collision with root package name */
        public long f15698e;

        /* renamed from: f  reason: collision with root package name */
        public long f15699f;

        public RepeatSubscriber(Subscriber<? super T> subscriber, long j11, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f15695b = subscriber;
            this.f15696c = subscriptionArbiter;
            this.f15697d = publisher;
            this.f15698e = j11;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f15696c.isCancelled()) {
                    long j11 = this.f15699f;
                    if (j11 != 0) {
                        this.f15699f = 0;
                        this.f15696c.produced(j11);
                    }
                    this.f15697d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            long j11 = this.f15698e;
            if (j11 != Long.MAX_VALUE) {
                this.f15698e = j11 - 1;
            }
            if (j11 != 0) {
                a();
            } else {
                this.f15695b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            this.f15695b.onError(th2);
        }

        public void onNext(T t11) {
            this.f15699f++;
            this.f15695b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f15696c.setSubscription(subscription);
        }
    }

    public FlowableRepeat(Flowable<T> flowable, long j11) {
        super(flowable);
        this.f15694d = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        long j11 = this.f15694d;
        long j12 = Long.MAX_VALUE;
        if (j11 != Long.MAX_VALUE) {
            j12 = j11 - 1;
        }
        new RepeatSubscriber(subscriber, j12, subscriptionArbiter, this.f14763c).a();
    }
}
