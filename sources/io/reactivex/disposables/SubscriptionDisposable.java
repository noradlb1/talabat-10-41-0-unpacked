package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import org.reactivestreams.Subscription;

final class SubscriptionDisposable extends ReferenceDisposable<Subscription> {
    private static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(Subscription subscription) {
        super(subscription);
    }

    /* renamed from: b */
    public void a(@NonNull Subscription subscription) {
        subscription.cancel();
    }
}
