package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;

public final class ObservableSingleStageObserver<T> extends ObservableStageObserver<T> {

    /* renamed from: d  reason: collision with root package name */
    public final boolean f18945d;

    /* renamed from: e  reason: collision with root package name */
    public final T f18946e;

    public ObservableSingleStageObserver(boolean z11, T t11) {
        this.f18945d = z11;
        this.f18946e = t11;
    }

    public void onComplete() {
        if (!isDone()) {
            T t11 = this.f18948c;
            a();
            if (t11 != null) {
                complete(t11);
            } else if (this.f18945d) {
                complete(this.f18946e);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    public void onNext(T t11) {
        if (this.f18948c != null) {
            this.f18948c = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.f18948c = t11;
    }
}
