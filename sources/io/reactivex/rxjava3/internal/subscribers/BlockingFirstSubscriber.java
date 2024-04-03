package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onError(Throwable th2) {
        if (this.f23113b == null) {
            this.f23114c = th2;
        } else {
            RxJavaPlugins.onError(th2);
        }
        countDown();
    }

    public void onNext(T t11) {
        if (this.f23113b == null) {
            this.f23113b = t11;
            this.f23115d.cancel();
            countDown();
        }
    }
}
