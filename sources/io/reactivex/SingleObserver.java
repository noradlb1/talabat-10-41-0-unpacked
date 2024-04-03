package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public interface SingleObserver<T> {
    void onError(@NonNull Throwable th2);

    void onSubscribe(@NonNull Disposable disposable);

    void onSuccess(@NonNull T t11);
}
