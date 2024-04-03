package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Subscription> f23475b = new AtomicReference<>();

    public final void a() {
        dispose();
    }

    public void b() {
        this.f23475b.get().request(Long.MAX_VALUE);
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.f23475b);
    }

    public final boolean isDisposed() {
        return this.f23475b.get() == SubscriptionHelper.CANCELLED;
    }

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.setOnce(this.f23475b, subscription, getClass())) {
            b();
        }
    }
}
