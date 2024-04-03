package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class AsyncSubscription extends AtomicLong implements Subscription, Disposable {
    private static final long serialVersionUID = 7028635084060361255L;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Subscription> f23168b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Disposable> f23169c;

    public AsyncSubscription() {
        this.f23169c = new AtomicReference<>();
        this.f23168b = new AtomicReference<>();
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.f23168b);
        DisposableHelper.dispose(this.f23169c);
    }

    public boolean isDisposed() {
        return this.f23168b.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean replaceResource(Disposable disposable) {
        return DisposableHelper.replace(this.f23169c, disposable);
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.f23168b, this, j11);
    }

    public boolean setResource(Disposable disposable) {
        return DisposableHelper.set(this.f23169c, disposable);
    }

    public void setSubscription(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f23168b, this, subscription);
    }

    public AsyncSubscription(Disposable disposable) {
        this();
        this.f23169c.lazySet(disposable);
    }
}
