package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

public interface Emitter<T> {
    void onComplete();

    void onError(@NonNull Throwable th2);

    void onNext(@NonNull T t11);
}
