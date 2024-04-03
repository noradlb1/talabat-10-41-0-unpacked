package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLast<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final int f15859d;

    public static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3807491841935125653L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15860b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15861c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15862d;

        public SkipLastSubscriber(Subscriber<? super T> subscriber, int i11) {
            super(i11);
            this.f15860b = subscriber;
            this.f15861c = i11;
        }

        public void cancel() {
            this.f15862d.cancel();
        }

        public void onComplete() {
            this.f15860b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15860b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f15861c == size()) {
                this.f15860b.onNext(poll());
            } else {
                this.f15862d.request(1);
            }
            offer(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15862d, subscription)) {
                this.f15862d = subscription;
                this.f15860b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15862d.request(j11);
        }
    }

    public FlowableSkipLast(Flowable<T> flowable, int i11) {
        super(flowable);
        this.f15859d = i11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new SkipLastSubscriber(subscriber, this.f15859d));
    }
}
