package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElements<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, QueueSubscription<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19914b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f19915c;

        public IgnoreElementsSubscriber(Subscriber<? super T> subscriber) {
            this.f19914b = subscriber;
        }

        public void cancel() {
            this.f19915c.cancel();
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
            this.f19914b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19914b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19915c, subscription)) {
                this.f19915c = subscription;
                this.f19914b.onSubscribe(this);
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
        this.f19260c.subscribe(new IgnoreElementsSubscriber(subscriber));
    }
}
