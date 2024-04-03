package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableLastStageSubscriber<T> extends FlowableStageSubscriber<T> {

    /* renamed from: d  reason: collision with root package name */
    public final boolean f18867d;

    /* renamed from: e  reason: collision with root package name */
    public final T f18868e;

    public FlowableLastStageSubscriber(boolean z11, T t11) {
        this.f18867d = z11;
        this.f18868e = t11;
    }

    public void a(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    public void onComplete() {
        if (!isDone()) {
            T t11 = this.f18876c;
            c();
            if (t11 != null) {
                complete(t11);
            } else if (this.f18867d) {
                complete(this.f18868e);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    public void onNext(T t11) {
        this.f18876c = t11;
    }
}
