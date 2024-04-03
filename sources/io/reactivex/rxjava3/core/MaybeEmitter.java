package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;

public interface MaybeEmitter<T> {
    boolean isDisposed();

    void onComplete();

    void onError(@NonNull Throwable th2);

    void onSuccess(@NonNull T t11);

    void setCancellable(@Nullable Cancellable cancellable);

    void setDisposable(@Nullable Disposable disposable);

    boolean tryOnError(@NonNull Throwable th2);
}
