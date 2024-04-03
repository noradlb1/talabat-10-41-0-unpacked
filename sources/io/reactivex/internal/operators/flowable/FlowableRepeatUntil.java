package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatUntil<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final BooleanSupplier f15700d;

    public static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15701b;

        /* renamed from: c  reason: collision with root package name */
        public final SubscriptionArbiter f15702c;

        /* renamed from: d  reason: collision with root package name */
        public final Publisher<? extends T> f15703d;

        /* renamed from: e  reason: collision with root package name */
        public final BooleanSupplier f15704e;

        /* renamed from: f  reason: collision with root package name */
        public long f15705f;

        public RepeatSubscriber(Subscriber<? super T> subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f15701b = subscriber;
            this.f15702c = subscriptionArbiter;
            this.f15703d = publisher;
            this.f15704e = booleanSupplier;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f15702c.isCancelled()) {
                    long j11 = this.f15705f;
                    if (j11 != 0) {
                        this.f15705f = 0;
                        this.f15702c.produced(j11);
                    }
                    this.f15703d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            try {
                if (this.f15704e.getAsBoolean()) {
                    this.f15701b.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f15701b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            this.f15701b.onError(th2);
        }

        public void onNext(T t11) {
            this.f15705f++;
            this.f15701b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f15702c.setSubscription(subscription);
        }
    }

    public FlowableRepeatUntil(Flowable<T> flowable, BooleanSupplier booleanSupplier) {
        super(flowable);
        this.f15700d = booleanSupplier;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new RepeatSubscriber(subscriber, this.f15700d, subscriptionArbiter, this.f14763c).a();
    }
}
