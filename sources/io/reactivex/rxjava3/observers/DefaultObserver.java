package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;

public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable upstream;

    public void a() {
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.validate(this.upstream, disposable, getClass())) {
            this.upstream = disposable;
            a();
        }
    }
}
