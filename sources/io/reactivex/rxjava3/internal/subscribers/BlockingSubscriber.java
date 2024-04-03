package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;

    /* renamed from: b  reason: collision with root package name */
    public final Queue<Object> f23117b;

    public BlockingSubscriber(Queue<Object> queue) {
        this.f23117b = queue;
    }

    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.f23117b.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        this.f23117b.offer(NotificationLite.complete());
    }

    public void onError(Throwable th2) {
        this.f23117b.offer(NotificationLite.error(th2));
    }

    public void onNext(T t11) {
        this.f23117b.offer(NotificationLite.next(t11));
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            this.f23117b.offer(NotificationLite.subscription(this));
        }
    }

    public void request(long j11) {
        ((Subscription) get()).request(j11);
    }
}
