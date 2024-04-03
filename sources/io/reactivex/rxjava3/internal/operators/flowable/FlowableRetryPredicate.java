package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super Throwable> f20264d;

    /* renamed from: e  reason: collision with root package name */
    public final long f20265e;

    public static final class RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20266b;

        /* renamed from: c  reason: collision with root package name */
        public final SubscriptionArbiter f20267c;

        /* renamed from: d  reason: collision with root package name */
        public final Publisher<? extends T> f20268d;

        /* renamed from: e  reason: collision with root package name */
        public final Predicate<? super Throwable> f20269e;

        /* renamed from: f  reason: collision with root package name */
        public long f20270f;

        /* renamed from: g  reason: collision with root package name */
        public long f20271g;

        public RetrySubscriber(Subscriber<? super T> subscriber, long j11, Predicate<? super Throwable> predicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f20266b = subscriber;
            this.f20267c = subscriptionArbiter;
            this.f20268d = publisher;
            this.f20269e = predicate;
            this.f20270f = j11;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f20267c.isCancelled()) {
                    long j11 = this.f20271g;
                    if (j11 != 0) {
                        this.f20271g = 0;
                        this.f20267c.produced(j11);
                    }
                    this.f20268d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.f20266b.onComplete();
        }

        public void onError(Throwable th2) {
            long j11 = this.f20270f;
            if (j11 != Long.MAX_VALUE) {
                this.f20270f = j11 - 1;
            }
            if (j11 == 0) {
                this.f20266b.onError(th2);
                return;
            }
            try {
                if (!this.f20269e.test(th2)) {
                    this.f20266b.onError(th2);
                } else {
                    a();
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f20266b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f20271g++;
            this.f20266b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f20267c.setSubscription(subscription);
        }
    }

    public FlowableRetryPredicate(Flowable<T> flowable, long j11, Predicate<? super Throwable> predicate) {
        super(flowable);
        this.f20264d = predicate;
        this.f20265e = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new RetrySubscriber(subscriber, this.f20265e, this.f20264d, subscriptionArbiter, this.f19260c).a();
    }
}
