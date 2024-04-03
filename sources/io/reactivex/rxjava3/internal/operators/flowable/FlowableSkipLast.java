package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLast<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final int f20369d;

    public static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3807491841935125653L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20370b;

        /* renamed from: c  reason: collision with root package name */
        public final int f20371c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20372d;

        public SkipLastSubscriber(Subscriber<? super T> subscriber, int i11) {
            super(i11);
            this.f20370b = subscriber;
            this.f20371c = i11;
        }

        public void cancel() {
            this.f20372d.cancel();
        }

        public void onComplete() {
            this.f20370b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20370b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f20371c == size()) {
                this.f20370b.onNext(poll());
            } else {
                this.f20372d.request(1);
            }
            offer(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20372d, subscription)) {
                this.f20372d = subscription;
                this.f20370b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20372d.request(j11);
        }
    }

    public FlowableSkipLast(Flowable<T> flowable, int i11) {
        super(flowable);
        this.f20369d = i11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new SkipLastSubscriber(subscriber, this.f20369d));
    }
}
