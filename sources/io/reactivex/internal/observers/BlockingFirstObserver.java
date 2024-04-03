package io.reactivex.internal.observers;

public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    public void onError(Throwable th2) {
        if (this.f14536b == null) {
            this.f14537c = th2;
        }
        countDown();
    }

    public void onNext(T t11) {
        if (this.f14536b == null) {
            this.f14536b = t11;
            this.f14538d.dispose();
            countDown();
        }
    }
}
