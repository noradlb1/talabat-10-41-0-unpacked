package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface FutureCallback<V> {
    void onFailure(Throwable th2);

    void onSuccess(@ParametricNullness V v11);
}
