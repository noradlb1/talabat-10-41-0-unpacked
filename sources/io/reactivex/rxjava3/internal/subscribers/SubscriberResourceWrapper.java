package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, Disposable, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super T> f23166b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Subscription> f23167c = new AtomicReference<>();

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.f23166b = subscriber;
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.f23167c);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.f23167c.get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        DisposableHelper.dispose(this);
        this.f23166b.onComplete();
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this);
        this.f23166b.onError(th2);
    }

    public void onNext(T t11) {
        this.f23166b.onNext(t11);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f23167c, subscription)) {
            this.f23166b.onSubscribe(this);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            this.f23167c.get().request(j11);
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
