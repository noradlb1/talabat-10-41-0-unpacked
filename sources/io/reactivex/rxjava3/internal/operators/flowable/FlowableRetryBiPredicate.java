package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryBiPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final BiPredicate<? super Integer, ? super Throwable> f20257d;

    public static final class RetryBiSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20258b;

        /* renamed from: c  reason: collision with root package name */
        public final SubscriptionArbiter f20259c;

        /* renamed from: d  reason: collision with root package name */
        public final Publisher<? extends T> f20260d;

        /* renamed from: e  reason: collision with root package name */
        public final BiPredicate<? super Integer, ? super Throwable> f20261e;

        /* renamed from: f  reason: collision with root package name */
        public int f20262f;

        /* renamed from: g  reason: collision with root package name */
        public long f20263g;

        public RetryBiSubscriber(Subscriber<? super T> subscriber, BiPredicate<? super Integer, ? super Throwable> biPredicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f20258b = subscriber;
            this.f20259c = subscriptionArbiter;
            this.f20260d = publisher;
            this.f20261e = biPredicate;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f20259c.isCancelled()) {
                    long j11 = this.f20263g;
                    if (j11 != 0) {
                        this.f20263g = 0;
                        this.f20259c.produced(j11);
                    }
                    this.f20260d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.f20258b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                BiPredicate<? super Integer, ? super Throwable> biPredicate = this.f20261e;
                int i11 = this.f20262f + 1;
                this.f20262f = i11;
                if (!biPredicate.test(Integer.valueOf(i11), th2)) {
                    this.f20258b.onError(th2);
                } else {
                    a();
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f20258b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f20263g++;
            this.f20258b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f20259c.setSubscription(subscription);
        }
    }

    public FlowableRetryBiPredicate(Flowable<T> flowable, BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        super(flowable);
        this.f20257d = biPredicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new RetryBiSubscriber(subscriber, this.f20257d, subscriptionArbiter, this.f19260c).a();
    }
}
