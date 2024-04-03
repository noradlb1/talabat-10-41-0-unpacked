package io.reactivex.internal.subscribers;

import io.reactivex.plugins.RxJavaPlugins;

public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onError(Throwable th2) {
        if (this.f18556b == null) {
            this.f18557c = th2;
        } else {
            RxJavaPlugins.onError(th2);
        }
        countDown();
    }

    public void onNext(T t11) {
        if (this.f18556b == null) {
            this.f18556b = t11;
            this.f18558d.cancel();
            countDown();
        }
    }
}
