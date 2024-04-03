package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableFirstStageSubscriber<T> extends FlowableStageSubscriber<T> {

    /* renamed from: d  reason: collision with root package name */
    public final boolean f18839d;

    /* renamed from: e  reason: collision with root package name */
    public final T f18840e;

    public FlowableFirstStageSubscriber(boolean z11, T t11) {
        this.f18839d = z11;
        this.f18840e = t11;
    }

    public void a(Subscription subscription) {
        subscription.request(1);
    }

    public void onComplete() {
        if (!isDone()) {
            c();
            if (this.f18839d) {
                complete(this.f18840e);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    public void onNext(T t11) {
        complete(t11);
    }
}
