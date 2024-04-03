package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

public final class FlowableSingleStageSubscriber<T> extends FlowableStageSubscriber<T> {

    /* renamed from: d  reason: collision with root package name */
    public final boolean f18873d;

    /* renamed from: e  reason: collision with root package name */
    public final T f18874e;

    public FlowableSingleStageSubscriber(boolean z11, T t11) {
        this.f18873d = z11;
        this.f18874e = t11;
    }

    public void a(Subscription subscription) {
        subscription.request(2);
    }

    public void onComplete() {
        if (!isDone()) {
            T t11 = this.f18876c;
            c();
            if (t11 != null) {
                complete(t11);
            } else if (this.f18873d) {
                complete(this.f18874e);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    public void onNext(T t11) {
        if (this.f18876c != null) {
            this.f18876c = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
            return;
        }
        this.f18876c = t11;
    }
}
