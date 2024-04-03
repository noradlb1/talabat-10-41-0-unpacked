package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRetryPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super Throwable> f15754d;

    /* renamed from: e  reason: collision with root package name */
    public final long f15755e;

    public static final class RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15756b;

        /* renamed from: c  reason: collision with root package name */
        public final SubscriptionArbiter f15757c;

        /* renamed from: d  reason: collision with root package name */
        public final Publisher<? extends T> f15758d;

        /* renamed from: e  reason: collision with root package name */
        public final Predicate<? super Throwable> f15759e;

        /* renamed from: f  reason: collision with root package name */
        public long f15760f;

        /* renamed from: g  reason: collision with root package name */
        public long f15761g;

        public RetrySubscriber(Subscriber<? super T> subscriber, long j11, Predicate<? super Throwable> predicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.f15756b = subscriber;
            this.f15757c = subscriptionArbiter;
            this.f15758d = publisher;
            this.f15759e = predicate;
            this.f15760f = j11;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                while (!this.f15757c.isCancelled()) {
                    long j11 = this.f15761g;
                    if (j11 != 0) {
                        this.f15761g = 0;
                        this.f15757c.produced(j11);
                    }
                    this.f15758d.subscribe(this);
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.f15756b.onComplete();
        }

        public void onError(Throwable th2) {
            long j11 = this.f15760f;
            if (j11 != Long.MAX_VALUE) {
                this.f15760f = j11 - 1;
            }
            if (j11 == 0) {
                this.f15756b.onError(th2);
                return;
            }
            try {
                if (!this.f15759e.test(th2)) {
                    this.f15756b.onError(th2);
                } else {
                    a();
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f15756b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f15761g++;
            this.f15756b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f15757c.setSubscription(subscription);
        }
    }

    public FlowableRetryPredicate(Flowable<T> flowable, long j11, Predicate<? super Throwable> predicate) {
        super(flowable);
        this.f15754d = predicate;
        this.f15755e = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new RetrySubscriber(subscriber, this.f15755e, this.f15754d, subscriptionArbiter, this.f14763c).a();
    }
}
