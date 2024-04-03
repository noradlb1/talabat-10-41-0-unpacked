package io.reactivex;

import io.reactivex.annotations.NonNull;

public interface Emitter<T> {
    void onComplete();

    void onError(@NonNull Throwable th2);

    void onNext(@NonNull T t11);
}
