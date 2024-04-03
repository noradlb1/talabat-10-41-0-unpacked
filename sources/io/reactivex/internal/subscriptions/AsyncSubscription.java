package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class AsyncSubscription extends AtomicLong implements Subscription, Disposable {
    private static final long serialVersionUID = 7028635084060361255L;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Subscription> f18607b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Disposable> f18608c;

    public AsyncSubscription() {
        this.f18608c = new AtomicReference<>();
        this.f18607b = new AtomicReference<>();
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.f18607b);
        DisposableHelper.dispose(this.f18608c);
    }

    public boolean isDisposed() {
        return this.f18607b.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean replaceResource(Disposable disposable) {
        return DisposableHelper.replace(this.f18608c, disposable);
    }

    public void request(long j11) {
        SubscriptionHelper.deferredRequest(this.f18607b, this, j11);
    }

    public boolean setResource(Disposable disposable) {
        return DisposableHelper.set(this.f18608c, disposable);
    }

    public void setSubscription(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.f18607b, this, subscription);
    }

    public AsyncSubscription(Disposable disposable) {
        this();
        this.f18608c.lazySet(disposable);
    }
}
