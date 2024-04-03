package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public interface CompletableObserver {
    void onComplete();

    void onError(@NonNull Throwable th2);

    void onSubscribe(@NonNull Disposable disposable);
}
