package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 2984505488220891551L;

    /* renamed from: d  reason: collision with root package name */
    public Subscription f23125d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23126e;

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    public void cancel() {
        super.cancel();
        this.f23125d.cancel();
    }

    public void onComplete() {
        if (this.f23126e) {
            complete(this.f23171c);
        } else {
            this.f23170b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.f23171c = null;
        this.f23170b.onError(th2);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f23125d, subscription)) {
            this.f23125d = subscription;
            this.f23170b.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
