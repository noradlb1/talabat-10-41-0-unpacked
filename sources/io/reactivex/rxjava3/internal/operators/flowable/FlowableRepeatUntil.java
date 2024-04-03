package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatUntil<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final BooleanSupplier f20207d;

    public static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20208b;

        /* renamed from: c  reason: collision with root package name */
        public final SubscriptionArbiter f20209c;

        /* renamed from: d  reason: collision with root package name */
        public final Publisher<? extends T> f20210d;

        /* renamed from: e  reason: collision with root package name */
        public final BooleanSupplier f20211e;

        /* renamed from: f  reason: collision with root package name */
        public long f20212f;

        public RepeatSubscriber(Subscriber<? super T> subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f20208b = subscriber;
            this.f20209c = subscriptionArbiter;
            this.f20210d = publisher;
            this.f20211e = booleanSupplier;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f20209c.isCancelled()) {
                    long j11 = this.f20212f;
                    if (j11 != 0) {
                        this.f20212f = 0;
                        this.f20209c.produced(j11);
                    }
                    this.f20210d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            try {
                if (this.f20211e.getAsBoolean()) {
                    this.f20208b.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20208b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            this.f20208b.onError(th2);
        }

        public void onNext(T t11) {
            this.f20212f++;
            this.f20208b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f20209c.setSubscription(subscription);
        }
    }

    public FlowableRepeatUntil(Flowable<T> flowable, BooleanSupplier booleanSupplier) {
        super(flowable);
        this.f20207d = booleanSupplier;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new RepeatSubscriber(subscriber, this.f20207d, subscriptionArbiter, this.f19260c).a();
    }
}
