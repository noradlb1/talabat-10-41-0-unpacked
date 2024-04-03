package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15855d;

    public static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15856b;

        /* renamed from: c  reason: collision with root package name */
        public long f15857c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15858d;

        public SkipSubscriber(Subscriber<? super T> subscriber, long j11) {
            this.f15856b = subscriber;
            this.f15857c = j11;
        }

        public void cancel() {
            this.f15858d.cancel();
        }

        public void onComplete() {
            this.f15856b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15856b.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f15857c;
            if (j11 != 0) {
                this.f15857c = j11 - 1;
            } else {
                this.f15856b.onNext(t11);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15858d, subscription)) {
                long j11 = this.f15857c;
                this.f15858d = subscription;
                this.f15856b.onSubscribe(this);
                subscription.request(j11);
            }
        }

        public void request(long j11) {
            this.f15858d.request(j11);
        }
    }

    public FlowableSkip(Flowable<T> flowable, long j11) {
        super(flowable);
        this.f15855d = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new SkipSubscriber(subscriber, this.f15855d));
    }
}
