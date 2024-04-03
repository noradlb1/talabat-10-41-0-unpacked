package io.reactivex.functions;

import io.reactivex.annotations.NonNull;

public interface BiPredicate<T1, T2> {
    boolean test(@NonNull T1 t12, @NonNull T2 t22) throws Exception;
}
