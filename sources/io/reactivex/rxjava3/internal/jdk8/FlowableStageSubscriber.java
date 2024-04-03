package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

abstract class FlowableStageSubscriber<T> extends CompletableFuture<T> implements FlowableSubscriber<T> {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Subscription> f18875b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public T f18876c;

    public abstract void a(Subscription subscription);

    public final void b() {
        SubscriptionHelper.cancel(this.f18875b);
    }

    public final void c() {
        this.f18876c = null;
        this.f18875b.lazySet(SubscriptionHelper.CANCELLED);
    }

    public final boolean cancel(boolean z11) {
        b();
        return super.cancel(z11);
    }

    public final boolean complete(T t11) {
        b();
        return super.complete(t11);
    }

    public final boolean completeExceptionally(Throwable th2) {
        b();
        return super.completeExceptionally(th2);
    }

    public final void onError(Throwable th2) {
        c();
        if (!completeExceptionally(th2)) {
            RxJavaPlugins.onError(th2);
        }
    }

    public final void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f18875b, subscription)) {
            a(subscription);
        }
    }
}
