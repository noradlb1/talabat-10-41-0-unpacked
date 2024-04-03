package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;

public final class ObservableFirstStageObserver<T> extends ObservableStageObserver<T> {

    /* renamed from: d  reason: collision with root package name */
    public final boolean f18922d;

    /* renamed from: e  reason: collision with root package name */
    public final T f18923e;

    public ObservableFirstStageObserver(boolean z11, T t11) {
        this.f18922d = z11;
        this.f18923e = t11;
    }

    public void onComplete() {
        if (!isDone()) {
            a();
            if (this.f18922d) {
                complete(this.f18923e);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    public void onNext(T t11) {
        complete(t11);
    }
}
