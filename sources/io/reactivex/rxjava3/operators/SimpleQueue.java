package io.reactivex.rxjava3.operators;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(@NonNull T t11);

    boolean offer(@NonNull T t11, @NonNull T t12);

    @Nullable
    T poll() throws Throwable;
}
