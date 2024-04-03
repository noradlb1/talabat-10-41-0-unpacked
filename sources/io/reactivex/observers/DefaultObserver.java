package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.EndConsumerHelper;

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
