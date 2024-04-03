package io.reactivex.internal.subscribers;

public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onError(Throwable th2) {
        this.f18556b = null;
        this.f18557c = th2;
        countDown();
    }

    public void onNext(T t11) {
        this.f18556b = t11;
    }
}
