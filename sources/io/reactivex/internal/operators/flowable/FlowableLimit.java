package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableLimit<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15460d;

    public static final class LimitSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2288246011222124525L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15461b;

        /* renamed from: c  reason: collision with root package name */
        public long f15462c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15463d;

        public LimitSubscriber(Subscriber<? super T> subscriber, long j11) {
            this.f15461b = subscriber;
            this.f15462c = j11;
            lazySet(j11);
        }

        public void cancel() {
            this.f15463d.cancel();
        }

        public void onComplete() {
            if (this.f15462c > 0) {
                this.f15462c = 0;
                this.f15461b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15462c > 0) {
                this.f15462c = 0;
                this.f15461b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f15462c;
            if (j11 > 0) {
                long j12 = j11 - 1;
                this.f15462c = j12;
                this.f15461b.onNext(t11);
                if (j12 == 0) {
                    this.f15463d.cancel();
                    this.f15461b.onComplete();
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (!SubscriptionHelper.validate(this.f15463d, subscription)) {
                return;
            }
            if (this.f15462c == 0) {
                subscription.cancel();
                EmptySubscription.complete(this.f15461b);
                return;
            }
            this.f15463d = subscription;
            this.f15461b.onSubscribe(this);
        }

        public void request(long j11) {
            long j12;
            long j13;
            if (SubscriptionHelper.validate(j11)) {
                do {
                    j12 = get();
                    if (j12 != 0) {
                        if (j12 <= j11) {
                            j13 = j12;
                        } else {
                            j13 = j11;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j12, j12 - j13));
                this.f15463d.request(j13);
            }
        }
    }

    public FlowableLimit(Flowable<T> flowable, long j11) {
        super(flowable);
        this.f15460d = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new LimitSubscriber(subscriber, this.f15460d));
    }
}
