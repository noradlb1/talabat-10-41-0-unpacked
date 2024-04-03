package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;

public interface CompletableObserver {
    void onComplete();

    void onError(@NonNull Throwable th2);

    void onSubscribe(@NonNull Disposable disposable);
}
