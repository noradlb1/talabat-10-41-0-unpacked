package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.operators.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    public final boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
