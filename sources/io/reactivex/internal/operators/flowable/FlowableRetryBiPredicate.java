package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryBiPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super Integer, ? super Throwable> f15747d;

    public static final class RetryBiSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15748b;

        /* renamed from: c  reason: collision with root package name */
        public final SubscriptionArbiter f15749c;

        /* renamed from: d  reason: collision with root package name */
        public final Publisher<? extends T> f15750d;

        /* renamed from: e  reason: collision with root package name */
        public final BiPredicate<? super Integer, ? super Throwable> f15751e;

        /* renamed from: f  reason: collision with root package name */
        public int f15752f;

        /* renamed from: g  reason: collision with root package name */
        public long f15753g;

        public RetryBiSubscriber(Subscriber<? super T> subscriber, BiPredicate<? super Integer, ? super Throwable> biPredicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f15748b = subscriber;
            this.f15749c = subscriptionArbiter;
            this.f15750d = publisher;
            this.f15751e = biPredicate;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f15749c.isCancelled()) {
                    long j11 = this.f15753g;
                    if (j11 != 0) {
                        this.f15753g = 0;
                        this.f15749c.produced(j11);
                    }
                    this.f15750d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.f15748b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.f15751e;
                int i11 = this.f15752f + 1;
                this.f15752f = i11;
                if (!biPredicate.test(Integer.valueOf(i11), th2)) {
                    this.f15748b.onError(th2);
                } else {
                    a();
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f15748b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f15753g++;
            this.f15748b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f15749c.setSubscription(subscription);
        }
    }

    public FlowableRetryBiPredicate(Flowable<T> flowable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(flowable);
        this.f15747d = biPredicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new RetryBiSubscriber(subscriber, this.f15747d, subscriptionArbiter, this.f14763c).a();
    }
}
