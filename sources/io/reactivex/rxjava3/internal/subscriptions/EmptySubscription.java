package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.operators.QueueSubscription;
import org.reactivestreams.Subscriber;

public enum EmptySubscription implements QueueSubscription<Object> {
    INSTANCE;

    public static void complete(Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onComplete();
    }

    public static void error(Throwable th2, Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onError(th2);
    }

    public void cancel() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Nullable
    public Object poll() {
        return null;
    }

    public void request(long j11) {
        SubscriptionHelper.validate(j11);
    }

    public int requestFusion(int i11) {
        return i11 & 2;
    }

    public String toString() {
        return "EmptySubscription";
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
