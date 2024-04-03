package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureError<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class BackpressureErrorSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3176480756392482682L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15568b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f15569c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f15570d;

        public BackpressureErrorSubscriber(Subscriber<? super T> subscriber) {
            this.f15568b = subscriber;
        }

        public void cancel() {
            this.f15569c.cancel();
        }

        public void onComplete() {
            if (!this.f15570d) {
                this.f15570d = true;
                this.f15568b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15570d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15570d = true;
            this.f15568b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15570d) {
                if (get() != 0) {
                    this.f15568b.onNext(t11);
                    BackpressureHelper.produced(this, 1);
                    return;
                }
                this.f15569c.cancel();
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15569c, subscription)) {
                this.f15569c = subscription;
                this.f15568b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }
    }

    public FlowableOnBackpressureError(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new BackpressureErrorSubscriber(subscriber));
    }
}
