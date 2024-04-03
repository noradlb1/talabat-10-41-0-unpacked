package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20438d;

    public static final class TakeSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2288246011222124525L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20439b;

        /* renamed from: c  reason: collision with root package name */
        public long f20440c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20441d;

        public TakeSubscriber(Subscriber<? super T> subscriber, long j11) {
            this.f20439b = subscriber;
            this.f20440c = j11;
            lazySet(j11);
        }

        public void cancel() {
            this.f20441d.cancel();
        }

        public void onComplete() {
            if (this.f20440c > 0) {
                this.f20440c = 0;
                this.f20439b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20440c > 0) {
                this.f20440c = 0;
                this.f20439b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f20440c;
            if (j11 > 0) {
                long j12 = j11 - 1;
                this.f20440c = j12;
                this.f20439b.onNext(t11);
                if (j12 == 0) {
                    this.f20441d.cancel();
                    this.f20439b.onComplete();
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (!SubscriptionHelper.validate(this.f20441d, subscription)) {
                return;
            }
            if (this.f20440c == 0) {
                subscription.cancel();
                EmptySubscription.complete(this.f20439b);
                return;
            }
            this.f20441d = subscription;
            this.f20439b.onSubscribe(this);
        }

        public void request(long j11) {
            long j12;
            long min;
            if (SubscriptionHelper.validate(j11)) {
                do {
                    j12 = get();
                    if (j12 != 0) {
                        min = Math.min(j12, j11);
                    } else {
                        return;
                    }
                } while (!compareAndSet(j12, j12 - min));
                this.f20441d.request(min);
            }
        }
    }

    public FlowableTake(Flowable<T> flowable, long j11) {
        super(flowable);
        this.f20438d = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new TakeSubscriber(subscriber, this.f20438d));
    }
}
