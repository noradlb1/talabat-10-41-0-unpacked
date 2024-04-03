package io.reactivex.internal.observers;

public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    public void onError(Throwable th2) {
        this.f14536b = null;
        this.f14537c = th2;
        countDown();
    }

    public void onNext(T t11) {
        this.f14536b = t11;
    }
}
