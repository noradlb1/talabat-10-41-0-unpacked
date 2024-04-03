package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElements<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, QueueSubscription<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15398b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f15399c;

        public IgnoreElementsSubscriber(Subscriber<? super T> subscriber) {
            this.f15398b = subscriber;
        }

        public void cancel() {
            this.f15399c.cancel();
        }

        public void clear() {
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean offer(T t11) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public void onComplete() {
            this.f15398b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15398b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15399c, subscription)) {
                this.f15399c = subscription;
                this.f15398b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Nullable
        public T poll() {
            return null;
        }

        public void request(long j11) {
        }

        public int requestFusion(int i11) {
            return i11 & 2;
        }

        public boolean offer(T t11, T t12) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public FlowableIgnoreElements(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new IgnoreElementsSubscriber(subscriber));
    }
}
