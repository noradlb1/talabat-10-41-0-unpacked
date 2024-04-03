package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20365d;

    public static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20366b;

        /* renamed from: c  reason: collision with root package name */
        public long f20367c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20368d;

        public SkipSubscriber(Subscriber<? super T> subscriber, long j11) {
            this.f20366b = subscriber;
            this.f20367c = j11;
        }

        public void cancel() {
            this.f20368d.cancel();
        }

        public void onComplete() {
            this.f20366b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20366b.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f20367c;
            if (j11 != 0) {
                this.f20367c = j11 - 1;
            } else {
                this.f20366b.onNext(t11);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20368d, subscription)) {
                long j11 = this.f20367c;
                this.f20368d = subscription;
                this.f20366b.onSubscribe(this);
                subscription.request(j11);
            }
        }

        public void request(long j11) {
            this.f20368d.request(j11);
        }
    }

    public FlowableSkip(Flowable<T> flowable, long j11) {
        super(flowable);
        this.f20365d = j11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new SkipSubscriber(subscriber, this.f20365d));
    }
}
