package io.reactivex.rxjava3.operators;

import io.reactivex.rxjava3.annotations.Nullable;

public interface SimplePlainQueue<T> extends SimpleQueue<T> {
    @Nullable
    T poll();
}
