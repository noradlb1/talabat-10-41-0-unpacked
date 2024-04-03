package io.reactivex.functions;

import io.reactivex.annotations.NonNull;

public interface Function<T, R> {
    R apply(@NonNull T t11) throws Exception;
}
