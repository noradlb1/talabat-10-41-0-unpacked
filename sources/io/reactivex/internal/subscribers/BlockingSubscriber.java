package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;

    /* renamed from: b  reason: collision with root package name */
    public final Queue<Object> f18560b;

    public BlockingSubscriber(Queue<Object> queue) {
        this.f18560b = queue;
    }

    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.f18560b.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        this.f18560b.offer(NotificationLite.complete());
    }

    public void onError(Throwable th2) {
        this.f18560b.offer(NotificationLite.error(th2));
    }

    public void onNext(T t11) {
        this.f18560b.offer(NotificationLite.next(t11));
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            this.f18560b.offer(NotificationLite.subscription(this));
        }
    }

    public void request(long j11) {
        ((Subscription) get()).request(j11);
    }
}
