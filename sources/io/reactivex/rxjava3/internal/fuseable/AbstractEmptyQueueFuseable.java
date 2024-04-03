package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.QueueSubscription;

public abstract class AbstractEmptyQueueFuseable<T> implements QueueSubscription<T>, QueueDisposable<T> {
    public void cancel() {
    }

    public final void clear() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return false;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final boolean offer(@NonNull T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final T poll() throws Throwable {
        return null;
    }

    public final void request(long j11) {
    }

    public final int requestFusion(int i11) {
        return i11 & 2;
    }

    public final boolean offer(@NonNull T t11, @NonNull T t12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
