package io.reactivex.internal.observers;

import io.reactivex.internal.fuseable.QueueDisposable;

public abstract class BasicQueueDisposable<T> implements QueueDisposable<T> {
    public final boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
