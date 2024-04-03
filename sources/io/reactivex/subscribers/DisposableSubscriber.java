package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Subscription> f23670b = new AtomicReference<>();

    public final void a() {
        dispose();
    }

    public void b() {
        this.f23670b.get().request(Long.MAX_VALUE);
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.f23670b);
    }

    public final boolean isDisposed() {
        return this.f23670b.get() == SubscriptionHelper.CANCELLED;
    }

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.setOnce(this.f23670b, subscription, getClass())) {
            b();
        }
    }
}
