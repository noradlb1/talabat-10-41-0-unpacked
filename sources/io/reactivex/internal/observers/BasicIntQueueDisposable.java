package io.reactivex.internal.observers;

import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements QueueDisposable<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    public final boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t11, T t12) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
