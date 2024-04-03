package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;

public final class ObservableLastStageObserver<T> extends ObservableStageObserver<T> {

    /* renamed from: d  reason: collision with root package name */
    public final boolean f18940d;

    /* renamed from: e  reason: collision with root package name */
    public final T f18941e;

    public ObservableLastStageObserver(boolean z11, T t11) {
        this.f18940d = z11;
        this.f18941e = t11;
    }

    public void onComplete() {
        if (!isDone()) {
            T t11 = this.f18948c;
            a();
            if (t11 != null) {
                complete(t11);
            } else if (this.f18940d) {
                complete(this.f18941e);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    public void onNext(T t11) {
        this.f18948c = t11;
    }
}
