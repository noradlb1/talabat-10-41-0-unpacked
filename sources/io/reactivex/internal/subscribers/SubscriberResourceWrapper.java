package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, Disposable, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super T> f18605b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Subscription> f18606c = new AtomicReference<>();

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.f18605b = subscriber;
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.f18606c);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.f18606c.get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        DisposableHelper.dispose(this);
        this.f18605b.onComplete();
    }

    public void onError(Throwable th2) {
        DisposableHelper.dispose(this);
        this.f18605b.onError(th2);
    }

    public void onNext(T t11) {
        this.f18605b.onNext(t11);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.f18606c, subscription)) {
            this.f18605b.onSubscribe(this);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            this.f18606c.get().request(j11);
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
