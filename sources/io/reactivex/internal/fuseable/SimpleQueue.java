package io.reactivex.internal.fuseable;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(@NonNull T t11);

    boolean offer(@NonNull T t11, @NonNull T t12);

    @Nullable
    T poll() throws Exception;
}
